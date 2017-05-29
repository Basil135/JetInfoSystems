package ru.jet_infosystems.action;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import ru.jet_infosystems.model.TestClass;

import java.io.IOException;
import java.util.Properties;

/**
 * This class implement action send message to kafka server.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public class Send implements ISend {

    /**
     * method serialize input instance of TestClass to byte array, convert it to hex string and send it to kafka server by kafka producer.
     *
     * @param instance is input instance of TestClass
     * @throws IOException throws when input/output error
     */
    @Override
    public void send(TestClass instance) throws IOException {

        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        Producer producer = new KafkaProducer<String, String>(props);

        Serializer ser = new Serializer();

        byte[] bytes = ser.serializeObject(instance);

        String result = Converter.toHexString(bytes);

        ProducerRecord<String, String> record = new ProducerRecord<>("test", result);

        producer.send(record);

        producer.close();

    }

}