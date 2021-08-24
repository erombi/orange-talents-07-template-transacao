package br.com.zup.academy.transacoes.dto;

import br.com.zup.academy.transacoes.domain.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDTO {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoDTO estabelecimento;
    private CartaoDTO cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoDTO() {
    }

    public TransacaoDTO(Transacao transacao) {
        this.id = transacao.getId();
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoDTO(transacao.getEstabelecimento());
        this.cartao = new CartaoDTO(transacao.getCartao());
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

    public EstabelecimentoDTO getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(EstabelecimentoDTO estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public CartaoDTO getCartao() {
        return cartao;
    }

    public void setCartao(CartaoDTO cartao) {
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
