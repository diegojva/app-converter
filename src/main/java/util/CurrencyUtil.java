package util;

import java.util.HashMap;
import java.util.Map;

public class CurrencyUtil {

    private final Map<String, String> CURRENCY_SYMBOL = new HashMap<>();

    public CurrencyUtil(){
        CURRENCY_SYMBOL.put("De Soles a Dolares", "$");
        CURRENCY_SYMBOL.put("De Soles a Euros", "€");
        CURRENCY_SYMBOL.put("De Soles a Libras Esterlinas", "£");
        CURRENCY_SYMBOL.put("De Soles a Yen Japónes", "¥");
        CURRENCY_SYMBOL.put("De Soles a Won sur-coreano", "₩");
        CURRENCY_SYMBOL.put("De Dolares a Soles", "S/");
        CURRENCY_SYMBOL.put("De Euros a Soles", "S/");
        CURRENCY_SYMBOL.put("De Libras Esterlinas a Soles", "S/");
        CURRENCY_SYMBOL.put("De Yen Japónes a Soles", "S/");
        CURRENCY_SYMBOL.put("De Won sur-coreano a Soles", "S/");
    }

    public Map<String, String> getCurrencySymbol() {
        return CURRENCY_SYMBOL;
    }

}
