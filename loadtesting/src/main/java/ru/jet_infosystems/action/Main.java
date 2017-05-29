package ru.jet_infosystems.action;

import ru.jet_infosystems.model.ClassGenerator;
import ru.jet_infosystems.model.Stub;
import ru.jet_infosystems.model.TestClass;

import java.io.IOException;

/**
 * This class use for visual hand testing of application.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public class Main {

    /**
     * method where application starts.
     *
     * @param args is input arguments
     * @throws IOException throws when input/output error
     * @throws ClassNotFoundException throws when class not found
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ClassGenerator classGen = new ClassGenerator();

        TestClass testSend = classGen.generate();

        ISend send = new Send();
        send.send(testSend);

        Stub stub = new Stub();
        stub.action();

    }

}