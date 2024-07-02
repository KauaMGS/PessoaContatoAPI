package br.com.kgsm.PessoaContatoAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kgsm.PessoaContatoAPI.DTO.contato.ContatoDTO;
import br.com.kgsm.PessoaContatoAPI.DTO.contato.ContatoSimplesDTO;
import br.com.kgsm.PessoaContatoAPI.DTO.pessoa.PessoaContatoDTO;
import br.com.kgsm.PessoaContatoAPI.DTO.pessoa.PessoaSomenteIdDTO;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.contato.ContatoNaoEncontradoException;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.contato.ContatoVazioOuNuloException;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.contato.TipoDeContatoNuloException;
import br.com.kgsm.PessoaContatoAPI.exception.exceptions.pessoa.PessoaNaoEncontradaException;
import br.com.kgsm.PessoaContatoAPI.model.Contato;
import br.com.kgsm.PessoaContatoAPI.model.Pessoa;
import br.com.kgsm.PessoaContatoAPI.model.enums.TipoContato;
import br.com.kgsm.PessoaContatoAPI.repository.ContatoRepository;
import br.com.kgsm.PessoaContatoAPI.repository.PessoaRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Contato save(ContatoDTO contatoDTO) {
		System.out.println("Chegou aqui!");
		if(contatoDTO.tipoDeContato() == null) throw new TipoDeContatoNuloException();
		if(contatoDTO.contato() == null || contatoDTO.contato().equals("")) throw new ContatoVazioOuNuloException();	
		
		PessoaSomenteIdDTO pessoaDTO = contatoDTO.pessoa();

        Optional<Pessoa> findPessoa = pessoaRepository.findById(pessoaDTO.id());
        if(findPessoa.isEmpty()) throw new PessoaNaoEncontradaException();
        
        Pessoa pessoa = findPessoa.get();
        Contato contato = new Contato();
        contato.setTipoDeContato(contatoDTO.tipoDeContato());
        contato.setContato(contatoDTO.contato());
        contato.setPessoa(pessoa);

        return contatoRepository.save(contato);	
	}
	
	public Optional<Contato> findById(Long id){
		Optional<Contato> findContato = contatoRepository.findById(id);
		
		if(findContato.isEmpty()) throw new ContatoNaoEncontradoException();
		
		return contatoRepository.findById(id);
	}
	
	public List<PessoaContatoDTO> findAllContatoDePessoa(Long id){
        List<Object[]> listResult = contatoRepository.findTodosContatosPessoa(id);
        
        if(listResult.isEmpty()) throw new PessoaNaoEncontradaException();
        
        List<PessoaContatoDTO> listPessoaContato = new ArrayList<>();
		
		for(Object[] obj : listResult) {
			PessoaContatoDTO pDTO = returnBDPessoaContatoDTO(obj);
			listPessoaContato.add(pDTO);
		}
		
		return listPessoaContato;
	}
	
	public Contato update(Long id, ContatoSimplesDTO contatoSimplesDTO) {
	       Optional<Contato> findContato = contatoRepository.findById(id);

	       if(findContato.isEmpty()) throw new ContatoNaoEncontradoException();
	       
	       Contato updContato = findContato.get();
	       updContato.setContato(contatoSimplesDTO.contato());
	       updContato.setTipoDeContato(contatoSimplesDTO.tipoDeContato());

	       if(updContato.getTipoDeContato() == null) throw new TipoDeContatoNuloException();
	       if(updContato.getContato() == null || updContato.getContato().equals("")) throw new ContatoVazioOuNuloException();
	       
	       return contatoRepository.save(updContato);
	}
	
	public void delete(Long id) {
		contatoRepository.deleteById(id);
	}
	
	private PessoaContatoDTO returnBDPessoaContatoDTO(Object[] result) {
	    PessoaContatoDTO pessoaContatoDTO = new PessoaContatoDTO();
	    
	    if (result != null) {
	        pessoaContatoDTO.setPessoaId(((Long) result[0]).longValue());
	        pessoaContatoDTO.setNome((String) result[1]);	    
	        byte valorDoTipoDeContato = (Byte) result[2];
	        TipoContato tipoDeContato = TipoContato.valueOf((int) valorDoTipoDeContato);
	        pessoaContatoDTO.setTipoDeContato(tipoDeContato);
	        pessoaContatoDTO.setContato((String) result[3]);
	    }
	    
	    return pessoaContatoDTO;
	}

}
