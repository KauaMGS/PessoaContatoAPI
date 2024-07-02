package br.com.kgsm.PessoaContatoAPI.DTO.contato;

import br.com.kgsm.PessoaContatoAPI.DTO.pessoa.PessoaSomenteIdDTO;
import br.com.kgsm.PessoaContatoAPI.model.enums.TipoContato;
import jakarta.validation.constraints.NotBlank;

public record ContatoDTO (@NotBlank TipoContato tipoDeContato, @NotBlank String contato, PessoaSomenteIdDTO pessoa){}
