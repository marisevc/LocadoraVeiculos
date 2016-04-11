package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTOMOVEL")
public class Automovel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO_AUTOMOVEL")
	private Integer atcodigo;
			
	@Column(name="MARCA")
	private String marca;
	
	@Column(name="MODELO")
	private String modelo;
	
	public Automovel() {
		
	}	

	public Integer getCodigo() {
		return atcodigo;
	}

	public void setCodigo(Integer codigo) {
		this.atcodigo = codigo;
	}

	/*public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}*/

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atcodigo == null) ? 0 : atcodigo.hashCode());
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
		Automovel other = (Automovel) obj;
		if (atcodigo == null) {
			if (other.atcodigo != null)
				return false;
		} else if (!atcodigo.equals(other.atcodigo))
			return false;
		return true;
	}

}
