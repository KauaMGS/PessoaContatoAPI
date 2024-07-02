package br.com.kgsm.PessoaContatoAPI.exception.exceptions.pessoa;

public class NomeVazioOuNuloException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NomeVazioOuNuloException() {
		super("Nome vazio ou nulo.");
	}
}
