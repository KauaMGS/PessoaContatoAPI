package br.com.kgsm.PessoaContatoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kgsm.PessoaContatoAPI.DTO.pessoa.PessoaMalaDiretaDTO;
import br.com.kgsm.PessoaContatoAPI.DTO.pessoa.PessoaSemIdDTO;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.pessoa.NomeVazioOuNuloException;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.pessoa.PessoaNaoEncontradaException;
import br.com.kgsm.PessoaContatoAPI.model.Pessoa;
import br.com.kgsm.PessoaContatoAPI.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	
	public Pessoa save(PessoaSemIdDTO pessoa) {			
		if(pessoa.nome() == null || pessoa.nome().equals("")) throw new NomeVazioOuNuloException();
		
		return pessoaRepository.save(pessoa.toPessoa());
	}
	
	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}	
	public Optional<Pessoa> findById(Long id){
		Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
		
		if(findPessoa.isEmpty()) throw new PessoaNaoEncontradaException();
		
		return findPessoa;
	}
	
	public PessoaMalaDiretaDTO pessoaMalaDireta(Long id) {	
		Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
		
		if(findPessoa.isEmpty()) throw new PessoaNaoEncontradaException();
		
		Pessoa malaPessoa = findPessoa.get();		
		
		PessoaMalaDiretaDTO pessoaMalaDiretaDTO = new PessoaMalaDiretaDTO(id, malaPessoa.getNome(), malaPessoa.toMalaDireta());
		
		return pessoaMalaDiretaDTO;
	}
	
	public Pessoa update(Long id, PessoaSemIdDTO pessoa) {
		if(pessoa.nome() == null || pessoa.nome().equals("")) throw new NomeVazioOuNuloException();
		
		Optional<Pessoa> findPessoa = pessoaRepository.findById(id);
		
		if(findPessoa.isEmpty()) return pessoaRepository.save(pessoa.toPessoa());
		
		Pessoa updPessoa = findPessoa.get();
		updPessoa.setNome(pessoa.nome());
		updPessoa.setCidade(pessoa.cidade());
		updPessoa.setEndereco(pessoa.endereco());
		updPessoa.setUf(pessoa.uf());
		updPessoa.setCep(pessoa.cep());
		
		return pessoaRepository.save(updPessoa);
			
	}
	
	public void delete(Long id) {
		pessoaRepository.deleteById(id);
	}
	
}
