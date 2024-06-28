package br.com.kgsm.PessoaContatoAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kgsm.PessoaContatoAPI.model.Contato;
import br.com.kgsm.PessoaContatoAPI.model.Pessoa;
import br.com.kgsm.PessoaContatoAPI.repository.ContatoRepository;
import br.com.kgsm.PessoaContatoAPI.repository.PessoaRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Contato save(Contato contato) {
		
		if(contato.getPessoa().getId() != null) {
			Optional<Pessoa> findPessoa = pessoaRepository.findById(contato.getPessoa().getId());
			
			if(findPessoa.isPresent()) {
				contato.setPessoa(findPessoa.get());
				
				return contatoRepository.save(contato);
			}else {
				System.out.println("Pessoa nao encotrada! id : " + contato.getPessoa().getId());
				
				return null;
			}
					
		}else {
			System.out.println("Pessoa nao encontrada!");
			
			return null;
		}
		
	}
	
	public Optional<Contato> findById(Long id){
		return contatoRepository.findById(id);
	}
	public List<Contato> findAll(){
		return contatoRepository.findAll();
	}
	
	public Contato update(Long id, Contato contato) {
		
		Optional<Contato> findContato = contatoRepository.findById(id);
		
		if(findContato.isEmpty()) return save(contato);
		
		Contato updContato = findContato.get();
		updContato.setContato(contato.getContato());
		updContato.setTipoDeContato(contato.getTipoDeContato());
		updContato.setPessoa(null);
		
		return contatoRepository.save(contato);
				
	}
	
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
	
}
