package org.mkdev.converter;

/**
 * @author Michał Kołodziejski &lt;<I><A href="mailto:michal.kolodziejski@gmail.com">michal.kolodziejski@gmail.com</A></I>&gt;
 * @version 1.0
 * @license: GPLv3 (http://www.gnu.org/licenses/gpl-3.0.txt)
 * @since: 2014-05-03
 */
public class ObjectConversionException extends RuntimeException {

    private static final long serialVersionUID = -1441429034140477053L;

    public ObjectConversionException() {
        super();
    }

    public ObjectConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectConversionException(String message) {
        super(message);
    }

    public ObjectConversionException(Throwable cause) {
        super(cause);
    }
}

