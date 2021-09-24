// Шаблон Фабрика
// 2 основные реализации:
// 1) фабрика (фабричный класс), которая порождена каким-то классом со статическим методом (используется, когда есть определённый
// входящий параметр, по которому мы конструируем необходимые объекты; при этом мы не знаем, какой объект будет
// конструироваться); т. е. на вход приходит что-то одно, а на выходе может быть несколько вариантов
// 2) фабричный метод -- используется, когда мы получаем (на вход) что-то разное, а хотим получить (на выходе) что-то одно конкретное
// Пример: String.valueOf(temp)
// Здесь метод valueOf класса String является фабричным методом; это статический метод строки, который позволяет конструировать
// строки из любого входящего (базового) типа (базовый тип -> строка); т. е. если (на вход) может прийти несколько разных
// (вариантов), а на выходе получится что-то одно, то используется фабричный метод; используем фабричный метод внутри того
// класса, в котором это надо
// Почти любой статический метод можно назвать фабрикой

import ru.converter.CelsiusToCelsiusConverter;
import ru.converter.CelsiusToFahrenheitConverter;
import ru.converter.Converter;
import ru.temperature.CelsiusTemperature;
import ru.temperature.Temperature;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

// сейчас выгоднее делать фабричный класс
public class ConverterFactory {
    // преобразование температуры по цельсию в температуру по фаренгейту требуется для определённого списка стран
    // fahrenheitCountries -- неизменяемый (final) список стран (набор из строк); конструктор класса HashSet умеет принимать list'ы
    private static final Set<String> fahrenheitCountries = new HashSet<>(Arrays.asList("BS", "US", "BZ", "KY", "PW"));

    // этот метод возвращает конвертер; static -- чтобы не создавать экземпляр этого класса
    // убрали слово static, т. к. factory-method (для Spring) должен быть нестатическим
    public Converter getConverter(Locale locale) {
        // если страна входит в список этих стран
        if (fahrenheitCountries.contains(locale.getCountry())) {
            return new CelsiusToFahrenheitConverter(); // возвращаем конвертер C -> F
        } else {
            return new CelsiusToCelsiusConverter(); // возвращаем конвертер C -> C
        }
    }
}