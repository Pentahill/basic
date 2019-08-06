package springbasic.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {

    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return null;
    }

    private final class StringToEnumConverter implements Converter<String, Enum> {



        @Override
        public Enum convert(String source) {
            return Enum.valueOf(Enum.class, source);
        }
    }

}
