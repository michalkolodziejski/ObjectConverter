package org.mkdev.converter;

/**
 * @author Michał Kołodziejski &lt;<I><A href="mailto:michal.kolodziejski@gmail.com">michal.kolodziejski@gmail.com</A></I>&gt;
 * @version 1.0
 * @license: GPLv3 (http://www.gnu.org/licenses/gpl-3.0.txt)
 * @since: 2014-05-03
 */

/**
 * Interface for function (closure) that maps input to output
 * @param <T> input type
 * @param <R> output type
 */
public interface ConvertFunction<T, R> {
    R apply (T value) throws ObjectConversionException;
}
