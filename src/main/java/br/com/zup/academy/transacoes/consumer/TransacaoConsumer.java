package br.com.zup.academy.transacoes.consumer;

import br.com.zup.academy.transacoes.domain.Transacao;
import br.com.zup.academy.transacoes.dto.TransacaoForm;
import br.com.zup.academy.transacoes.infra.ExecutorTransaction;
import br.com.zup.academy.transacoes.repository.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class TransacaoConsumer {

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private ExecutorTransaction executor;

    private final Logger logger = LoggerFactory.getLogger(TransacaoConsumer.class);

    @KafkaListener(topics = "transacoes", containerFactory = "kafkaListenerContainerFactory")
    public void listenWithHeaders(@Payload TransacaoForm dto) {
        executor.inTransaction(() -> {
            Transacao transacao = dto.toModel();

            repository.save(transacao);

            logger.info("Transação salva");
        });
    }
}
