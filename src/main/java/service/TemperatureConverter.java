package service;

import java.math.BigDecimal;

public interface TemperatureConverter {

    BigDecimal convertCelsiusToFahrenheit(BigDecimal celsius);
    BigDecimal convertFahrenheitToCelsius(BigDecimal fahrenheit);
    BigDecimal convertCelsiusToKelvin(BigDecimal celsius);
    BigDecimal convertKelvinToCelsius(BigDecimal kelvin);
    BigDecimal convertFahrenheitToKelvin(BigDecimal fahrenheit);
    BigDecimal convertKelvinToFahrenheit(BigDecimal kelvin);

}
