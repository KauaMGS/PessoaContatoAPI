package br.com.kgsm.PessoaContatoAPI.DTO.contato;

import br.com.kgsm.PessoaContatoAPI.model.enums.TipoContato;
import jakarta.validation.constraints.NotBlank;

public record ContatoSimplesDTO (@NotBlank TipoContato tipoDeContato, @NotBlank String contato){}
