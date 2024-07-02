package br.com.kgsm.PessoaContatoAPI.DTO.contato;

import br.com.kgsm.PessoaContatoAPI.DTO.pessoa.PessoaSomenteIdDTO;
import br.com.kgsm.PessoaContatoAPI.model.enums.TipoContato;

public record ContatoDTO (TipoContato tipoDeContato, String contato, PessoaSomenteIdDTO pessoa){}
