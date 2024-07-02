package br.com.kgsm.PessoaContatoAPI.exception.exceptions.contato;

public class TipoDeContatoNuloException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TipoDeContatoNuloException() {	
		super("Tipo de contato vazio ou nulo.");
	}
	
}
