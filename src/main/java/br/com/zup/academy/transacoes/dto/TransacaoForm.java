package br.com.zup.academy.transacoes.dto;

import br.com.zup.academy.transacoes.domain.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoForm {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoForm estabelecimento;
    private CartaoForm cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoForm() {
    }

    public TransacaoForm(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoForm(transacao.getEstabelecimento());
        this.cartao = new CartaoForm(transacao.getCartao());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public EstabelecimentoForm getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoForm estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public CartaoForm getCartao() {
        return cartao;
    }

    public void setCartao(CartaoForm cartao) {
        this.cartao = cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(this.id, this.valor, estabelecimento.toModel(), cartao.toModel(), this.efetivadaEm);
    }
}
