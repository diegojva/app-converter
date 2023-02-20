package config;

import enums.CurrencySymbol;
import enums.TemperatureSymbol;
import lombok.Data;
import run.App;
import service.impl.ConverterImpl;
import util.CurrencyUtil;
import util.TemperatureUtil;

import javax.swing.*;
import java.awt.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

@Data
public class AppUI {

    static DecimalFormat df = new DecimalFormat("#,###.##");
    static BigDecimal moneyInput = new BigDecimal("0.00");
    static BigDecimal temperatureInput = new BigDecimal("1");
    static String[] currencyOptions = App.getCurrencyOptions();
    static String[] temperatureOptions = App.getTemperatureOptions();
    public static boolean userWantsToExit = false;
    static CurrencyUtil currencySymbol = new CurrencyUtil();
    static TemperatureUtil temperatureSymbol = new TemperatureUtil();

    private static JPanel configMenu(JComboBox<String> comboBox, JLabel label) {
        configStyleApp();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);
        panel.add(comboBox);

        return panel;
    }

    public static void showMenuHome(int userSelectionTypeConverter, JComboBox<String> comboBox) {

        String userSelectionTypeConverterText = Objects.requireNonNull(comboBox.getSelectedItem()).toString();
        JComboBox <String> optionsComboBox;
        int resultSelection;

        if (userSelectionTypeConverter == 0) {
            switch (userSelectionTypeConverterText) {
                case "Conversor de Moneda" -> {

                    optionsComboBox = new JComboBox<>(currencyOptions);
                    moneyInput = inputTextValue();

                    if (moneyInput == null){break;}

                    resultSelection = showMenuOptions(
                            currencyOptions,
                            optionsComboBox,
                            setLabel("Elija la moneda a la que deseas convertir tu dinero: "));

                    if (resultSelection == 0) printResult("currency", String.valueOf(moneyInput), optionsComboBox);
                    else userWantsToExit = userWantsToExit();
                }
                case "Conversor de Temperatura" -> {

                    optionsComboBox = new JComboBox<>(temperatureOptions);
                    temperatureInput = inputTextValue();

                    if(temperatureInput == null) {break;}

                    resultSelection = showMenuOptions(
                            temperatureOptions, optionsComboBox,
                            setLabel("Elija la temperatura a la que deseas convertir tu dinero: "));

                    if (resultSelection == 0) printResult("temperature", String.valueOf(temperatureInput), optionsComboBox);
                    else userWantsToExit = userWantsToExit();
                }
            }
        }else {userWantsToExit = userWantsToExit();}
    }

    public static JLabel setLabel(String message){
        JLabel label = new JLabel(message);
        label.setAlignmentX(JLabel.RIGHT_ALIGNMENT);

        return label;
    }
    public static BigDecimal inputTextValue(){
        BigDecimal value = null;
        while (value == null) {
            try {
                String inputText  = JOptionPane.showInputDialog("Ingrese la cantidad que desea convertir: ");
                if (inputText == null ){
                    userWantsToExit = userWantsToExit();
                    break;
                }
                value = new BigDecimal(inputText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }
        return value;
    }

    public static int showMenuOptions(String [] options, JComboBox<String> comboBox, JLabel label){
        return JOptionPane.showOptionDialog(null, configMenu(comboBox, label), "Menu - Alura LATAM",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"OK", "Cancel"}, options[0]);
    }

    public static void printResult(String typeResult, String inputValue, JComboBox<String> comboBox){
        df.setMinimumFractionDigits(2);
        if(typeResult.equals("currency")){
            String selectedCurrencyText = Objects.requireNonNull(comboBox.getSelectedItem()).toString();
            BigDecimal resultAmount = ConverterImpl.convertInputValue("currency",inputValue, selectedCurrencyText);
            currencySymbol.getCurrencySymbol().forEach((key, value) -> {
                if (key.equals(selectedCurrencyText)) {
                    showSimpleMessage("Tienes " + value + " " + df.format(resultAmount) + " " + CurrencySymbol.getValueByKey(value));
                }
            });
            userWantsToExit = userWantsToExit();
        }
        else if(typeResult.equals("temperature")){
            String selectedTemperatureText = Objects.requireNonNull(comboBox.getSelectedItem()).toString();
            BigDecimal result = ConverterImpl.convertInputValue("temperature",inputValue, selectedTemperatureText);
            temperatureSymbol.getTemperatureSymbol().forEach((key, value) -> {
                if (key.equals(selectedTemperatureText)) {
                    showSimpleMessage("Temperatura " + value + " " + result + " " + TemperatureSymbol.getValueByKey(value));
                }
            });
            userWantsToExit = userWantsToExit();
        }
    }

    public static void showSimpleMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static boolean userWantsToExit() {
        return  JOptionPane.showConfirmDialog(null,
                "¿Desea continuar con el programa?", "Confirmación",
                JOptionPane.YES_NO_OPTION) != 0;
    }
    public static void configStyleApp() {
        UIManager.put("Label.align", SwingConstants.LEFT);
        UIManager.put("OptionPane.background", new Color(220, 240, 255));
        UIManager.put("Panel.background", new Color(220, 240, 255));
        UIManager.put("OptionPane.messageForeground", Color.black);
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("Button.background", new Color(0, 174, 239));
        UIManager.put("Button.foreground", Color.white);
        UIManager.put("Button.select", new Color(0, 120, 215));
        UIManager.put("Button.focus", new Color(0, 120, 215, 50));
    }

}
