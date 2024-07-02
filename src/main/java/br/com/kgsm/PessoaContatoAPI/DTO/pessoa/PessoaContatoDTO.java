package br.com.kgsm.PessoaContatoAPI.DTO.pessoa;

import br.com.kgsm.PessoaContatoAPI.model.enums.TipoContato;

public class PessoaContatoDTO {
    private Long pessoaId;
    private String nome;
    private TipoContato tipoDeContato;
    private String contato;

    public PessoaContatoDTO() {
    }

    public PessoaContatoDTO(Long pessoaId, String nome, TipoContato tipoDeContato, String contato) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.tipoDeContato = tipoDeContato;
        this.contato = contato;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoContato getTipoDeContato() {
        return tipoDeContato;
    }

    public void setTipoDeContato(TipoContato tipoDeContato) {
        this.tipoDeContato = tipoDeContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
