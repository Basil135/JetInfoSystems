package ru.jet_infosystems.model;

import java.util.Random;

/**
 * This class implement generator of instance of TestClass with random id and current creation date.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public class ClassGenerator implements IClassGenerator {

    /**
     * method generate instance of TestClass.
     *
     * @return new instance Of TestClass
     */
    @Override
    public TestClass generate() {
        return new TestClass(randomStr());
    }

    /**
     * method generate random string of length twenty of specified symbols as validChars.
     *
     * @return random string
     */
    private String randomStr() {

        int length = 20;

        String validChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        for (int count = 0; count < length; count++) {

            int number = random.nextInt(validChars.length());

            char ch = validChars.charAt(number);

            sb.append(ch);

        }

        return sb.toString();

    }

}
