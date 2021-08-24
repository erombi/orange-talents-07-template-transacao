package br.com.zup.academy.transacoes.domain;

import javax.persistence.*;

@Entity
@Table(name = "tb_estabelecimento")
@IdClass(EstabelecimentoId.class)
public class Estabelecimento {

    @Id
    private String nome;

    @Id
    private String cidade;

    @Id
    private String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
