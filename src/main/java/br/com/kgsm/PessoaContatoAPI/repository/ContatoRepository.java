package br.com.kgsm.PessoaContatoAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kgsm.PessoaContatoAPI.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {}
