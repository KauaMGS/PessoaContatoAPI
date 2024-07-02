package br.com.kgsm.PessoaContatoAPI.DTO.pessoa;

import br.com.kgsm.PessoaContatoAPI.model.Pessoa;

public record PessoaSemIdDTO (String nome, String endereco, String cep, String cidade, String uf) {
	
	public Pessoa toPessoa() {
		return new Pessoa(nome, endereco, cep, cidade, uf);
	}
	
}
