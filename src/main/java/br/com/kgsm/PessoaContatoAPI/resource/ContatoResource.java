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

import br.com.kgsm.PessoaContatoAPI.DTO.contato.ContatoDTO;
import br.com.kgsm.PessoaContatoAPI.DTO.contato.ContatoSimplesDTO;
import br.com.kgsm.PessoaContatoAPI.DTO.pessoa.PessoaContatoDTO;
import br.com.kgsm.PessoaContatoAPI.model.Contato;
import br.com.kgsm.PessoaContatoAPI.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/contatos")
public class ContatoResource {

	@Autowired
	private ContatoService contatoService;
	
	@Operation(summary = "Adicionar contato a uma Pessoa", 
	           description = "Adiciona um contato a uma Pessoa com base no ID fornecido no Request body. <br>"
	           		+ "Sendo que o tipoDeContato deve ser CELULAR ou TELEFONE.")
	@ApiResponse(responseCode = "200", description = "Contato criado com sucesso.")
	@ApiResponse(responseCode = "404", description = "Falha ao criar o contato.")
	@PostMapping
	public ResponseEntity<Contato> save(@RequestBody ContatoDTO contatoDTO){
		Contato newContato = contatoService.save(contatoDTO);
		
		if(newContato == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(newContato);
	}
	
	@Operation(summary = "Buscar Contato por ID", 
	           description = "Recupera um contato existente com base no ID fornecido.")
	@ApiResponse(responseCode = "200", description = "Contato encontrado.")
	@ApiResponse(responseCode = "400", description = "Tipo de contato inserio inválido.")
	@ApiResponse(responseCode = "404", description = "Contato não encontrado.")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Contato>> findById(@PathVariable Long id){
		Optional<Contato> findContato = contatoService.findById(id);
		
		if(findContato == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(findContato);
	}
	
	@Operation(summary = "Listar todos Contatos de uma Pessoa", 
	           description = "Recupera todos os contatos associados a uma pessoa com base no ID da pessoa.")
	@ApiResponse(responseCode = "200", description = "Contatos da pessoa encontrados.")
	@ApiResponse(responseCode = "404", description = "Nenhum contato encontrado para a pessoa.")
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<List<PessoaContatoDTO>> findAllContatoDePessoa(Long id){
		List<PessoaContatoDTO> allContatoPessoaDTO = contatoService.findAllContatoDePessoa(id);
		
		if(allContatoPessoaDTO.isEmpty()) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(allContatoPessoaDTO);
	}
	
	@Operation(summary = "Atualizar Contato por ID", 
	           description = "Atualiza os dados de um contato existente com base no ID fornecido, sem a necessidade de passar um ID no Request body, apenas nos Parameters.")
	@ApiResponse(responseCode = "200", description = "Contato atualizado com sucesso.")
	@ApiResponse(responseCode = "400", description = "Tipo de contato inserio inválido.")
	@ApiResponse(responseCode = "404", description = "Falha ao atualizar o contato.")
	@PutMapping("/{id}")
	public ResponseEntity<Contato> update(@PathVariable Long id, @RequestBody ContatoSimplesDTO contatoSimplesDTO){
		Contato updContato = contatoService.update(id, contatoSimplesDTO);
		
		if(updContato == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(updContato);
	}
	
	@Operation(summary = "Excluir Contato por ID", 
	           description = "Remove um contato cadastrado com base no ID fornecido.")
	@ApiResponse(responseCode = "204", description = "Contato excluído com sucesso.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		contatoService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
