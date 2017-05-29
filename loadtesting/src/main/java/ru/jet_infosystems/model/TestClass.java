package ru.jet_infosystems.model;

import java.io.Serializable;

/**
 * This class describes class to serialize and send to kafka server.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public class TestClass implements Serializable {

    /**
     * parameter id is id of the class.
     */
    private final String id;
    /**
     * parameter creation date is date of creation instance of this class.
     */
    private final long creationDate;

    /**
     * constructor of this class.
     *
     * @param id is identification string
     */
    public TestClass(final String id) {
        this.id = id;
        this.creationDate = System.currentTimeMillis();
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
     * method return creation date of instance.
     *
     * @return creation date as millis
     */
    public long getCreationDate() {
        return this.creationDate;
    }

    /**
     * method return true if this instance equals to object o.
     *
     * @param o input object
     * @return true if this equals o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestClass testClass = (TestClass) o;

        if (creationDate != testClass.creationDate) return false;
        return id.equals(testClass.id);
    }

    /**
     * method return integer number describes this instance.
     *
     * @return integer number
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (int) (creationDate ^ (creationDate >>> 32));
        return result;
    }

}
