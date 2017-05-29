package ru.jet_infosystems.model;

import ru.jet_infosystems.action.*;

import java.io.IOException;

/**
 * This class implement stub, this stub recieve message from kafka server and write valid data to file.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public class Stub {

    /**
     * method recieve message from kafka server and write data to file.
     *
     * @throws IOException throws when input/output error
     * @throws ClassNotFoundException throws when class not found
     */
    public void action() throws IOException, ClassNotFoundException {

        IReciever reciever = new Reciever();

        String str = reciever.recieve();

        byte[] bytes = Converter.toByteArray(str);

        Serializer ser = new Serializer();

        TestClass test = (TestClass) ser.deserializeBytes(bytes);

        StringBuilder out = new StringBuilder();

        out.append("csv: ");
        out.append(test.getId());
        out.append(";");
        out.append(test.getCreationDate());

        FileWriter.write("test.out", out.toString());

    }

}