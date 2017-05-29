package ru.jet_infosystems.action;

import org.junit.Test;
import ru.jet_infosystems.model.ClassGenerator;
import ru.jet_infosystems.model.TestClass;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * This class tests class Serializer.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.05.2017
 */
public class SerializerTest {

    /**
     * method tests serialize to byte array and deserialize from byte array.
     *
     * @throws IOException throws when input/output error
     * @throws ClassNotFoundException throws when class not found
     */
    @Test
    public void whenSerializedClassAndDeserializedClassThenThisClassesWillBeEquals() throws IOException, ClassNotFoundException {

        ClassGenerator cg = new ClassGenerator();

        TestClass test = cg.generate();

        Serializer ser = new Serializer();

        TestClass expectedClass = test;

        TestClass actualClass = (TestClass) ser.deserializeBytes(ser.serializeObject(test));

        assertTrue(expectedClass.equals(actualClass));

    }

}
