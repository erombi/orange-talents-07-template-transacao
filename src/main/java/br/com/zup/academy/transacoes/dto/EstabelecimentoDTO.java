package br.com.zup.academy.transacoes.dto;

import br.com.zup.academy.transacoes.domain.Estabelecimento;

public class EstabelecimentoDTO {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoDTO() {
    }

    public EstabelecimentoDTO(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
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

    public Estabelecimento toModel() {
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }
}
