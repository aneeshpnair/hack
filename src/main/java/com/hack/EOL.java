package com.hack;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class EOL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US : " + nf.format(payment));

        nf = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        System.out.println("India: " + nf.format(payment));
        
        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("China: " + nf.format(payment));
        
        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("France: " + nf.format(payment));
    }
}
