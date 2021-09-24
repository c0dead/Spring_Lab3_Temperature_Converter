import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.converter.Converter;
import ru.temperature.CelsiusTemperature;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Создаём контекст, в качестве аргумента передаём название конфигурационного файла.
        // Класс ClassPathXmlApplicationContext откроет указанный файл и создаст нам pool (бассейн) бинов,
        // которые были описаны в указанном файле;
        // класс ClassPathXmlApplicationContext обращается к файлу applicationContext.xml, считывает его и
        // помещает все описанные в нём бины в applicationContext
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Получаем бин: в качестве аргументов передаём id бина и класс, бин/объект которого хотим получить.
        // В нашем случае мы хотим получить интерфейс
        Converter converter = context.getBean("converter", Converter.class);

        // Converter converter = context.getBean("celsiusConverter", Converter.class);
        // Converter converter = ConverterFactory.getConverter(locale); // получили конвертер

        Locale locale = context.getBean("locale", Locale.class); // получаем локаль
        // Locale locale = Locale.getDefault(); // получили локаль

        // считываем температуру
        Scanner in = new Scanner(System.in);
        CelsiusTemperature temperature = new CelsiusTemperature(in.nextDouble());// создаём температуру по цельсию, которую получили с консоли
        System.out.println(converter.convert(temperature)); // выводим на экран преобразованную температуру
        context.close(); // всегда закрываем context
    }
}
