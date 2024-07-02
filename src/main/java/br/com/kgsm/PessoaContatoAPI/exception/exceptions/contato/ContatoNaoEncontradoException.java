package br.com.kgsm.PessoaContatoAPI.exception.exceptions.contato;

public class ContatoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ContatoNaoEncontradoException() {
		super("Contato do id inserido não encontrado ou não existe.");
	}
	
}
