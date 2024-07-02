package br.com.kgsm.PessoaContatoAPI.DTO;

import br.com.kgsm.PessoaContatoAPI.model.enums.TipoContato;

public record ContatoSimplesDTO (TipoContato tipoDeContato, String contato){}
