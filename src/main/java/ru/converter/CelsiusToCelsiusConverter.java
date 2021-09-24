package ru.converter;

import ru.temperature.CelsiusTemperature;
import ru.temperature.FahrenheitTemperature;
import ru.temperature.Temperature;

public class CelsiusToCelsiusConverter implements Converter {
    @Override
    public Temperature convert(Temperature temp) throws ClassCastException {

        if (temp instanceof CelsiusTemperature) {
            return new CelsiusTemperature(temp.getTemp());
        }
        throw new ClassCastException("It is only possible to convert temperature in Celsius");
    }
}
