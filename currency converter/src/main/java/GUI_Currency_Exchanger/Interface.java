package GUI_Currency_Exchanger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static GUI_Currency_Exchanger.ApiConnection.*;

public class Interface {
private JLabel currencyToSell;
private JLabel currencyToBuy;
private JLabel amount;
private JTextField amountToConvert;
private JButton convert;
private JComboBox fromRate;
private JComboBox toRate;
private double currencyFrom;
private double currencyTo;
private double amountConverted;
private JLabel amountAfter;
private JTextField amountAfterConversion;

    public static double round(double value, int position) {
        if (position < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, position);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }


    public static void main(String[] args) {




        JFrame currencyConverter = new JFrame("Currency Converter");

        JButton Convert = new JButton("Convert");
        Convert.setBounds(125,300,90,30);

        JLabel currencyFrom = new JLabel("From: ");
        currencyFrom.setBounds(20,20,50,50);

        JLabel currencyTo = new JLabel("To: ");
        currencyTo.setBounds(20,50,50,50);

        JLabel amount = new JLabel("Amount: ");
        amount.setBounds(20,80,50,50);

        JTextField amountToConvert = new JTextField();
        amountToConvert.setBounds(120,95,160,20);

        JLabel amountAfter = new JLabel("Amount After: ");
        amountAfter.setBounds(20,120,100,50);

        JTextField amountAfterConversion = new JTextField();
        amountAfterConversion.setBounds(120,130,160,20);

        JComboBox rateFrom = new JComboBox();
        rateFrom.setBounds(120,35,160,20);

        JComboBox rateTo = new JComboBox();
        rateTo.setBounds(120,65,160,20);



        rateFrom.addItem("AUD: Australian Dollar");
        rateFrom.addItem("YUAN: Chinese Yuan");
        rateFrom.addItem("YEN: Japanese Yen");
        rateFrom.addItem("EUR: Euro");
        rateFrom.addItem("USD: United States Dollar");

        rateTo.addItem("AUD: Australian Dollar");
        rateTo.addItem("YUAN: Chinese Yuan");
        rateTo.addItem("YEN: Japanese Yen");
        rateTo.addItem("EUR: Euro");
        rateTo.addItem("USD: United States Dollar");



    currencyConverter.add(Convert); currencyConverter.add(currencyFrom);
    currencyConverter.add(currencyTo);currencyConverter.add(rateFrom);
    currencyConverter.add(rateTo);currencyConverter.add(amount);
    currencyConverter.add(amountToConvert);currencyConverter.add(amountAfter);
    currencyConverter.add(amountAfterConversion);
        currencyConverter.setSize(400,400);
        currencyConverter.setLayout(null);
        currencyConverter.setVisible(true);


        Convert.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    ApiConnection exchangegetter = new ApiConnection();
                    double CNY = ApiConnection.CNY;
                    double EUR = ApiConnection.EUR;
                    double JPY = ApiConnection.JPY;
                    double AUD = exchangegetter.AUD;
                    double USD = exchangegetter.USD;
                } catch (IOException error) {
                    System.out.println("error");
                }


                double currencyFrom = 0;
                double currencyTo = 0;
                double amount = Double.parseDouble(amountToConvert.getText());


                if(rateFrom.getSelectedItem().equals("EUR: Euro")){
                    currencyFrom = EUR;
                }
                if(rateFrom.getSelectedItem().equals("AUD: Australian Dollar")){
                    currencyFrom = AUD;
                }
                if(rateFrom.getSelectedItem().equals("YEN: Japanese Yen")){
                    currencyFrom = JPY;
                }
                if(rateFrom.getSelectedItem().equals("YUAN: Chinese Yuan")){
                    currencyFrom = CNY;
                }
                if(rateFrom.getSelectedItem().equals("USD: United States Dollar")){
                    currencyFrom = USD;
                }

                if(rateTo.getSelectedItem().equals("USD: United States Dollar")){
                    currencyTo = USD;
                }
                if(rateTo.getSelectedItem().equals("AUD: Australian Dollar")){
                    currencyTo = AUD;
                }
                if(rateTo.getSelectedItem().equals("EUR: Euro")){
                    currencyTo = EUR;
                }
                if(rateTo.getSelectedItem().equals("YEN: Japanese Yen")){
                    currencyTo = JPY;
                }
                if(rateTo.getSelectedItem().equals("YUAN: Chinese Yuan")){
                    currencyTo = CNY;
                }

                double conversion = (currencyTo/currencyFrom)*amount;
                String converted = String.valueOf(round(conversion, 3));
                amountAfterConversion.setText(converted);

            }
        });



    }


}
