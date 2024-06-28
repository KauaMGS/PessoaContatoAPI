package br.com.kgsm.PessoaContatoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kgsm.PessoaContatoAPI.model.Pessoa;
import br.com.kgsm.PessoaContatoAPI.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	//CREATE
	public Pessoa save(Pessoa pessoa) {
		if(pessoa.getNome() == null) {
			System.out.println("Nome vazio!");
			return null;
		}
		
		try {
			return pessoaRepository.save(pessoa);
		}catch(Exception e) {
			System.out.println("Erro ao adicionar pessoa, " + pessoa.toString() + " erro: " + e.getMessage());
			return null;
		}
	}
	
	//READ
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}	
	public Optional<Pessoa> findById(Long id){
		return pessoaRepository.findById(id);
	}
	
	//UPDATE
	public Pessoa update(Long id, Pessoa pessoa) {
		Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
		
		if(findPessoa.isEmpty()) return pessoaRepository.save(pessoa);
		
		Pessoa updPessoa = findPessoa.get();
		updPessoa.setNome(pessoa.getNome());
		updPessoa.setCidade(pessoa.getCidade());
		updPessoa.setEndereco(pessoa.getEndereco());
		updPessoa.setUf(pessoa.getUf());
		updPessoa.setCep(pessoa.getCep());
		
		return pessoaRepository.save(updPessoa);
			
	}
	
	//DELETE
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
	
}
