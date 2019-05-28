package springbasic.format;

import org.springframework.format.support.FormattingConversionService;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
//        FormattingConversionService service = new FormattingConversionService();

        DateFormatter formatter = new DateFormatter("yyyyMMdd-HH:MM:SS");
//        Date d = formatter.parse("20090912-12:23:59", Locale.ENGLISH);
//        System.out.println(d);

        System.out.println(formatter.print(new Date(), Locale.ENGLISH));
    }
}
