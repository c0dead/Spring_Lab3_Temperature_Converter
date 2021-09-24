package ru.temperature;

public class FahrenheitTemperature extends Temperature {
    public FahrenheitTemperature(double temp) {
        super(temp); // вызов констуктора; ключевое слово super -- обращение к супер-классу
                     // (родительскому классу Temperature, конструктор которого принимает double temp)
    }

    // переопределяем метод toString(), чтобы было видно, что это за температура
    @Override
    public String toString() {
        // родительский метод toString() возвращает число
        return super.toString() + " fahrenheit";
    }
}
