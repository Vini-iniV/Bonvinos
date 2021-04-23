package model;

import java.io.Serializable;

public class Restaurante implements Serializable {
    private static final long serialVersionUID = 1L;
	private int codRestaurante;
	private String nome;
	private String descricao;
	private String enderecoRua;
	private String enderecoNumero;
	private String enderecoCEP;
	private String fone;
	private String proprietarioCNPJ;
	private String latitude;
	private String longitude;

	public Restaurante() {
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getCodRestaurante() {
		return codRestaurante;
	}

	public void setCodRestaurante(int codRestaurante) {
		this.codRestaurante = codRestaurante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEnderecoRua() {
		return enderecoRua;
	}

	public void setEnderecoRua(String enderecoRua) {
		this.enderecoRua = enderecoRua;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoCEP() {
		return enderecoCEP;
	}

	public void setEnderecoCEP(String enderecoCEP) {
		this.enderecoCEP = enderecoCEP;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getProprietarioCNPJ() {
		return proprietarioCNPJ;
	}

	public void setProprietarioCNPJ(String proprietarioCNPJ) {
		this.proprietarioCNPJ = proprietarioCNPJ;
	}
	
	@Override
	public String toString() {
		return "Restaurante [codigo=" + codRestaurante + ", nome=" + nome + ", descricao=" + descricao + ", enderecoRua=" + enderecoRua
				+ ", enderecoNumero=" + enderecoNumero + ", enderecoCEP=" + enderecoCEP + ", fone=" + fone
				+ ", proprietarioCNPJ=" + proprietarioCNPJ + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		
		if (enderecoRua == null) {
			if (other.enderecoRua != null)
				return false;
		} else if (!enderecoRua.equals(other.enderecoRua))
			return false;
		
		if (enderecoNumero == null) {
			if (other.enderecoNumero != null)
				return false;
		} else if (!enderecoNumero.equals(other.enderecoNumero))
			return false;
		
		if (enderecoCEP == null) {
			if (other.enderecoCEP != null)
				return false;
		} else if (!enderecoCEP.equals(other.enderecoCEP))
			return false;
		
		if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
			return false;
		
		if (proprietarioCNPJ != other.proprietarioCNPJ)
			return false;
		
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
