package br.com.zup.academy.transacoes.consumer;

import br.com.zup.academy.transacoes.domain.Transacao;
import br.com.zup.academy.transacoes.infra.ExecutorTransaction;
import br.com.zup.academy.transacoes.repository.TransacaoRepository;
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

    @Autowired
    private TransacaoRepository repository;

    @Autowired
    private ExecutorTransaction executor;

    private final Logger logger = LoggerFactory.getLogger(TransacaoConsumer.class);

    @KafkaListener(topics = "transacoes", containerFactory = "transacoesKafkaListenerContainerFactory")
    public void listenWithHeaders(@Payload Transacao transacao) {
        executor.inTransaction(() -> {
            repository.save(transacao);
            logger.info("Transação salva");
        });
    }
}
