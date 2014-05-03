package org.mkdev.converter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Michał Kołodziejski &lt;<I><A href="mailto:michal.kolodziejski@gmail.com">michal.kolodziejski@gmail.com</A></I>&gt;
 * @version 1.0
 * @license: GPLv3 (http://www.gnu.org/licenses/gpl-3.0.txt)
 * @since: 2014-05-03
 */
public final class ObjectConverter {

    private static final Map<Class, ConvertFunction<String, ?>> CONVERT_STRATEGY = new HashMap<>();

    static {
        // String to Boolean converter
        CONVERT_STRATEGY.put(Boolean.class, new ConvertFunction<String, Boolean>() {
            public Boolean apply(String value) {
                return Boolean.valueOf(value);
            }
        });

        // String to Byte converter
        CONVERT_STRATEGY.put(Byte.class, new ConvertFunction<String, Byte>() {
            public Byte apply(String value) {
                return Byte.valueOf(value);
            }
        });

        // String to Double converter
        CONVERT_STRATEGY.put(Double.class, new ConvertFunction<String, Double>() {
            public Double apply(String value) {
                return Double.valueOf(value);
            }
        });

        // String to Float converter
        CONVERT_STRATEGY.put(Float.class, new ConvertFunction<String, Float>() {
            public Float apply(String value) {
                return Float.valueOf(value);
            }
        });

        // String to Integer converter
        CONVERT_STRATEGY.put(Integer.class, new ConvertFunction<String, Integer>() {
            public Integer apply(String value) {
                return Integer.valueOf(value);
            }
        });

        // String to Long converter
        CONVERT_STRATEGY.put(Long.class, new ConvertFunction<String, Long>() {
            public Long apply(String value) {
                return Long.valueOf(value);
            }
        });

        // String to Short converter
        CONVERT_STRATEGY.put(Short.class, new ConvertFunction<String, Short>() {
            public Short apply(String value) {
                return Short.valueOf(value);
            }
        });
    }

    /**
     * Registers provided as anonymous class converter for given type
     * @param type type to convert
     * @param closure anonymous class of interface @see ConvertFunction
     */
    public static void registerConverter(Class type, ConvertFunction<String, ?> closure) {
        CONVERT_STRATEGY.put(type, closure);
    }

    /**
     * Convert the given object value to the given class.
     * @param from The object value to be converted.
     * @param to The type class which the given object should be converted to.
     * @return The converted object value.
     * @throws NullPointerException If 'to' is null.
     * @throws UnsupportedOperationException If no converter for given type can be found.
     */
    public static <T> Object convert(Object from, Class<T> to) throws Exception {
        if (from == null) {
            return null;
        }

        if (to.isAssignableFrom(from.getClass())) {
            return to.cast(from);
        }

        ConvertFunction<String, ?> converterFunction = CONVERT_STRATEGY.get(to.getClass());
        if (converterFunction == null) {
            throw new UnsupportedOperationException("Cannot convert from "
                + from.getClass().getName() + " to " + to.getName()
                + ". Converter does not exist.");
        }

        return converterFunction.apply(from.toString());
    }
}
