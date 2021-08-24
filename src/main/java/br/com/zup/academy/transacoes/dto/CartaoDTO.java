package br.com.zup.academy.transacoes.dto;

import br.com.zup.academy.transacoes.domain.Cartao;

public class CartaoDTO {

    private String id;
    private String email;

    @Deprecated
    public CartaoDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao toModel() {
        return new Cartao(this.id, this.email);
    }
}
