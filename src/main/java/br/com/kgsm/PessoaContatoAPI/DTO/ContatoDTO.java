package br.com.kgsm.PessoaContatoAPI.DTO;

import br.com.kgsm.PessoaContatoAPI.model.enums.TipoContato;

public record ContatoDTO (TipoContato tipoDeContato, String contato, PessoaSomenteIdDTO pessoa){}
