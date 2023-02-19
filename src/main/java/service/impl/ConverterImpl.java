package service.impl;

import service.CurrencyConverter;
import service.TemperatureConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConverterImpl implements CurrencyConverter, TemperatureConverter {

    @Override
    public BigDecimal convertSolesToDolares(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.26"));
    }

    @Override
    public BigDecimal convertSolesToEuros(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.24"));
    }

    @Override
    public BigDecimal convertSolesToLibrasEsterlinas(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.21"));
    }
    @Override
    public BigDecimal convertSolesToYenesJapones(BigDecimal amount) {
        return amount.multiply(new BigDecimal("34.821"));
    }
    @Override
    public BigDecimal convertSolesToWonSurCoreano(BigDecimal amount) {
         return amount.multiply(new BigDecimal("339.73"));
    }
    @Override
    public BigDecimal convertDolaresToSoles(BigDecimal amount) {
        return amount.multiply(new BigDecimal("3.83"));
    }

    @Override
    public BigDecimal convertEurosToSoles(BigDecimal amount) {
        return amount.multiply(new BigDecimal("4.11"));
    }

    @Override
    public BigDecimal convertLibrasEsterlinasToSoles(BigDecimal amount) {
        return amount.multiply(new BigDecimal("4.62"));
    }
    @Override
    public BigDecimal convertYenesJaponesToSoles(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.028"));
    }

    @Override
    public BigDecimal convertWonSurCoreanoToSoles(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.003"));
    }

    @Override
    public BigDecimal convertCelsiusToFahrenheit(BigDecimal celsius) {
        return celsius.multiply(new BigDecimal("1.8")).add(new BigDecimal("32"));
    }

    @Override
    public BigDecimal convertFahrenheitToCelsius(BigDecimal fahrenheit) {
        return fahrenheit.subtract(new BigDecimal("32.0")).divide(new BigDecimal("1.8"), RoundingMode.CEILING);
    }

    @Override
    public BigDecimal convertCelsiusToKelvin(BigDecimal celsius) {
        return celsius.add(new BigDecimal("273.15"));
    }

    @Override
    public BigDecimal convertKelvinToCelsius(BigDecimal kelvin) {
        return kelvin.subtract(new BigDecimal("273.15"));
    }

    @Override
    public BigDecimal convertFahrenheitToKelvin(BigDecimal fahrenheit) {
        return fahrenheit.add(new BigDecimal("459.67")).multiply(new BigDecimal("5")).divide(new BigDecimal("9"), RoundingMode.CEILING);
    }

    @Override
    public BigDecimal convertKelvinToFahrenheit(BigDecimal kelvin) {
        return kelvin.multiply(new BigDecimal("9")).divide(new BigDecimal("5")).subtract(new BigDecimal("459.67"));
    }
}
