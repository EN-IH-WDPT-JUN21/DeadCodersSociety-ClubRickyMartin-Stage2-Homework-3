import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ListCountry {

    private static final Set<String> ISO_LANGUAGES = new HashSet<>
            (Arrays.asList(Locale.getISOLanguages()));
    private static final Set<String> ISO_COUNTRIES = new HashSet<>
            (Arrays.asList(Locale.getISOCountries()));
    public static Locale.IsoCountryCode[] isoCountryCode;

    public static void listCountry(String[] args) {
        ListCountry obj = new ListCountry();
        run();
    }

    public static void run() {
        String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            System.out.println("Country Code = " + obj.getCountry()
                    + ", Country Name = " + obj.getDisplayCountry());
        }
        System.out.println("Done");
    }

    public static String getCountry(String countryCode){
        Locale l = new Locale("", countryCode);
        return l.getDisplayCountry();
    }

    public static boolean isValidISOLanguage(String s) {
        return ISO_LANGUAGES.contains(s);
    }

    public static boolean isValidISOCountryCode(String s) {
        String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            if (obj.getCountry().equalsIgnoreCase(s)){
                return true;
        }
        }
        return false;
    }

    public static boolean isValidISOCountry(String s) {
        return ISO_COUNTRIES.contains(s);
    }
}