package br.com.kgsm.PessoaContatoAPI.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kgsm.PessoaContatoAPI.service.ContatoService;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {

	@Autowired
	private ContatoService contatoService;
	

	
}
