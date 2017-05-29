package ru.jet_infosystems.action;

import org.junit.Test;
import ru.jet_infosystems.model.ClassGenerator;
import ru.jet_infosystems.model.TestClass;

import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class tests Send class and Reciever class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.05.2017
 */
public class KafkaTranssiverTest {

    /**
     * method tests validate data when transfer by kafka.
     *
     * @throws IOException throws when input/output error
     * @throws ClassNotFoundException throws when class not found
     */
    @Test
    public void whenKafkaProducerSendStringAndKafkaConsumerRecieveStringThenTheyAreEquals() throws IOException, ClassNotFoundException {

        ClassGenerator cg = new ClassGenerator();

        TestClass test = cg.generate();

        Send sender = new Send();

        Reciever reciever = new Reciever();

        Serializer ser = new Serializer();

        String expectedString = Converter.toHexString(ser.serializeObject(test));

        sender.send(test);

        String actualString = reciever.recieve();

        assertThat(actualString, is(expectedString));

    }

}
