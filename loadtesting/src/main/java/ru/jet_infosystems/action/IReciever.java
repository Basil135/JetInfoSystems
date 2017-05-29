package ru.jet_infosystems.action;

import java.io.IOException;

/**
 * This interface describes action of recieve string from kafka by kafka consumer.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public interface IReciever {

    /**
     * method recieve string from kafka by kafka consumer.
     *
     * @return string
     * @throws IOException throws when input/output error
     * @throws ClassNotFoundException throws when class not found
     */
    String recieve() throws IOException, ClassNotFoundException;

}
