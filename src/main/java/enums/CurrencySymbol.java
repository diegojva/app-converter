package enums;

public enum CurrencySymbol {

    PEN("S/", "Soles"),
    USD("$", "Dolares"),
    EUR("€", "Euros"),
    GBP("£", "Libras Esterlinas"),
    WON("₩", "Won sur-coreano"),
    YEN("¥", "Yen Japones");

    private final String key;
    private final String value;

    CurrencySymbol(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByKey(String key) {
        for (CurrencySymbol symbolText : CurrencySymbol.values()) {
            if (symbolText.getKey().equals(key)) {
                return symbolText.getValue();
            }
        }
        return null;
    }

}
