package br.com.zup.academy.transacoes.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstabelecimentoId implements Serializable {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstabelecimentoId that = (EstabelecimentoId) o;
        return Objects.equals(nome, that.nome) && Objects.equals(cidade, that.cidade) && Objects.equals(endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cidade, endereco);
    }
}
