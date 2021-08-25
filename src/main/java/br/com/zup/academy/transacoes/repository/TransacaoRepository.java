package br.com.zup.academy.transacoes.repository;

import br.com.zup.academy.transacoes.domain.Transacao;
import br.com.zup.academy.transacoes.dto.TransacaoDTO;
import br.com.zup.academy.transacoes.dto.TransacaoForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
    Page<TransacaoDTO> findAllByCartaoId(String idCartao, Pageable pageable);
}
