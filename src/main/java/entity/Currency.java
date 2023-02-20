package entity;

import lombok.Data;
import service.CurrencyConverter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class Currency {
    private BigDecimal amount = new BigDecimal("0.00");
    private final CurrencyConverter currencyConverter;
    private final Map<String, Function<BigDecimal, BigDecimal>> CURRENCY_CONVERTER = new HashMap<>();

     public Currency(CurrencyConverter currencyConverter){
        this.currencyConverter = currencyConverter;
        CURRENCY_CONVERTER.put("De Soles a Dolares", currencyConverter::convertSolesToDolares);
        CURRENCY_CONVERTER.put("De Soles a Euros", currencyConverter::convertSolesToEuros);
        CURRENCY_CONVERTER.put("De Soles a Libras Esterlinas", currencyConverter::convertSolesToLibrasEsterlinas);
        CURRENCY_CONVERTER.put("De Soles a Yen Japónes", currencyConverter::convertSolesToYenesJapones);
        CURRENCY_CONVERTER.put("De Soles a Won sur-coreano", currencyConverter::convertSolesToWonSurCoreano);
        CURRENCY_CONVERTER.put("De Dolares a Soles", currencyConverter::convertDolaresToSoles);
        CURRENCY_CONVERTER.put("De Euros a Soles", currencyConverter::convertEurosToSoles);
        CURRENCY_CONVERTER.put("De Libras Esterlinas a Soles", currencyConverter::convertLibrasEsterlinasToSoles);
        CURRENCY_CONVERTER.put("De Yen Japónes a Soles", currencyConverter::convertYenesJaponesToSoles);
        CURRENCY_CONVERTER.put("De Won sur-coreano a Soles", currencyConverter::convertWonSurCoreanoToSoles);
    }

    public Map<String, BigDecimal> getCurrencyConverter() {
        return CURRENCY_CONVERTER.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().apply(amount)));
    }

}
