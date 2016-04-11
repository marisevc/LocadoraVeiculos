package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocacaoPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="CODIGO_AUTOMOVEL")
	private Integer codigoAutomovel;
	
	@Column(name="CODIGO")
	private Integer codigoCliente;

	public LocacaoPK() {
	}

	public Integer getCodigoAutomovel() {
		return codigoAutomovel;
	}

	public void setCodigoAutomovel(Integer codigoAutomovel) {
		this.codigoAutomovel = codigoAutomovel;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoAutomovel == null) ? 0 : codigoAutomovel.hashCode());
		result = prime * result + ((codigoCliente == null) ? 0 : codigoCliente.hashCode());
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
		LocacaoPK other = (LocacaoPK) obj;
		if (codigoAutomovel == null) {
			if (other.codigoAutomovel != null)
				return false;
		} else if (!codigoAutomovel.equals(other.codigoAutomovel))
			return false;
		if (codigoCliente == null) {
			if (other.codigoCliente != null)
				return false;
		} else if (!codigoCliente.equals(other.codigoCliente))
			return false;
		return true;
	}

}
