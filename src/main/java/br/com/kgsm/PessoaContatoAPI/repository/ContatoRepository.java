package br.com.kgsm.PessoaContatoAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kgsm.PessoaContatoAPI.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	
    @Query(value = "SELECT p.id AS pessoa_id, p.nome AS pessoa_nome, c.tipo_de_contato AS contato_tipoDeContato, c.contato AS contato_contato FROM tb_pessoa p JOIN tb_contato c ON p.id = c.pessoa_id WHERE p.id = :pessoaId", nativeQuery = true)
    List<Object[]> findTodosContatosPessoa(@Param("pessoaId") Long pessoaId);
	
}
