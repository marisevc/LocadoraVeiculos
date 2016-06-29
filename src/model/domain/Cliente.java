package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO")
	private Integer codigo;
	
	@Size(min=3,message="0 Nome do cliente precisa ter pelo menos 3 caracteres")
	@NotNull(message="O campo Nome é obrigatório")
	@Column(name="NOME")
	private String nome;
	
	@NotNull(message="O campo CPF é obrigatório")
	@Pattern(regexp="/^([0-9]{11})/",message="O Campo CPF tem que ter 11 digitos sem espaços e sem pontos")
	@Column(name="CPF")
	private String cpf;
	
	@Size(min=10,message="O Endereço precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo Endereço é obrigatório")
	@Column(name="ENDERECO")
	private String endereco;
	
	@Size(min=10,message="O Endereço precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo Cidade é obrigatório")
	@Column(name="CIDADE")
	private String cidade;
	
	@NotNull(message="O campo Telefone é obrigatório")
	@Pattern(regexp="/[2-9][0-9]{4}-[0-9]{4}/",message="O Campo Telefone tem que o seguinte padrão xxxx-xxxx ")
	@Column(name="TELEFONE")
	private String telefone;
		
	public Cliente() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
