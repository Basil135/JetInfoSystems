package ru.jet_infosystems.action;

/**
 * This class convert array of byte to hex string and vice versa.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 27.05.2017
 */
public class Converter {

    /**
     * parameter HEX_CHARS is array of char that available in hex string.
     */
    private static final char[] HEX_CHARS = {
            '0', '1', '2' ,'3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'
    };

    /**
     * method convert array of byte to hex string.
     *
     * @param bytes is input byte array
     * @return hex string
     */
    public static String toHexString(byte[] bytes)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            sb.append(new char[] {HEX_CHARS[(b >> 4) & 0x0f], HEX_CHARS[b & 0x0f]});
        }

        return sb.toString();
    }

    /**
     * method convert hex string to byte array.
     *
     * @param s is input hex string
     * @return byte array
     */
    public static byte[] toByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

}