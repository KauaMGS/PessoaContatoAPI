package br.com.kgsm.PessoaContatoAPI.exception.exceptions.contato;

public class ContatoVazioOuNuloException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ContatoVazioOuNuloException() {
		super("Contato vazio ou nulo.");
	}

}
