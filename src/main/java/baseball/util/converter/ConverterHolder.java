package baseball.util.converter;

import java.util.List;

public class ConverterHolder {
    private static ThreadLocal<List<Converter>> converterHolder = new ThreadLocal<>();

    public static void setConverters(List<Converter> converters) {
        converterHolder.set(converters);
    }

    public static <T extends Object> T convert(Object target, Class convertTo) {
        List<Converter> converters = converterHolder.get();
        for (Converter converter : converters) {
            if (converter.supports(target, convertTo)) {
                return (T) converter.convert(target);
            }
        }
        throw new IllegalArgumentException("잘못된 입력 및 반환 형식입니다.");
    }

    public static void clearHolder() {
        converterHolder.remove();
    }
}
