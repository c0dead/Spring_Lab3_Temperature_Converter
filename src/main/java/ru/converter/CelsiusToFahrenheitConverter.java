package ru.converter;

import ru.temperature.CelsiusTemperature;
import ru.temperature.FahrenheitTemperature;
import ru.temperature.Temperature;

// это класс, который реализует наш интерфейс Converter
public class CelsiusToFahrenheitConverter implements Converter {
    @Override
    public Temperature convert(Temperature temp) throws ClassCastException {
        // мы определили тип температуры по цельсию для того, чтобы в наш конвертер можно было положить только
        // правильную температуру (температуру по цельсию)

        // смотрим, какая температура была подана в конвертер, и спрашиваем у среды, является ли она (температура)
        // тем типом, который мы ожидаем, т. е. является ли она температурой по цельсию
        // ключевое слово instanceOf -- это попытка проверки типа без явного cast'а
        // явный cast: CelsiusTemperature celsiusTemperature = (CelsiusTemperature) temp;

        // если в конвертер была подана температура по цельсию, то преобразуем её в температуру по фаренгейту
        if (temp instanceof CelsiusTemperature) {
            return new FahrenheitTemperature(temp.getTemp() * 1.8 + 32.0);
        }
        // если в конвертер была подана температура НЕ по цельсию, то выбрасываем исключение
        // ClassCastException -- ошибка преобразования типа (произодёт, если делать явный cast без проверок)
        throw new ClassCastException("It is only possible to convert temperature in Celsius");
    }
}
