package br.com.kgsm.PessoaContatoAPI.DTO.pessoa;

import br.com.kgsm.PessoaContatoAPI.model.Pessoa;
import jakarta.validation.constraints.NotBlank;

public record PessoaSemIdDTO (@NotBlank String nome, String endereco, String cep, String cidade, String uf) {
	
    /**
     * Método para converter este DTO em uma entidade Pessoa.
     * 
     * @return Uma instância de Pessoa criada a partir dos atributos deste DTO.
     */
	public Pessoa toPessoa() {
		return new Pessoa(nome, endereco, cep, cidade, uf);
	}
	
}
