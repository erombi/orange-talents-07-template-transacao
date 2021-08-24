package br.com.zup.academy.transacoes.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
