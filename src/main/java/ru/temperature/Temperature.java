package ru.temperature;

// класс Temperature по сути является обобщённым (он в целом не будет использоваться, он для всех является родительским)
public class Temperature {
    private double temp; // температура

    // дефолтный конструктор
    Temperature(double temp) {
        this.temp = temp;
    }

    // сеттер
    public void setTemp(double temp) {
        this.temp = temp;
    }

    // геттер
    public double getTemp() {
        return temp;
    }

    // переопределяем метод toString(), чтобы он возвращал не имя класса, а температуру
    @Override
    public String toString() {
        // т. к. temp имеет тип double, то делаем явное приведение
        return String.valueOf(temp);
    }
}
