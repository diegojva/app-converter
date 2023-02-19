package service;

import java.math.BigDecimal;

public interface CurrencyConverter {

    BigDecimal convertSolesToDolares(BigDecimal amount);
    BigDecimal convertSolesToEuros(BigDecimal amount);
    BigDecimal convertSolesToLibrasEsterlinas(BigDecimal amount);
    BigDecimal convertSolesToYenesJapones(BigDecimal amount);
    BigDecimal convertSolesToWonSurCoreano(BigDecimal amount);
    BigDecimal convertDolaresToSoles(BigDecimal amount);
    BigDecimal convertEurosToSoles(BigDecimal amount);
    BigDecimal convertLibrasEsterlinasToSoles(BigDecimal amount);
    BigDecimal convertYenesJaponesToSoles(BigDecimal amount);
    BigDecimal convertWonSurCoreanoToSoles(BigDecimal amount);

}
