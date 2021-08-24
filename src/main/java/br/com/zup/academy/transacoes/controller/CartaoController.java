package br.com.zup.academy.transacoes.controller;

import br.com.zup.academy.transacoes.domain.Transacao;
import br.com.zup.academy.transacoes.dto.TransacaoDTO;
import br.com.zup.academy.transacoes.repository.CartaoRepository;
import br.com.zup.academy.transacoes.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private CartaoRepository cartaoRepository;


    @GetMapping("/{idCartao}/transacoes")
    private ResponseEntity<?> transacoesCartao(@PathVariable String idCartao, @RequestParam Integer page, @RequestParam Integer size) {
        if (!cartaoRepository.existsById(idCartao)) return ResponseEntity.notFound().build();

        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Transacao> transacoes =  repository.findAllByCartaoId(idCartao, pageRequest);
        Page<TransacaoDTO> dto = transacoes.map(TransacaoDTO::new);

        return ResponseEntity.ok(dto);
    }

}
