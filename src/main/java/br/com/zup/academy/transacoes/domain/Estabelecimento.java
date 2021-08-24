package br.com.zup.academy.transacoes.domain;

import javax.persistence.*;
import java.util.Objects;

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

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estabelecimento that = (Estabelecimento) o;
        return Objects.equals(nome, that.nome) && Objects.equals(cidade, that.cidade) && Objects.equals(endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cidade, endereco);
    }
}
