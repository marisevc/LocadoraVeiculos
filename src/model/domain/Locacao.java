package model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Table(name="LOCACAO")
public class Locacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private LocacaoPK locacaoPK;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO_LOCACAO")
	private Integer codigo;
	
	@Column(name="KM")
	private String km;
	
	@Column(name="VALOR")
	private Double valor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_AUTOMOVEL",referencedColumnName="CODIGO_AUTOMOVEL",
			insertable=false,updatable=false)
	private Automovel automovel;
	
	@ManyToOne
	@JoinColumn(name="CODIGO",referencedColumnName="CODIGO",
			insertable=false,updatable=false)
	private Cliente cliente;
	
	public Locacao() {
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locacaoPK == null) ? 0 : locacaoPK.hashCode());
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
		Locacao other = (Locacao) obj;
		if (locacaoPK == null) {
			if (other.locacaoPK != null)
				return false;
		} else if (!locacaoPK.equals(other.locacaoPK))
			return false;
		return true;
	}

}
