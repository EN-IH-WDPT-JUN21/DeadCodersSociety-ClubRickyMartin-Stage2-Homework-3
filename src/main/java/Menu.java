import org.apache.commons.lang.WordUtils;

import java.util.*;

public class Menu {
    public static List<Lead> leadList=new ArrayList<>();

    private static Reader console = Reader.getInstance();
    private static String menuChoice="";
    private static String command="";
    private static int id;

    public static void welcomeScreen(){
        Graphics.mainMenuGraphic();
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the CRM - Customer Relations Management *");
        Menu.mainMenu();
    }

    public static void mainMenu(){
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("What do you want to do?");
        menuChoice= convertUserInputToCommand(console.nextLine());
        //check if the input is one of the valid options
        boolean validMainMenuOption = Validations.isValidMenuCommand(menuChoice);
        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Type help for the list of available commands.");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            menuChoice= convertUserInputToCommand(console.nextLine());
            validMainMenuOption = Validations.isValidMenuCommand(menuChoice);
        }
        command=Validations.removeAllDigits(menuChoice);
        id=Validations.removeAllCharacters(menuChoice);
        switch (command) {
            //create new lead
            case "help" -> help();

            // create new lead
            case "newlead" -> createNewLead();

            // look up lead with given id
            case "showleads" -> {
                showLeads();
            }

            // look up lead with given id
            case "lookuplead" -> {
                lookupLead(id);
            }

            //just a security valve - probably redundant
            default -> {
                System.out.println("This option is not yet implemented");
                Menu.mainMenu();
            }
        }
        Menu.mainMenu();
    }

    public static void createNewLead(){
        String name;
        String phoneNumber;
        String email;
        String companyName;

        Reader myScanner = Reader.getInstance();
        // Get input from the user
        System.out.println("Please enter first name for this lead:");
        String userInput = myScanner.nextLine();
        //valideate if the first name is valid
        while(!Validations.isValidFirstName(userInput)){
            System.out.println("This first name is invalid. Please enter valid first name for this lead:");
            userInput = myScanner.nextLine();
        }
        name = "".concat(userInput.trim());
        //validate if last name is valid
        System.out.println("Please enter last name for this lead:");
        userInput = myScanner.nextLine();
        while(!Validations.isValidLastName(userInput)){
            System.out.println("This last name is invalid. Please enter valid last name for this lead:");
            userInput = myScanner.nextLine();
        }
        //use trimmed, capitalized name
        name=WordUtils.capitalizeFully(name.concat(" ").concat(userInput.trim())).trim();

        //validate if phone number is valid
        System.out.println("Please enter phone number for this lead:");
        userInput = myScanner.nextLine();
        while(!Validations.isValidPhoneNumber(userInput)){
            System.out.println("This phone number is invalid. Please enter valid phone number for this lead:");
            userInput = myScanner.nextLine();
        }
        //use validated user input
        phoneNumber=userInput;

        //validate if Email address is valid
        System.out.println("Please enter email address for this lead:");
        userInput = myScanner.nextLine();
        while(!Validations.isValidEmailAddress(userInput)){
            System.out.println("This email address is invalid. Please enter valid email address for this lead:");
            userInput = myScanner.nextLine();
        }
        //use validated user input
        email=userInput.trim();

        System.out.println("Please enter company name for this lead:");
        userInput = myScanner.nextLine();
        while(userInput == null || userInput.isEmpty()){
            System.out.println("Company name cannot be empty. Please enter valid company name for this lead:");
            userInput = myScanner.nextLine();
        }
        companyName=userInput.trim();

        Lead newLead= new Lead(name, phoneNumber, email, companyName);
        leadList.add(newLead);
        System.out.println("New lead created: ");
        System.out.println(newLead.showLeadDetails());
        Menu.mainMenu();
    }

    public static String convertUserInputToCommand(String input){
        return input.toLowerCase().replaceAll("\\s+", "");
    }

    public static void help(){
        System.out.println("Available commands are: \n" +
                "New Lead - allows creation of a new Lead,\n" +
                "Show Leads - displays a list of all available Leads, \n" +
                "Lookup Lead id - display Lead with given id,\n" +
                "Convert id - converts Lead with given id to an Opportunity, \n" +
                "Close-lost id - closes Opportunity with given id with status LOST, \n" +
                "Convert id - closes Opportunity with given id with status WON, \n" +
                "Help - displays list of available commands ");
        Menu.mainMenu();
    }

    public static void showLeads(){
        if (leadList==null || leadList.size()==0){
            System.out.println("No leads found!");
        } else {
            for (Lead lead : leadList) {
                System.out.println("Id: ".concat(String.valueOf(lead.getId())).concat(" Name: ").concat(lead.getName()));
            }
        }
    }


    public static void lookupLead(int num){
        int index=Validations.getLeadIndexById(leadList, num);
        if(index==-1){
            System.out.println("Lead with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            System.out.println("Lead found!");
            System.out.println(leadList.get(index).showLeadDetails());
        }
    }

    public static void convertLead(int num){

    }

    public static void CRMDefinition(){
        System.out.println("According to Wikipedia:");
        System.out.println("Customer relationship management (CRM) is a process in which a business or other organization \n administers its interactions with customers, typically using data analysis to study large amounts of information.");
        System.out.println();
        System.out.println("CRM systems compile data from a range of different communication channels, including a company's website, \n telephone, email, live chat, marketing materials and more recently, social media. \n They allow businesses to learn more about their target audiences and how to best cater for their needs, thus retaining customers and driving sales growth. \n CRM may be used with past, present or potential customers. \n The concepts, procedures, and rules that a corporation follows when communicating with its consumers are referred to as customer relationship management (CRM). \n This complete connection covers direct contact with customers, such as sales and service-related operations, \n forecasting, and the analysis of consumer patterns and behaviors, from the perspective of the company.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }
    public static void CRMTrueDefinition(){
        System.out.println("Lesser known fact is that CRM stands for Club Ricky Martin.");
        System.out.println("Within this definition CRM Users are a group of devoted people who strongly believes that 90's are not yet lost!");
        System.out.println();
        System.out.println("The undeniable guru of the CRM Users is Ricky Martin!. Let him guide you through this hard day of work!");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

}
