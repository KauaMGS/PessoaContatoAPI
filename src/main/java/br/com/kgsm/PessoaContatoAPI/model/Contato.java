package br.com.kgsm.PessoaContatoAPI.model;

import java.util.Objects;

import br.com.kgsm.PessoaContatoAPI.model.enums.TipoContato;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private TipoContato tipoDeContato;
	
	@Column(nullable = false)
	private String contato;

	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;
	
	public Contato() {}

	public Contato(Long id, TipoContato tipoDeContato, String contato, Pessoa pessoa) {
		this.id = id;
		this.tipoDeContato = tipoDeContato;
		this.contato = contato;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public TipoContato getTipoDeContato() {
		return tipoDeContato;
	}
	public void setTipoDeContato(TipoContato tipoDeContato) {
		this.tipoDeContato = tipoDeContato;
	}

	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contato, id, pessoa, tipoDeContato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(contato, other.contato) && Objects.equals(id, other.id)
				&& Objects.equals(pessoa, other.pessoa) && tipoDeContato == other.tipoDeContato;
	}
	
	@Override
	public String toString() {
		return "[id = " + this.id + ", " + 
				"tipoContato = " + this.tipoDeContato + ", " +
				"contato = " + this.contato + "]";
	}
	
}
