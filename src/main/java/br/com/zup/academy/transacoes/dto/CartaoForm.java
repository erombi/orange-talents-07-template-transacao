package br.com.zup.academy.transacoes.dto;

import br.com.zup.academy.transacoes.domain.Cartao;

public class CartaoForm {

    private String id;
    private String email;

    @Deprecated
    public CartaoForm() {
    }

    public CartaoForm(Cartao cartao) {
        this.id = cartao.getId();
        this.email = cartao.getEmail();
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
