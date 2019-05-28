package springbasic.conversion;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConversionService service = new DefaultConversionService();
        System.out.println(service.canConvert(String.class, Boolean.class));
        System.out.println(service.convert("true", Boolean.class));

        List<Integer> input = Arrays.asList(1,2,3);
        List<String> output = (List<String>)service.convert(input, TypeDescriptor.forObject(input), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)));

    }

}
