package util;

import java.util.Map;

public class TemperatureUtil {

    private final Map<String, String> TEMPERATURE_SYMBOL = Map.ofEntries(
            Map.entry("De Celsius a Fahrenheit", "°F"),
            Map.entry("De Fahrenheit a Celsius", "°C"),
            Map.entry("De Celsius a Kelvin", "°K"),
            Map.entry("De Kelvin a Celsius", "°C"),
            Map.entry("De Fahrenheit a Kelvin", "°K"),
            Map.entry("De Kelvin a Fahrenheit", "°F")
    );

    public Map<String, String> getTemperatureSymbol() {
        return TEMPERATURE_SYMBOL;
    }
}
