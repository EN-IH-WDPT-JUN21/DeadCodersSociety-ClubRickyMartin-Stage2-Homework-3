import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.WordUtils;

public class Validations {


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


    public static boolean isValidPhoneNumber(String phoneNumber) {
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }


    public static boolean isValidFirstName(String firstName)
    {
        String fName= WordUtils.capitalizeFully(firstName.trim());
        return fName.matches( "[A-Z][a-zA-Z]*" );
    }

    public static boolean isValidLastName(String lastName)
    {
        String lName= WordUtils.capitalizeFully(lastName.trim());
        return lName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
    }


    public static boolean isValidMenuCommand(String command) {
        final Pattern newLead = Pattern.compile("newlead");
        final Pattern showLeads = Pattern.compile("showleads");
        final Pattern lookUpLeads = Pattern.compile("lookuplead\\d+");
        final Pattern convertLead = Pattern.compile("convert\\d+");
        final Pattern closeLost = Pattern.compile("close-lost\\d+");
        final Pattern closeWon = Pattern.compile("close-won\\d+");
        final Pattern help = Pattern.compile("help");
        //converts input into cleaned, lowercase command
        command=Menu.convertUserInputToCommand(command);
        return newLead.matcher(command).matches() ||
                showLeads.matcher(command).matches() ||
                lookUpLeads.matcher(command).matches() ||
                convertLead.matcher(command).matches() ||
                closeLost.matcher(command).matches() ||
                closeWon.matcher(command).matches() ||
                help.matcher(command).matches();
    }
    //removes all characters and leaves only digits - used to extract id from input
    public static int removeAllCharacters(String command){
        String text=Menu.convertUserInputToCommand(command).replaceAll("\\D+","");
        if(!text.equals("")) {
            return Integer.parseInt(text.replaceAll("\\D+", ""));
        }else {
            return 0;
        }
    }
    //removes all digits and leaves only command - used to extract command from input
    public static String removeAllDigits(String command){
        String text=Menu.convertUserInputToCommand(command);
        return text.replaceAll("\\d","");
    }

    public static int getLeadIndexById(List<Lead> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) !=null && list.get(i).getId()==id){
                return i;
            }
        }
        return -1;// not there is list
    }

}
