package fr.insa.api.configs;

import fr.insa.api.models.Summary;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;
    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, Summary> requestConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                groupId);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(JsonSerializer.TYPE_MAPPINGS, "fr.insa.processor.models.Summary:fr.insa.api.models.Summary");
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "fr.insa.api.models.Summary");
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Summary>
    requestKafkaListenerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, Summary> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(requestConsumerFactory());
        return factory;
    }
/*
    // ReplyingKafkaTemplate
    @Bean
    public ReplyingKafkaTemplate<String, Model, Model> replyKafkaTemplate(ProducerFactory<String, Model> pf, KafkaMessageListenerContainer<String, Model> container) {
        return new ReplyingKafkaTemplate<>(pf, container);
    }

    // Listener Container to be set up in ReplyingKafkaTemplate
    @Bean
    public KafkaMessageListenerContainer<String, Model> replyContainer(ConsumerFactory<String, Model> cf) {
        ContainerProperties containerProperties = new ContainerProperties(requestReplyTopic);
        return new KafkaMessageListenerContainer<>(cf, containerProperties);
    }

    // Default Producer Factory to be used in ReplyingKafkaTemplate
    @Bean
    public ProducerFactory<String,Model> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

*/
}