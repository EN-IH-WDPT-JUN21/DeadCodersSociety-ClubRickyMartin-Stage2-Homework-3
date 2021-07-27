import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ListCountry {

    private static final Set<String> ISO_LANGUAGES = new HashSet<String>
            (Arrays.asList(Locale.getISOLanguages()));
    private static final Set<String> ISO_COUNTRIES = new HashSet<String>
            (Arrays.asList(Locale.getISOCountries()));


    public static boolean isValidISOLanguage(String s) {
        return ISO_LANGUAGES.contains(s);
    }

    public static boolean isValidISOCountry(String s) {
        return ISO_COUNTRIES.contains(s);
    }

    public static void main(String[] args) {
        ListCountry obj = new ListCountry();
        obj.run();
    }
    public static void run() {

        String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("en", countryCode);
            System.out.println("Country Code = " + obj.getCountry()
                    + ", Country Name = " + obj.getDisplayCountry());
        }
        System.out.println("Done");
    }

    public static String getCountry(String countryCode){
        Locale l = new Locale("", countryCode);
        return l.getDisplayCountry();
    }
}