package baseball.util.converter;

public interface Converter<S, T>  {
    boolean supports(Object from, Class<?> to);

    T convert(S source);
}
