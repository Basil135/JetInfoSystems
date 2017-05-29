package ru.jet_infosystems.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class write string to a file.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public class FileWriter {

    /**
     * method write string to file.
     *
     * @param fileName is name of the file we need to write
     * @param text is input string
     */
    public static void write(String fileName, String text) {

        File file = new File(fileName);

        try {
            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(text);
            } finally {
                out.close();
            }

        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

}
