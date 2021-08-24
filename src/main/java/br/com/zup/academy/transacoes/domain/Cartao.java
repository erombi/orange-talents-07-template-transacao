package br.com.zup.academy.transacoes.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Entity
@Table(name = "tb_cartao")
public class Cartao {

    @Id
    private String id;
    private String email;

    @Deprecated
    public Cartao() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
