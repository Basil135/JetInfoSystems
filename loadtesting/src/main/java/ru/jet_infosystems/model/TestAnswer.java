package ru.jet_infosystems.model;

import java.io.Serializable;

/**
 * This class describes answer of stub to producer.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.05.2017
 */
public class TestAnswer implements Serializable {

    /**
     * parameter id is id of instance.
     */
    private final String id;
    /**
     * parameter status is strong ok.
     */
    private final String status = "ok";

    /**
     * constructor of class.
     *
     * @param id is input id
     */
    public TestAnswer(final String id) {
        this.id = id;
    }

    /**
     * method return id of instance.
     *
     * @return string id
     */
    public String getId() {
        return this.id;
    }

    /**
     * method return status.
     *
     * @return status
     */
    public String getStatus() {
        return this.status;
    }

}
