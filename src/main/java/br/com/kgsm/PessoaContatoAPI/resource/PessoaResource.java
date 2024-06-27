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

import br.com.kgsm.PessoaContatoAPI.model.Pessoa;
import br.com.kgsm.PessoaContatoAPI.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {

	@Autowired
	PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa){
		Pessoa newPessoa = pessoaService.save(pessoa);
		
		if(newPessoa == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(newPessoa);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id){
		Optional<Pessoa> findPessoa = pessoaService.findById(id);
		
		if(findPessoa.isEmpty()) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(findPessoa);
	}
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> allPessoas = pessoaService.findAll();
		
		if(allPessoas == null) return ResponseEntity.notFound().build();
		if(allPessoas.size() == 0) return ResponseEntity.notFound().build();
	
		return ResponseEntity.ok(allPessoas);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> updateById(@PathVariable Long id, @RequestBody Pessoa pessoa){
		Pessoa updPessoa = pessoaService.update(id, pessoa);

		if(updPessoa == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(updPessoa);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		pessoaService.delete(id);
	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
