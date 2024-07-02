package br.com.kgsm.PessoaContatoAPI.exception.exceptions.pessoa;

public class PessoaNaoEncontradaException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public PessoaNaoEncontradaException() {
		super("Pessoa do id inserido não encontrada ou não existe.");
	}
	
}
