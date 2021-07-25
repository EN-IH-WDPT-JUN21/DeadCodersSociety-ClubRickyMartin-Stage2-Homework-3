import org.junit.platform.commons.util.StringUtils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.WordUtils;

public class Validations {

    //email validator
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    //Phone number validator
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    // validate first name
    public static boolean isValidFirstName(String firstName)
    {
        String fName= WordUtils.capitalizeFully(firstName.trim());
        return fName.matches( "[A-Z][a-zA-Z]*" );
    }
    // validate last name
    public static boolean isValidLastName(String lastName)
    {
        String lName= WordUtils.capitalizeFully(lastName.trim());
        return lName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
    }
}
