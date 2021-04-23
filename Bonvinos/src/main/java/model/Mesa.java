package model;

import java.io.Serializable;

public class Mesa implements Serializable{
	private static final long serialVersionUID = 1L;
	private int codMesa;
	private int capacidade;
	private int codRestaurante;
	private boolean disponibilidade;
	
	public Mesa(){	
	}
	public int getCodMesa() {
		return codMesa;
	}
	public void setCodMesa(int codMesa) {
		this.codMesa = codMesa;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getCodRestaurante() {
		return codRestaurante;
	}
	public void setCodRestaurante(int codRestaurante) {
		this.codRestaurante = codRestaurante;
	}
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	@Override
	public String toString() {
		return "Mesa [codMesa=" + codMesa + ", capacidade=" + capacidade + ", codRestaurante=" + codRestaurante
				+ ", disponibilidade=" + disponibilidade + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacidade;
		result = prime * result + codMesa;
		result = prime * result + codRestaurante;
		result = prime * result + (disponibilidade ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		if (capacidade != other.capacidade)
			return false;
		if (codMesa != other.codMesa)
			return false;
		if (codRestaurante != other.codRestaurante)
			return false;
		if (disponibilidade != other.disponibilidade)
			return false;
		return true;
	}
	
	
}
