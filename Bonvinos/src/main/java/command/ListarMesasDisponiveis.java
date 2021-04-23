package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mesa;
import model.Restaurante;
import service.MesaService;

public class ListarMesasDisponiveis implements Command{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String pCodRestaurante = request.getParameter("codRestaurante");
		String pNomeRestaurante = request.getParameter("nomeRestaurante");
		String pDescricaoRestaurante = request.getParameter("descricaoRestaurante");
		String chave = request.getParameter("data[search]");
		int codRestaurante = -1;
		
		try {
			codRestaurante = Integer.parseInt(pCodRestaurante);
		}catch(NumberFormatException e) {

		}
		
		Restaurante restaurante = new Restaurante();
		restaurante.setCodRestaurante(codRestaurante);
		restaurante.setNome(pNomeRestaurante);
		restaurante.setDescricao(pDescricaoRestaurante);
		
		MesaService ms = new MesaService();
		ArrayList<Mesa> listaMesasDisponiveis = null;
		HttpSession session = request.getSession();

		if (chave != null && chave.length() > 0) {
			listaMesasDisponiveis = ms.listarMesasDisponiveis(chave, codRestaurante);
		} else {
			listaMesasDisponiveis = ms.listarMesasDisponiveis(codRestaurante);
		}
		session.setAttribute("listaMesasDisponiveis", listaMesasDisponiveis);
		session.setAttribute("restaurante", restaurante);
		

		RequestDispatcher dispatcher = request
		.getRequestDispatcher("ReservarMesas.jsp");
		dispatcher.forward(request, response);
	}
}
