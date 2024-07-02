package br.com.kgsm.PessoaContatoAPI.exception;

public record ApiError (Integer code, String status, String error){}
