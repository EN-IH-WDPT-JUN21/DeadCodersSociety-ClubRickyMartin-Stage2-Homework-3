package DeadCodersSocietyClubRickyMartinStage2Homework3;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Lead;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Opportunity;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Industry;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Product;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Status;
import org.apache.commons.lang.WordUtils;

public class Validations {
    Menu Menu;

    public Validations() {
    }

    //trim and tidy user input
    public  String convertUserInputToCommand(String input){
        return input.toLowerCase().replaceAll("\\s+", "");
    }

    //check if given email has valid form
    public  boolean isValidEmailAddress(String email) {
            Pattern pattern = Pattern.compile("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$");
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
    }

    //check if given phone number matches phone number pattern
    public  boolean isValidPhoneNumber(String phoneNumber) {
        String patterns
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }


    public  boolean isValidFirstName(String firstName)
    {
        String fName= WordUtils.capitalizeFully(firstName.trim());
        return fName.matches( "[A-Z][a-zA-Z]*" );
    }

    public  boolean inputIsYesOrNo(String yesOrNo)
    {
        yesOrNo=convertUserInputToCommand(yesOrNo);
        if(yesOrNo.matches("yes") || yesOrNo.matches("y") || yesOrNo.matches("n")|| yesOrNo.matches("no")) {
            return true;
        }else{
            return false;
        }
    }

    public  boolean isValidLastName(String lastName)
    {
        String lName= WordUtils.capitalizeFully(lastName.trim());
        return lName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
    }

    //check if input matches available menu commands patterns
    public  boolean isValidMenuCommand(String command) {
        //patterns
        final Pattern newLead = Pattern.compile("newlead");
        final Pattern showLeads = Pattern.compile("showleads");
        final Pattern newSalesRep = Pattern.compile("newsalesrep");
        final Pattern showSalesReps = Pattern.compile("showsalesreps");
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
        final Pattern reports = Pattern.compile("reports");

        //by salesrep
        final Pattern reportLeadBySalesRep        = Pattern.compile("reportleadbysalesrep");
        final Pattern reportOpportunityBySalesRep = Pattern.compile("reportopportunitybysalesrep");
        final Pattern ReportCLOSEDWONbySalesRep   = Pattern.compile("reportclosed-wonbysalesrep");
        final Pattern ReportCLOSEDLOSTbySalesRep  = Pattern.compile("reportclosed-lostbysalesrep");
        final Pattern ReportOPENbySalesRep        = Pattern.compile("reportopenbysalesrep");

        //by product
        final Pattern ReportOpportunitybytheproduct = Pattern.compile("reportopportunitybytheproduct");
        final Pattern ReportCLOSEDWONbytheproduct   = Pattern.compile("reportclosed-wonbytheproduct");
        final Pattern ReportCLOSEDLOSTbytheproduct  = Pattern.compile("reportclosed-lostbytheproduct");
        final Pattern ReportOPENbytheproduct        = Pattern.compile("reportopenbytheproduct");

        //by country
        final Pattern ReportOpportunitybyCountry = Pattern.compile("reportopportunitybycountry");
        final Pattern ReportCLOSEDWONbyCountry   = Pattern.compile("reportclosed-wonbycountry");
        final Pattern ReportCLOSEDLOSTbyCountry  = Pattern.compile("reportclosed-lostbycountry");
        final Pattern ReportOPENbyCountry        = Pattern.compile("reportopenbycountry");

        //by city
        final Pattern ReportOpportunitybyCity = Pattern.compile("reportopportunitybycity");
        final Pattern ReportCLOSEDWONbyCity   = Pattern.compile("reportclosed-wonbycity");
        final Pattern ReportCLOSEDLOSTbyCity  = Pattern.compile("reportclosed-lostbycity");
        final Pattern ReportOPENbyCity        = Pattern.compile("reportopenbycity");

        //By Industry
        final Pattern ReportOpportunitybyIndustry = Pattern.compile("reportopportunitybyindustry");
        final Pattern ReportCLOSEDWONbyIndustry   = Pattern.compile("reportclosed-wonbyindustry");
        final Pattern ReportCLOSEDLOSTbyIndustry  = Pattern.compile("reportclosed-lostbyindustry");
        final Pattern ReportOPENbyIndustry        = Pattern.compile("reportopenbyindustry");

        //EmployeeCount	States
        final Pattern MeanEmployeeCount   = Pattern.compile("meanemployeecount");
        final Pattern MedianEmployeeCount = Pattern.compile("medianemployeecount");
        final Pattern MaxEmployeeCount    = Pattern.compile("maxemployeecount");
        final Pattern MinEmployeeCount    = Pattern.compile("minemployeecount");

        // Quantity States
        final Pattern MeanQuantity   = Pattern.compile("meanquantity");
        final Pattern MedianQuantity = Pattern.compile("medianquantity");
        final Pattern MaxQuantity    = Pattern.compile("maxquantity");
        final Pattern MinQuantity    = Pattern.compile("minquantity");

        // Opportunity	States
        final Pattern MeanOppsperAccount   = Pattern.compile("meanoppsperaccount");
        final Pattern MedianOppsperAccount = Pattern.compile("medianoppsperaccount");
        final Pattern MaxOppsperAccount    = Pattern.compile("maxoppsperaccount");
        final Pattern MinOppsperAccount    = Pattern.compile("minoppsperaccount");


        final Pattern bonus = Pattern.compile("\\*");

        //converts input into cleaned, lowercase command
        command= convertUserInputToCommand(command);

        //validate if input matches given patterns
        return  newLead.matcher(command).matches() ||
                newSalesRep.matcher(command).matches() ||
                showLeads.matcher(command).matches() ||
                showSalesReps.matcher(command).matches() ||
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
                reports.matcher(command).matches()||
                play.matcher(command).matches() ||

                reportLeadBySalesRep.matcher(command).matches() ||
                reportOpportunityBySalesRep.matcher(command).matches() ||
                ReportCLOSEDWONbySalesRep.matcher(command).matches() ||
                ReportCLOSEDLOSTbySalesRep.matcher(command).matches() ||
                ReportOPENbySalesRep.matcher(command).matches() ||

                ReportOpportunitybytheproduct.matcher(command).matches() ||
                ReportCLOSEDWONbytheproduct.matcher(command).matches() ||
                ReportCLOSEDLOSTbytheproduct.matcher(command).matches() ||
                ReportOPENbytheproduct.matcher(command).matches() ||

                ReportOpportunitybyCountry.matcher(command).matches() ||
                ReportCLOSEDWONbyCountry.matcher(command).matches() ||
                ReportCLOSEDLOSTbyCountry.matcher(command).matches() ||
                ReportOPENbyCountry.matcher(command).matches() ||

                ReportOpportunitybyCity.matcher(command).matches() ||
                ReportCLOSEDWONbyCity.matcher(command).matches() ||
                ReportCLOSEDLOSTbyCity.matcher(command).matches() ||
                ReportOPENbyCity.matcher(command).matches() ||

                ReportOpportunitybyIndustry.matcher(command).matches() ||
                ReportCLOSEDWONbyIndustry.matcher(command).matches() ||
                ReportCLOSEDLOSTbyIndustry.matcher(command).matches() ||
                ReportOPENbyIndustry.matcher(command).matches() ||

                MeanEmployeeCount.matcher(command).matches() ||
                MedianEmployeeCount.matcher(command).matches() ||
                MaxEmployeeCount.matcher(command).matches() ||
                MinEmployeeCount.matcher(command).matches() ||

                MeanQuantity.matcher(command).matches() ||
                MedianQuantity.matcher(command).matches() ||
                MaxQuantity.matcher(command).matches() ||
                MinQuantity.matcher(command).matches() ||

                MeanOppsperAccount.matcher(command).matches() ||
                MedianOppsperAccount.matcher(command).matches() ||
                MaxOppsperAccount.matcher(command).matches() ||
                MinOppsperAccount.matcher(command).matches()
        ;

    }

    //removes all characters and leaves only digits - used to extract id from input
    public  int removeAllCharacters(String command){
        String text= convertUserInputToCommand(command).replaceAll("\\D+","");
        if(!text.equals("")) {
            return Integer.parseInt(text.replaceAll("\\D+", ""));
        }else {
            return 0;
        }
    }


    //removes all digits and leaves only command - used to extract command from input
    public  String removeAllDigits(String command){
        String text= convertUserInputToCommand(command);
        return text.replaceAll("\\d","");
    }

    //finds DeadCodersSocietyClubRickyMartinStage2Homework3.dao.dao2.Lead index in given list
    public  int getLeadIndexById(List<Lead> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) !=null && list.get(i).getId()==id){
                return i;
            }
        }
        return -1;// if there is no given id in list
    }

    //finds DeadCodersSocietyClubRickyMartinStage2Homework3.dao.dao2.Opportunity index in given list
    public  int getOpportunityIndexById(List<Opportunity> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) !=null && list.get(i).getId()==id){
                return i;
            }
        }
        return -1;// if there is no given id in list
    }

    //finds DeadCodersSocietyClubRickyMartinStage2Homework3.dao.dao2.Account index in given list
    public  int getAccountIndexById(List<Account> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) !=null && list.get(i).getId()==id){
                return i;
            }
        }
        return -1;// if there is no given id in list
    }

    //fetch valid enum
    public Product getProduct(String product){
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
    public Industry getIndustry(String industry){
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
    public  Status getStatus(String status){
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
    public  boolean isValidInt(String input) {
        boolean result = true;
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException ex) {
            result = false;
        }
        return result;
    }

    //check if input is int>0
    public  int getPositiveInt(String input) {
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
