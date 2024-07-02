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

import br.com.kgsm.PessoaContatoAPI.DTO.pessoa.PessoaMalaDiretaDTO;
import br.com.kgsm.PessoaContatoAPI.DTO.pessoa.PessoaSemIdDTO;
import br.com.kgsm.PessoaContatoAPI.model.Pessoa;
import br.com.kgsm.PessoaContatoAPI.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {

	@Autowired
	PessoaService pessoaService;
	
	@Operation(summary = "Criar nova pessoa", 
			description = "Cria uma nova entrada de pessoa com base nos dados fornecidos, sem a necessidade de passar um ID no Request body.")
	@ApiResponse(responseCode = "200", description = "Pessoa criada com sucesso.")
	@ApiResponse(responseCode = "404", description = "Falha ao criar a pessoa.")
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody PessoaSemIdDTO pessoa){
		Pessoa newPessoa = pessoaService.save(pessoa);
		
		if(newPessoa == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(newPessoa);	
	}
	
	@Operation(summary = "Buscar Pessoa por ID", 
	           description = "Recupera uma pessoa existente com base no ID fornecido.")
	@ApiResponse(responseCode = "200", description = "Pessoa encontrada.")
	@ApiResponse(responseCode = "404", description = "Pessoa não encontrada.")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id){
		Optional<Pessoa> findPessoa = pessoaService.findById(id);
		
		if(findPessoa.isEmpty()) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(findPessoa);
	}
	
	@Operation(summary = "Buscar pessoa para Mala Direta através do ID", 
	           description = "Obtem o endereço concatenado baseado no ID da pessoa.")
	@ApiResponse(responseCode = "200", description = "Informações para mala direta obtidas com sucesso.")
	@ApiResponse(responseCode = "404", description = "Falha ao obter informações para mala direta.")
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<PessoaMalaDiretaDTO> malaDireta(@PathVariable Long id){
		PessoaMalaDiretaDTO pessoaMalaDireta = pessoaService.pessoaMalaDireta(id);
		
		if(pessoaMalaDireta == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(pessoaMalaDireta);
	}
	
	@Operation(summary = "Listar todas as Pessoas", 
	           description = "Recupera todas as pessoas cadastradas.")
	@ApiResponse(responseCode = "200", description = "Lista de pessoas recuperada com sucesso.")
	@ApiResponse(responseCode = "404", description = "Nenhuma pessoa encontrada.")
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> allPessoas = pessoaService.findAll();
		
		if(allPessoas == null) return ResponseEntity.notFound().build();
		if(allPessoas.size() == 0) return ResponseEntity.notFound().build();
	
		return ResponseEntity.ok(allPessoas);
	}
	
	@Operation(summary = "Atualizar Pessoa por ID", 
	           description = "Atualiza os dados de uma pessoa baseado no ID, sem a necessidade de passar um ID no Request body, apenas nos Parameters.")
	@ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso.")
	@ApiResponse(responseCode = "404", description = "Falha ao atualizar a pessoa.")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> updateById(@Parameter(description = "ID da pessoa a ser atualizada") @PathVariable Long id, @RequestBody PessoaSemIdDTO pessoa){
		Pessoa updPessoa = pessoaService.update(id, pessoa);

		if(updPessoa == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(updPessoa);
	}
	
	@Operation(summary = "Excluir Pessoa por ID", 
	           description = "Remove uma pessoa cadastrada com base no ID <br>"
	           		+ "Todos os contatos relacionados a pessoa serão removidos em conjunto.")
	@ApiResponse(responseCode = "204", description = "Pessoa e todos contatos relacionados excluidos com sucesso.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		pessoaService.delete(id);
	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
