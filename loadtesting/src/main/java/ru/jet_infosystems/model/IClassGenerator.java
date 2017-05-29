package ru.jet_infosystems.model;

/**
 * This interface describes action of generate instance of TestClass with random id and current creation date in millis.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public interface IClassGenerator {

    /**
     * method generate instance of TestClass with random id and current creation date.
     *
     * @return instance of TestClass
     */
    TestClass generate();

}
