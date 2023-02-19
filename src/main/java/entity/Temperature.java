package entity;

import lombok.Data;
import service.CurrencyConverter;
import service.TemperatureConverter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class Temperature {

    private BigDecimal value = new BigDecimal("1");
    private final TemperatureConverter currencyConverter;
    private final Map<String, Function<BigDecimal, BigDecimal>> TEMPERATURE_CONVERTER = new HashMap<>();

    public Temperature(TemperatureConverter currencyConverter){
        this.currencyConverter = currencyConverter;
        TEMPERATURE_CONVERTER.put("De Celsius a Fahrenheit", currencyConverter::convertCelsiusToFahrenheit);
        TEMPERATURE_CONVERTER.put("De Fahrenheit a Celsius", currencyConverter::convertFahrenheitToCelsius);
        TEMPERATURE_CONVERTER.put("De Celsius a Kelvin", currencyConverter::convertCelsiusToKelvin);
        TEMPERATURE_CONVERTER.put("De Kelvin a Celsius", currencyConverter::convertKelvinToCelsius);
        TEMPERATURE_CONVERTER.put("De Fahrenheit a Kelvin", currencyConverter::convertFahrenheitToKelvin);
        TEMPERATURE_CONVERTER.put("De Kelvin a Fahrenheit", currencyConverter::convertKelvinToFahrenheit);
    }

    public Map<String, BigDecimal> getTemperatureConverter() {
        return TEMPERATURE_CONVERTER.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(value)));
    }


}
