package br.com.kgsm.PessoaContatoAPI.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kgsm.PessoaContatoAPI.DTO.ContatoDTO;
import br.com.kgsm.PessoaContatoAPI.DTO.PessoaContatoDTO;
import br.com.kgsm.PessoaContatoAPI.model.Contato;
import br.com.kgsm.PessoaContatoAPI.service.ContatoService;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {

	@Autowired
	private ContatoService contatoService;
	
	@PostMapping
	public ResponseEntity<Contato> save(@RequestBody ContatoDTO contatoDTO){
		Contato newContato = contatoService.save(contatoDTO);
		
		if(newContato == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(newContato);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.findById(id);
		
		if(findContato == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(findContato);
	}
	
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<List<PessoaContatoDTO>> findAllContatoDePessoa(Long id){
		List<PessoaContatoDTO> allContatoPessoaDTO = contatoService.findAllContatoDePessoa(id);
		
		if(allContatoPessoaDTO.isEmpty()) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(allContatoPessoaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody ContatoDTO contatoDTO){
		Contato updContato = contatoService.update(id, contatoDTO);
		
		if(updContato == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(updContato);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
