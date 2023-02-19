package enums;

public enum TemperatureSymbol {

    CELSIUS("°C", "Celsius"),
    FAHRENHEIT("°F", "Fahrenheit"),
    KELVIN("°K", "Kelvin");

    private final String symbol;
    private final String text;

    TemperatureSymbol(String symbol, String text) {
        this.symbol = symbol;
        this.text = text;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getText() {
        return text;
    }

    public static String getValueByKey(String key) {
        for (TemperatureSymbol symbolText : TemperatureSymbol.values()) {
            if (symbolText.getSymbol().equals(key)) {
                return symbolText.getText();
            }
        }
        return null;
    }
}
