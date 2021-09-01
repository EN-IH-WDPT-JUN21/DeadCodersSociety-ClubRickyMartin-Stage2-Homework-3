package DeadCodersSocietyClubRickyMartinStage2Homework3;

import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Contact;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Lead;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Opportunity;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.*;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Menu {

    @Autowired
    static AccountRepository accountRepository;
    @Autowired
    static ContactRepository contactRepository;
    @Autowired
    static LeadRepository leadRepository;
    @Autowired
    static OpportunityRepository opportunityRepository;
    @Autowired
    static SalesRepRepository salesRepRepository;


    public static  List<Lead> leadList=new ArrayList<>();
    public static  List<Opportunity> opportunityList=new ArrayList<>();
    public static  List<Account> accountList=new ArrayList<>();
    public static  Scanner console = new Scanner(System.in);
    private static String menuChoice;
    private static int numericInput;

    //print the welcome screen
    public static void welcomeScreen(){
        Graphics.mainMenuGraphic();
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the CRM - Customer Relations Management *");

    }
    //main element of menu
    public static void mainMenu(){
        boolean runProgram=true;
        console = new Scanner(System.in);

        //run the loop until user will choose to exit
        while(runProgram) {

            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("What do you want to do?");
            //trims and concatenates user input to make it easier to verify with pattern
            menuChoice = convertUserInputToCommand(console.nextLine());

            //check if the input is one of the valid options
            boolean validMainMenuOption = Validations.isValidMenuCommand(menuChoice);

            //loop while input is an invalid option
            while (!validMainMenuOption) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("This is not a valid option! Type help for the list of available commands.");
                menuChoice = convertUserInputToCommand(console.nextLine());
                validMainMenuOption = Validations.isValidMenuCommand(menuChoice);
            }

            //removes all digits to convert input into menu command
            String command = Validations.removeAllDigits(menuChoice);

            //removes all characters to extract id from input
            numericInput = Validations.removeAllCharacters(menuChoice);
            switch (command) {

                case "help" -> help();

                case "newlead" -> createNewLead();

                case "showleads" -> showLeads();

                case "lookuplead" -> lookupLead(numericInput);

                case "lookupopportunity" -> lookupOpportunity(numericInput);

                case "lookupaccount" -> lookupAccount(numericInput);

                case "convert" -> {
                    int opportunityIndex=convertLead(numericInput);
                    if (opportunityIndex >= 0) {
                        createAccount(opportunityList.get(opportunityIndex));
                    }
                }

                case "close-lost" -> closeOpportunity(numericInput, Status.CLOSED_LOST);

                case "closelost" -> closeOpportunity(numericInput, Status.CLOSED_LOST);

                case "close-won" -> closeOpportunity(numericInput, Status.CLOSED_WON);

                case "closewon" -> closeOpportunity(numericInput, Status.CLOSED_WON);

                case "definition" -> Menu.CRMDefinition();

                case "play" -> Sounds.playSound();

                case "exit" -> runProgram = false;

                //hidden menu option for users who will spot asterisks in welcome screen
                case "*" -> Menu.CRMTrueDefinition();

                // case "Report DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Lead by DeadCodersSocietyClubRickyMartinStage2Homework3.dao.SalesRep" -> Report()


                //just a security valve - probably redundant
                default -> System.out.println("This option is not yet implemented");
            }
        }

        //exit program
    }

    public static void reportBySalesRep() {

    }

    public static void createNewLead() {
        String name;
        String phoneNumber;
        String email;
        String companyName;
        console = new Scanner(System.in);

        System.out.println("Please enter first name for this lead:");
        // Get input from the user
        String userInput = console.nextLine();
        //valideate if the first name is valid
        while(!Validations.isValidFirstName(userInput)){
            System.out.println("This first name is invalid. Please enter valid first name for this lead:");
            userInput = console.nextLine();
        }
        //use validated, trimmed first name and last name
        name = "".concat(userInput.trim());

        //validate if last name is valid
        System.out.println("Please enter last name for this lead:");
        userInput = console.nextLine();
        while(!Validations.isValidLastName(userInput)){
            System.out.println("This last name is invalid. Please enter valid last name for this lead:");
            userInput = console.nextLine();
        }
        //use trimmed, capitalized name
        name=WordUtils.capitalizeFully(name.concat(" ").concat(userInput.trim())).trim();

        //validate if phone number is valid
        System.out.println("Please enter phone number for this lead:");
        userInput = console.nextLine();
        while(!Validations.isValidPhoneNumber(userInput)){
            System.out.println("This phone number is invalid. Please enter valid phone number for this lead:");
            userInput = console.nextLine();
        }
        //use validated user input
        phoneNumber=userInput;

        //validate if Email address is valid
        System.out.println("Please enter email address for this lead:");
        userInput = console.nextLine();
        while(!Validations.isValidEmailAddress(userInput)){
            System.out.println("This email address is invalid. Please enter valid email address for this lead:");
            userInput = console.nextLine();
        }
        //use validated user input
        email=userInput.trim();

        //validate if company name is empty -> there are no limits how the company can be named
        System.out.println("Please enter company name for this lead:");
        userInput = console.nextLine();
        while(userInput == null || userInput.isEmpty()){
            System.out.println("Company name cannot be empty. Please enter valid company name for this lead:");
            userInput = console.nextLine();
        }
        companyName=userInput.trim();

        //create new lead
        //Lead newLead= new Lead(name, phoneNumber, email, companyName);
        //add lead to list
        //leadList.add(newLead);
        Lead newLead = leadRepository.save(new Lead(name, phoneNumber, email, companyName));
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("New lead created: ");
        //System.out.println(newLead.showLeadDetails());
    }

    //trim and tidy user input
    public static String convertUserInputToCommand(String input){
        return input.toLowerCase().replaceAll("\\s+", "");
    }

    //helper menu to display available commands
    public static void help(){
        System.out.println(
                """
                        Available commands are:
                        New dao2.Lead - allows creation of a new dao2.Lead,
                        Show Leads - displays a list of all available Leads,
                        Lookup dao2.Lead id - display dao2.Lead with given id,
                        Convert id - converts dao2.Lead with given id to an dao2.Opportunity,
                        Lookup dao2.Opportunity id - display dao2.Opportunity with given id,
                        Close-lost id - closes dao2.Opportunity with given id with status LOST,
                        Close-won id - closes dao2.Opportunity with given id with status WON,
                        Help - displays list of available commands,
                        Definition - displays definition of CRM,
                        Play - play some motivating music,
                        EXIT - terminates the program.
                        """
        );

    }

    //show list of leads stored in leadList
    public static void showLeads(){
        if (leadList.size() == 0){
            System.out.println("No leads found!");
        } else {
            for (Lead lead : leadList) {
                System.out.println("Id: ".concat(String.valueOf(lead.getId())).concat(" Name: ").concat(lead.getName()));
            }
        }
    }

    //verify if lead with given id is stored in the list
    public static void lookupLead(int num){
        int index=Validations.getLeadIndexById(leadList, num);
        if(index==-1){
            System.out.println("dao2.Lead with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            System.out.println("dao2.Lead found!");
            System.out.println(leadList.get(index).showLeadDetails());
        }
    }

    //convert lead with given id into a new opportunity
    public static int convertLead(int num){
        console = new Scanner(System.in);

        int index=Validations.getLeadIndexById(leadList, num);
        //validate if given lead exists
        if(index==-1){
            System.out.println("dao2.Lead with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
            return -1;
        } else {
            Lead lead=leadList.get(index);
            Contact decisionMaker=new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
            System.out.println("dao2.Lead found!");
            System.out.println("New contact created with following data:");
            System.out.println(decisionMaker.showContactDetails());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please choose the product for this opportunity. Available options are: ");
            System.out.println(java.util.Arrays.asList(Product.values()));

            menuChoice= convertUserInputToCommand(console.nextLine());
            //loop while input is an invalid enum DeadCodersSocietyClubRickyMartinStage2Homework3.Product
            while (Validations.getProduct(menuChoice)==null) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("This is not a valid option! available options are:");
                System.out.println(java.util.Arrays.asList(Product.values()));
                menuChoice= convertUserInputToCommand(console.nextLine());
            }
            //fetch valid enum
            Product product=Validations.getProduct(menuChoice);

            //get quantity for given product
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please choose the number of trucks for this opportunity.");
            numericInput=Validations.getPositiveInt(console.nextLine());
            while (numericInput<=0) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("This is not a valid quantity!");
                numericInput=Validations.getPositiveInt(console.nextLine());
            }
            int quantity=numericInput;

            //create new opportunity, add it to the list and print its details
            Opportunity newOpportunity=new Opportunity(product, quantity, decisionMaker);
            opportunityList.add(newOpportunity);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("New opportunity created as following: ");
            System.out.println(newOpportunity.showOpportunityDetails());

            //remove converted lead from the list
            leadList.remove(lead);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("dao2.Lead id: ".concat(String.valueOf(lead.getId())).concat(" was removed."));

            //go to DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Opportunity creator
            return Validations.getOpportunityIndexById(opportunityList,newOpportunity.getId());
        }

    }

    //create new account
    public static void createAccount(Opportunity opportunity){

        console = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please choose the industry for this dao2.Account. Available options are: ");
        System.out.println(Arrays.asList(Industry.values()));

        //ask for enum and validate input
        menuChoice= convertUserInputToCommand(console.nextLine());
        //loop while input is an invalid option
        while (Validations.getIndustry(menuChoice)==null) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("This is not a valid option! available options are:");
            System.out.println(java.util.Arrays.asList(Industry.values()));
            menuChoice= convertUserInputToCommand(console.nextLine());
        }
        //fetch valid enum
        Industry industry=Validations.getIndustry(menuChoice);

        //ask for number of employees and validate if number is>0
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please choose the number of employees in this company.");
        numericInput=Validations.getPositiveInt(console.nextLine());
        while (numericInput<=0) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("This is not a valid quantity!");
            numericInput=Validations.getPositiveInt(console.nextLine());
        }
        int employeeCount=numericInput;

        //ask for ISO country code and allow to print the list
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please provide the country code for this company. Type LIST for the country list");
        menuChoice= convertUserInputToCommand(console.nextLine()).toUpperCase();
        boolean isValidCode=ListCountry.isValidISOCountry(menuChoice);

        //loop until input matches one of correct ISO codes
        while (!isValidCode) {
            if(menuChoice.equalsIgnoreCase("list")) {
                ListCountry.run();
                menuChoice= convertUserInputToCommand(console.nextLine()).toUpperCase();
                isValidCode=ListCountry.isValidISOCountry(menuChoice);
            }else {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("This is not a valid country code! Type LIST for the country list.");
                menuChoice = convertUserInputToCommand(console.nextLine()).toUpperCase();
                isValidCode = ListCountry.isValidISOCountry(menuChoice);
            }
        }
        //fetch country name based on ISO code
        String country=ListCountry.getCountry(menuChoice);

        //ask for city name, trim and capitalize it
        System.out.println("Please enter city name:");
        menuChoice= convertUserInputToCommand(console.nextLine());
        String city=Validations.removeAllDigits(menuChoice);
        city=WordUtils.capitalizeFully(city.trim());

        //create new account with given data
        Account newAccount=new Account(industry, employeeCount, city, country, opportunity.getDecisionMaker(), opportunity);
        accountList.add(newAccount);

        System.out.println("New dao2.Account created with following details: ");
        System.out.println(newAccount.showAccountDetails());
    }

    //verify if given DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account exists in the list and print details
    public static void lookupOpportunity(int num){
        int index=Validations.getOpportunityIndexById(opportunityList, num);
        if(index==-1){
            System.out.println("dao2.Opportunity with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            System.out.println("dao2.Opportunity found!");
            System.out.println(opportunityList.get(index).showOpportunityDetails());
        }
    }
    //verify if given opportunity exists in the list and print details
    public static void closeOpportunity(int num, Status status) {
        if (!status.toString().equals("CLOSED_LOST") && !status.toString().equals("CLOSED_WON")) {
            System.out.println("This is not a valid status! Type CLOSED_LOST or CLOSED_WON.");
        } else {
            int index = Validations.getOpportunityIndexById(opportunityList, num);
            if (index == -1) {
                System.out.println("dao2.Opportunity with ID="
                        .concat(String.valueOf(num))
                        .concat(" was not found!"));
            } else {
                opportunityList.get(index).setStatus(status);
                System.out.println("dao2.Opportunity found and updated!");
                System.out.println(opportunityList.get(index).showOpportunityDetails());
                if (status==Status.CLOSED_WON){
                    System.out.println("You've won this opportunity! Congratulations! \nLet's celebrate it with some music!");
                    Sounds.playSound();
                }
            }
        }
    }

    //verify if given DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account exists in the list and print details
    public static void lookupAccount(int num){
        int index=Validations.getAccountIndexById(accountList, num);
        if(index==-1){
            System.out.println("dao2.Account with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            System.out.println("dao2.Account found!");
            System.out.println(accountList.get(index).showAccountDetails());
        }
    }

    public static List<Lead> getLeadList(){
        return leadList;
    }
    public static List<Opportunity> getOpportunityList(){
        return opportunityList;
    }

    public static List<Account> getAccountList(){
        return Menu.accountList;
    }

    //print CRM definition from Wikipedia
    public static void CRMDefinition(){
        System.out.println("According to Wikipedia:");
        System.out.println("Customer relationship management (CRM) is a process in which a business or other organization \n administers its interactions with customers, typically using data analysis to study large amounts of information.");
        System.out.println();
        System.out.println("CRM systems compile data from a range of different communication channels, including a company's website, \n telephone, email, live chat, marketing materials and more recently, social media. \n They allow businesses to learn more about their target audiences and how to best cater for their needs, thus retaining customers and driving sales growth. \n CRM may be used with past, present or potential customers. \n The concepts, procedures, and rules that a corporation follows when communicating with its consumers are referred to as customer relationship management (CRM). \n This complete connection covers direct contact with customers, such as sales and service-related operations, \n forecasting, and the analysis of consumer patterns and behaviors, from the perspective of the company.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    //print lesser known definition of CRM ;)
    public static void CRMTrueDefinition(){
        Sounds.playSound();
        Graphics.trueCRMGraphic();
        System.out.println("Lesser known fact is that CRM stands for Club Ricky Martin.");
        System.out.println("Within this definition CRM Users are a group of devoted people who strongly believes that 90's are not yet lost!");
        System.out.println();
        System.out.println("The undeniable guru of the CRM Users is Ricky Martin! Let him guide you through this hard day of work!");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

}


