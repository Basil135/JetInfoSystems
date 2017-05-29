package ru.jet_infosystems.action;

import ru.jet_infosystems.model.TestClass;

import java.io.IOException;

/**
 * This interface describes action of send string to kafka by kafka producer.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public interface ISend {

    /**
     * method send serialized instance of TestClass as hex string to kafka server by kafka producer.
     *
     * @param instance is input instance of TestClass
     * @throws IOException throws when input/output error
     */
    void send(TestClass instance) throws IOException;

}
