package util;


import java.util.*;

public class CurrencyUtil {

    private static final Map<String, String> CURRENCY_SYMBOL = Map.ofEntries(
            Map.entry("De Soles a Dolares", "$"),
            Map.entry("De Soles a Euros", "€"),
            Map.entry("De Soles a Libras Esterlinas", "£"),
            Map.entry("De Soles a Yen Japónes", "¥"),
            Map.entry("De Soles a Won sur-coreano", "₩"),
            Map.entry("De Dolares a Soles", "S/"),
            Map.entry("De Euros a Soles", "S/"),
            Map.entry("De Libras Esterlinas a Soles", "S/"),
            Map.entry("De Yen Japónes a Soles", "S/"),
            Map.entry("De Won sur-coreano a Soles", "S/")
    );

    public static Map<String, String> getCurrencySymbol() {
        return CURRENCY_SYMBOL;
    }


    public static String[] getCurrencyOptions(){
        List<String> keys = new ArrayList<>(CURRENCY_SYMBOL.keySet());
        return keys.toArray(new String[0]);
    }

}
