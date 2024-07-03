package br.com.kgsm.PessoaContatoAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.kgsm.PessoaContatoAPI.exception.exceptions.contato.ContatoNaoEncontradoException;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.contato.ContatoVazioOuNuloException;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.contato.TipoDeContatoNuloException;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.pessoa.NomeVazioOuNuloException;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.pessoa.PessoaNaoEncontradaException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(NomeVazioOuNuloException.class)
	public ResponseEntity<ApiError> nomeVazioOuNuloException(RuntimeException ex){
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PessoaNaoEncontradaException.class)
	public ResponseEntity<ApiError> pessoaNaoEncontradaOuNaoExisteException(RuntimeException ex){
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ContatoVazioOuNuloException.class)
	public ResponseEntity<ApiError> contatoVazioOuNuloException(RuntimeException ex){
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ContatoNaoEncontradoException.class)
	public ResponseEntity<ApiError> contatoNaoEncontradoException(RuntimeException ex){
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TipoDeContatoNuloException.class)
	public ResponseEntity<ApiError> tipoDeContatoNuloException(RuntimeException ex){
		ApiError error = new ApiError(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleHttpMessageNotReadableException() {
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), "Tipo de contato inserido é invalido.");
    	
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	
}
