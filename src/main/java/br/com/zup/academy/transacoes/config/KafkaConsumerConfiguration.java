package br.com.zup.academy.transacoes.config;

import br.com.zup.academy.transacoes.domain.Transacao;
import br.com.zup.academy.transacoes.dto.TransacaoDTO;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@EnableKafka
@Configuration
public class KafkaConsumerConfiguration {

    @Value("${KAFKA_URL:127.0.0.1:9092}")
    private String kafkaUrl;

    @Bean
    public ConsumerFactory<String, TransacaoDTO> transacoesConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "CONSULTA_TRANSACOES");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        JsonDeserializer<TransacaoDTO> transacaoJsonDeserializer = new JsonDeserializer<>(TransacaoDTO.class);
        transacaoJsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), transacaoJsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TransacaoDTO> transacoesKafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, TransacaoDTO> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(transacoesConsumerFactory());
        return factory;
    }
}
