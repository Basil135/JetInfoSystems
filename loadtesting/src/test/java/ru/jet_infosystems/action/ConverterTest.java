package ru.jet_infosystems.action;


import org.junit.Test;
import ru.jet_infosystems.model.ClassGenerator;
import ru.jet_infosystems.model.TestClass;

import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class tests Converter class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.05.2017
 */
public class ConverterTest {

    /**
     * method tests byte array convert to hex string and vice versa.
     *
     * @throws IOException throws when input/output error
     */
    @Test
    public void whenSerializedClassAsArrayOfBytesConvertToStringAndViceVersaThenTwoArraysOfBytesAreEquals() throws IOException {

        ClassGenerator classGen = new ClassGenerator();

        TestClass testClass = classGen.generate();

        Serializer serializer = new Serializer();

        byte[] expectedArray = serializer.serializeObject(testClass);
        byte[] actualArray = Converter.toByteArray(Converter.toHexString(expectedArray));

        assertThat(actualArray, is(expectedArray));

    }

}
