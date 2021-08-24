package br.com.zup.academy.transacoes.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class TransacaoConsumer {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ExecutorTransaction executor;

    private final Logger logger = LoggerFactory.getLogger(TransacaoConsumer.class);

    @KafkaListener(topics = "transacoes", containerFactory = "transacoesKafkaListenerContainerFactory")
    public void listenWithHeaders(@Payload Transacao transacao) {
        executor.inTransaction(() -> {
            manager.persist(transacao);
            logger.info("Transação salva");
        });
    }
}
