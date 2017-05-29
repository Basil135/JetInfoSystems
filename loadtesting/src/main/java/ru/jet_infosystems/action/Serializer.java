package ru.jet_infosystems.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class implement serialize of object to byte array and vice versa.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public class Serializer {

    /**
     * method serialize object to byte array.
     *
     * @param obj is input object
     * @return byte array
     * @throws IOException throws when input/output error
     */
    public byte[] serializeObject(Object obj) throws IOException {

        ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(bytesOut);

        oos.writeObject(obj);

        oos.flush();

        byte[] bytes = bytesOut.toByteArray();

        bytesOut.close();

        oos.close();

        return bytes;

    }

    /**
     * method deserialize byte array to object.
     *
     * @param bytes is input byte array
     * @return Object
     * @throws IOException throws when input/output error
     * @throws ClassNotFoundException throws when class not found
     */
    public Object deserializeBytes(byte[] bytes) throws IOException, ClassNotFoundException {

        ByteArrayInputStream bytesIn = new ByteArrayInputStream(bytes);

        ObjectInputStream ois = new ObjectInputStream(bytesIn);

        Object obj = ois.readObject();

        bytesIn.close();

        ois.close();

        return obj;

    }

}