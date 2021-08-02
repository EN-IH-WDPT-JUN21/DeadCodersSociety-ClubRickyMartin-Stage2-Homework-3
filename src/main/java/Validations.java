import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.WordUtils;

public class Validations {

    //check if given email has valid form
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

    //check if given phone number matches phone number pattern
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

    //check if input matches available menu commands patterns
    public static boolean isValidMenuCommand(String command) {
        //patterns
        final Pattern newLead = Pattern.compile("newlead");
        final Pattern showLeads = Pattern.compile("showleads");
        final Pattern showOpportunities = Pattern.compile("showopportunities");
        final Pattern showAccounts = Pattern.compile("showaccounts");
        final Pattern lookUpLeads = Pattern.compile("lookuplead\\d+");
        final Pattern lookUpOpportunity = Pattern.compile("lookupopportunity\\d+");
        final Pattern lookUpAccount = Pattern.compile("lookupaccount\\d+");
        final Pattern convertLead = Pattern.compile("convert\\d+");
        final Pattern closeLost = Pattern.compile("closelost\\d+");
        final Pattern closeWon = Pattern.compile("closewon\\d+");
        final Pattern close_Lost = Pattern.compile("close-lost\\d+");
        final Pattern close_Won = Pattern.compile("close-won\\d+");
        final Pattern help = Pattern.compile("help");
        final Pattern exit = Pattern.compile("exit");
        final Pattern play = Pattern.compile("play");
        final Pattern definition = Pattern.compile("definition");
        final Pattern bonus = Pattern.compile("\\*");

        //converts input into cleaned, lowercase command
        command=Menu.convertUserInputToCommand(command);

        //validate if input matches given patterns
        return newLead.matcher(command).matches() ||
                showLeads.matcher(command).matches() ||
                showOpportunities.matcher(command).matches() ||
                showAccounts.matcher(command).matches() ||
                lookUpLeads.matcher(command).matches() ||
                convertLead.matcher(command).matches() ||
                closeLost.matcher(command).matches() ||
                closeWon.matcher(command).matches() ||
                close_Lost.matcher(command).matches() ||
                close_Won.matcher(command).matches() ||
                exit.matcher(command).matches() ||
                help.matcher(command).matches() ||
                lookUpOpportunity.matcher(command).matches() ||
                lookUpAccount.matcher(command).matches() ||
                bonus.matcher(command).matches()||
                definition.matcher(command).matches()||
                play.matcher(command).matches()
                ;
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

    //finds Lead index in given list
    public static int getLeadIndexById(List<Lead> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) !=null && list.get(i).getId()==id){
                return i;
            }
        }
        return -1;// if there is no given id in list
    }

    //finds Opportunity index in given list
    public static int getOpportunityIndexById(List<Opportunity> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) !=null && list.get(i).getId()==id){
                return i;
            }
        }
        return -1;// if there is no given id in list
    }

    //finds Account index in given list
    public static int getAccountIndexById(List<Account> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) !=null && list.get(i).getId()==id){
                return i;
            }
        }
        return -1;// if there is no given id in list
    }

    //fetch valid enum
    static Product getProduct(String product){
        Product prod=null;
        for (Product s : Product.values())
        {
            if (product.equalsIgnoreCase(s.toString()))
            {
                prod=s;
            }
        }
        return prod;
    }

    //fetch valid enum
    static Industry getIndustry(String industry){
        Industry ind=null;
        for (Industry s : Industry.values())
        {
            if (industry.equalsIgnoreCase(s.toString()))
            {
                ind=s;
            }
        }
        return ind;
    }

    //fetch valid enum
    static Status getStatus(String status){
        Status ind=null;
        for (Status s : Status.values())
        {
            if (status.equalsIgnoreCase(s.toString()))
            {
                ind=s;
            }
        }
        return ind;
    }

    //check if input is a valid int
    public static boolean isValidInt(String input) {
        boolean result = true;
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException ex) {
            result = false;
        }
        return result;
    }

    //check if input is int>0
    public static int getPositiveInt(String input) {
        int result;
        try {
            result=Integer.parseInt(input);
            if(result<=0){
                result=0;
            }
        } catch (IllegalArgumentException ex) {
            result = 0;
        }
        return result;
    }

}
