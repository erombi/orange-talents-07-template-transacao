package br.com.zup.academy.transacoes.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransacaoDTO {

    String getId();
    BigDecimal getValor();
    EstabelecimentoDTO getEstabelecimento();
    CartaoDTO getCartao();
    LocalDateTime getEfetivadaEm();
}
