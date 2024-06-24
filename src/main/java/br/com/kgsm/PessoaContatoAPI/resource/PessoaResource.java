package br.com.kgsm.PessoaContatoAPI.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kgsm.PessoaContatoAPI.service.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaResource {

	@Autowired
	PessoaService pessoaService;
	
	
	
}
