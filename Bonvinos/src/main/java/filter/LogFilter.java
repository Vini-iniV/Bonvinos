package filter;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Cliente;
import utils.Log;

@WebFilter("/*")
public class LogFilter implements Filter {

	FilterConfig filterConfig = null;
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Cliente cliente = (Cliente)session.getAttribute("cliente");
		
		String comando = req.getParameter("command");
		if(comando == null){
			comando = req.getRequestURI();
		}
		Calendar timestamp = Calendar.getInstance();
		String textoLog = "";
		ServletContext servletContext = filterConfig.getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);
		
		if (cliente == null) {

			textoLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s\n", timestamp, comando);

		} else {
			textoLog = String.format("[%1$tA, %1$tB %1$td, %1$tY %1$tZ %1$tI:%1$tM:%1$tS:%1$tL %tp] %s -> %s\n", timestamp, cliente.getCPF(), comando);
		}
		synchronized (textoLog) {
			Log arqLog = new Log();
			//arqLog.abrir(Log.NOME);
			arqLog.abrir(contextPath + File.separator + "log" + File.separator + Log.NOME);
			arqLog.escrever(textoLog);
			arqLog.fechar();
		}
		
		// Passa a requisicao pelo filtro
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
