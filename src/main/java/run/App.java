package run;

import config.AppUI;

import service.impl.ConverterImpl;
import entity.Currency;

import entity.Temperature;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class App {
    static Currency currency = new Currency(new ConverterImpl());
    static Temperature temperature = new Temperature(new ConverterImpl());
    static String[] SHOW_OPTIONS_STARTED = {"Conversor de Moneda", "Conversor de Temperatura"};
    static JLabel LABEL_STARTED = AppUI.setLabel("Elija el tipo de conversión que desea realizar: ");
    static JComboBox<String> COMBO_BOX_STARTED = new JComboBox<>(SHOW_OPTIONS_STARTED);

    public static void main(String[] args) {
        do {
            int resultSelection = AppUI.showMenuOptions(SHOW_OPTIONS_STARTED, COMBO_BOX_STARTED, LABEL_STARTED);

            if (resultSelection == JOptionPane.CLOSED_OPTION || resultSelection == 1 ) {
                AppUI.userWantsToExit = AppUI.userWantsToExit();
                if (AppUI.userWantsToExit) {
                    AppUI.showSimpleMessage("Programa terminado");
                    break;
                }
            }else if(resultSelection == 0) {
                AppUI.showMenuHome(resultSelection, COMBO_BOX_STARTED);
                if (AppUI.userWantsToExit) {
                    AppUI.showSimpleMessage("Programa terminado");
                    break;
                }
            }
        } while (!AppUI.userWantsToExit);
    }

    public static String[] getCurrencyOptions(){
        List<String> keys = new ArrayList<>(currency.getCurrencyConverter().keySet());
        return keys.toArray(new String[0]);
    }

    public static String[] getTemperatureOptions() {
        List<String> keys = new ArrayList<>(temperature.getTemperatureConverter().keySet());
        return keys.toArray(new String[0]);
    }

}
