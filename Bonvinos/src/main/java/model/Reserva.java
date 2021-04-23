package model;

import java.io.Serializable;

public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int codReserva;
	private int codMesaReservada;
	private int codRestauranteReserva;
	private int clienteCPF;

	public Reserva() {
	}

	public int getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}

	public int getCodMesaReservada() {
		return codMesaReservada;
	}

	public void setCodMesaReservada(int codMesaReservada) {
		this.codMesaReservada = codMesaReservada;
	}

	public int getCodRestauranteReserva() {
		return codRestauranteReserva;
	}

	public void setCodRestauranteReserva(int codRestauranteReserva) {
		this.codRestauranteReserva = codRestauranteReserva;
	}

	public int getClienteCPF() {
		return clienteCPF;
	}

	public void setClienteCPF(int clienteCPF) {
		this.clienteCPF = clienteCPF;
	}

	@Override
	public String toString() {
		return "Reserva [codReserva=" + codReserva + ", codMesaReservada=" + codMesaReservada
				+ ", codRestauranteReserva=" + codRestauranteReserva + ", clienteCPF=" + clienteCPF + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (clienteCPF != other.clienteCPF)
			return false;
		if (codMesaReservada != other.codMesaReservada)
			return false;
		if (codReserva != other.codReserva)
			return false;
		if (codRestauranteReserva != other.codRestauranteReserva)
			return false;
		return true;
	}
}
