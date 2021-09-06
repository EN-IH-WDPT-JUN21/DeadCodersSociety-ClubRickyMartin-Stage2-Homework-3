package com.ironhack.homework3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ListCountry {

    private static final Set<String> ISO_COUNTRIES = new HashSet<String>
            (Arrays.asList(Locale.getISOCountries()));
    public static Locale.IsoCountryCode[] isoCountryCode;


    public static void listCountry(String[] args) {
        ListCountry obj = new ListCountry();
        obj.run();
    }

    //prints full list of ISO country codes and country names with default Locale
    public static void run() {
        String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            System.out.println("Country Code = " + obj.getCountry()
                    + ", Country Name = " + obj.getDisplayCountry());
        }
        System.out.println("Done");
    }

    //returns country name based on given ISO country code
    public static String getCountry(String countryCode){
        Locale l = new Locale("", countryCode);
        return l.getDisplayCountry();
    }

    //checks if given code is a valid ISO country code
    public static boolean isValidISOCountry(String s) {
        return ISO_COUNTRIES.contains(s);
    }
}