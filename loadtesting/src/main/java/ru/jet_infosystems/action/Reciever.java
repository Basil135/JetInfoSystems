package ru.jet_infosystems.action;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

/**
 * This class uses for recieve messages from kafka server by kafka consumer.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public class Reciever implements IReciever {

    /**
     * method implement action recieve.
     *
     * @return string as message from kafka server
     * @throws IOException throws when input/output error
     * @throws ClassNotFoundException throws when class not found
     */
    @Override
    public String recieve() throws IOException, ClassNotFoundException {

        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Arrays.asList("test"));

        ConsumerRecords<String, String> records = consumer.poll(100);

        String result = new String();

        for (ConsumerRecord<String, String> record : records) {
            result = record.value();
        }

        consumer.close();

        return result;
    }

}
