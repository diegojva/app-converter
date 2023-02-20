package util;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TemperatureUtil {

    private static final Map<String, String> TEMPERATURE_SYMBOL = Map.ofEntries(
            Map.entry("De Celsius a Fahrenheit", "°F"),
            Map.entry("De Fahrenheit a Celsius", "°C"),
            Map.entry("De Celsius a Kelvin", "°K"),
            Map.entry("De Kelvin a Celsius", "°C"),
            Map.entry("De Fahrenheit a Kelvin", "°K"),
            Map.entry("De Kelvin a Fahrenheit", "°F")
    );

    public static Map<String, String> getTemperatureSymbol() {
        return TEMPERATURE_SYMBOL;
    }

    public static String[] getTemperatureOptions(){
        List<String> keys = new ArrayList<>(TEMPERATURE_SYMBOL.keySet());
        return keys.toArray(new String[0]);
    }
}
