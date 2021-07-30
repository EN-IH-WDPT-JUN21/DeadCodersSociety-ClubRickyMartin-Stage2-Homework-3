import org.apache.commons.lang.WordUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    public static List<Lead> leadList = new ArrayList<>();
    public static List<Opportunity> opportunityList = new ArrayList<>();
    public static List<Account> accountList = new ArrayList<>();
    private static Reader console = Reader.getInstance();
    private static String menuChoice = "";
    private static String command = "";
    private static int numericInput;
    private static boolean audioOn = true;

    public static void welcomeScreen() {
        Graphics.mainMenuGraphic();
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the CRM - Customer Relations Management *");
        Menu.mainMenu();
    }

    public static void mainMenu() {
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("What do you want to do?");
        menuChoice = convertUserInputToCommand(console.nextLine());
        //check if the input is one of the valid options
        boolean validMainMenuOption = Validations.isValidMenuCommand(menuChoice);
        //loop while input is an invalid option
        while (!validMainMenuOption) {
            System.out.println("This is not a valid option! Type help for the list of available commands.");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            menuChoice = convertUserInputToCommand(console.nextLine());
            validMainMenuOption = Validations.isValidMenuCommand(menuChoice);
        }
        command = Validations.removeAllDigits(menuChoice);
        numericInput = Validations.removeAllCharacters(menuChoice);
        switch (command) {
            //create new lead
            case "help" -> help();

            case "newlead" -> createNewLead();

            case "showleads" -> showLeads();

            case "lookuplead" -> lookupLead(numericInput);

            case "lookupopportunity" -> lookupOpportunity(numericInput);

            case "lookupaccount" -> lookupOpportunity(numericInput);

            case "convert" -> convertLead(numericInput);

            case "close-lost" -> closeOpportunity(numericInput, Status.CLOSED_LOST);

            case "closelost" -> closeOpportunity(numericInput, Status.CLOSED_LOST);

            case "close-won" -> closeOpportunity(numericInput, Status.CLOSED_WON);

            case "closewon" -> closeOpportunity(numericInput, Status.CLOSED_WON);

            case "definition" -> Menu.CRMDefinition();

            case "play" -> Sounds.playSound();

            case "exit" -> System.exit(0);

            case "*" -> Menu.CRMTrueDefinition();

            //just a security valve - probably redundant
            default -> {
                System.out.println("This option is not yet implemented");
                Menu.mainMenu();
            }
        }
        Menu.mainMenu();
    }

    public static void createNewLead() {
        String name;
        String phoneNumber;
        String email;
        String companyName;

        Reader console = Reader.getInstance();
        // Get input from the user
        System.out.println("Please enter first name for this lead:");
        String userInput = console.nextLine();
        //valideate if the first name is valid
        while (!Validations.isValidFirstName(userInput)) {
            System.out.println("This first name is invalid. Please enter valid first name for this lead:");
            userInput = console.nextLine();
        }
        name = "".concat(userInput.trim());
        //validate if last name is valid
        System.out.println("Please enter last name for this lead:");
        userInput = console.nextLine();
        while (!Validations.isValidLastName(userInput)) {
            System.out.println("This last name is invalid. Please enter valid last name for this lead:");
            userInput = console.nextLine();
        }
        //use trimmed, capitalized name
        name = WordUtils.capitalizeFully(name.concat(" ").concat(userInput.trim())).trim();

        //validate if phone number is valid
        System.out.println("Please enter phone number for this lead:");
        userInput = console.nextLine();
        while (!Validations.isValidPhoneNumber(userInput)) {
            System.out.println("This phone number is invalid. Please enter valid phone number for this lead:");
            userInput = console.nextLine();
        }
        //use validated user input
        phoneNumber = userInput;

        //validate if Email address is valid
        System.out.println("Please enter email address for this lead:");
        userInput = console.nextLine();
        while (!Validations.isValidEmailAddress(userInput)) {
            System.out.println("This email address is invalid. Please enter valid email address for this lead:");
            userInput = console.nextLine();
        }
        //use validated user input
        email = userInput.trim();

        System.out.println("Please enter company name for this lead:");
        userInput = console.nextLine();
        while (userInput == null || userInput.isEmpty()) {
            System.out.println("Company name cannot be empty. Please enter valid company name for this lead:");
            userInput = console.nextLine();
        }
        companyName = userInput.trim();

        Lead newLead = new Lead(name, phoneNumber, email, companyName);
        leadList.add(newLead);
        System.out.println("New lead created: ");
        System.out.println(newLead.showLeadDetails());
    }

    public static String convertUserInputToCommand(String input) {
        return input.toLowerCase().replaceAll("\\s+", "");
    }

    public static void help() {
        System.out.println("""
                Available commands are:\s
                New Lead - allows creation of a new Lead,
                Show Leads - displays a list of all available Leads,\s
                Lookup Lead id - display Lead with given id,
                Convert id - converts Lead with given id to an Opportunity,\s
                Lookup Opportunity id - display Opportunity with given id,
                Close-lost id - closes Opportunity with given id with status LOST,\s
                Close-won id - closes Opportunity with given id with status WON,\s
                Help - displays list of available commands,\s
                Definition - displays definition of CRM,\s
                Play - play some music,\s
                EXIT - terminates the program.\s
                """
        );
    }

    public static void showLeads() {
        if (leadList == null || leadList.size() == 0) {
            System.out.println("No leads found!");
        } else {
            for (Lead lead : leadList) {
                System.out.println("Id: ".concat(String.valueOf(lead.getId())).concat(" Name: ").concat(lead.getName()));
            }
        }
    }

    public static void lookupLead(int num) {
        int index = Validations.getLeadIndexById(leadList, num);
        if (index == -1) {
            System.out.println("Lead with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            System.out.println("Lead found!");
            System.out.println(leadList.get(index).showLeadDetails());
        }
    }

    public static void convertLead(int num) {
        int index = Validations.getLeadIndexById(leadList, num);

        if (index == -1) {
            System.out.println("Lead with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            Lead lead = leadList.get(index);
            Contact decisionMaker = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
            System.out.println("Lead found!");
            System.out.println("New contact created with following data:");
            System.out.println(decisionMaker.showContactDetails());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please choose the product for this opportunity. Available options are: ");
            System.out.println(java.util.Arrays.asList(Product.values()));

            menuChoice = convertUserInputToCommand(console.nextLine());
            //loop while input is an invalid option
            while (Validations.getProduct(menuChoice) == null) {
                System.out.println("This is not a valid option! available options are:");
                System.out.println(java.util.Arrays.asList(Product.values()));
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                menuChoice = convertUserInputToCommand(console.nextLine());
            }
            Product product = Validations.getProduct(menuChoice);

            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please choose the number of trucks for this opportunity.");

            numericInput = Validations.getPositiveInt(console.nextLine());
            while (numericInput <= 0) {
                System.out.println("This is not a valid quantity!");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                numericInput = Validations.getPositiveInt(console.nextLine());
            }

            int quantity = numericInput;
            Opportunity newOpportunity = new Opportunity(product, quantity, decisionMaker);
            opportunityList.add(newOpportunity);

            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("New opportunity created as following: ");
            System.out.println(newOpportunity.showOpportunityDetails());

            leadList.remove(lead);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Lead id: ".concat(String.valueOf(lead.getId())).concat(" was removed."));
            Menu.createAccount(newOpportunity);
        }
    }

    public static void createAccount(Opportunity opportunity) {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please choose the industry for this Account. Available options are: ");
        System.out.println(Arrays.asList(Industry.values()));

        menuChoice = convertUserInputToCommand(console.nextLine());
        //loop while input is an invalid option
        while (Validations.getIndustry(menuChoice) == null) {
            System.out.println("This is not a valid option! available options are:");
            System.out.println(java.util.Arrays.asList(Industry.values()));
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            menuChoice = convertUserInputToCommand(console.nextLine());
        }
        Industry industry = Validations.getIndustry(menuChoice);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please choose the number of employees in this company.");

        numericInput = Validations.getPositiveInt(console.nextLine());
        while (numericInput <= 0) {
            System.out.println("This is not a valid quantity!");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            numericInput = Validations.getPositiveInt(console.nextLine());
        }
        int employeeCount = numericInput;

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please provide the country code for this company. Type LIST for the country list");

        menuChoice = convertUserInputToCommand(console.nextLine()).toUpperCase();
        boolean isValidCode = ListCountry.isValidISOCountry(menuChoice);

        while (!isValidCode) {
            if (menuChoice.equalsIgnoreCase("list")) {
                ListCountry.run();
                menuChoice = convertUserInputToCommand(console.nextLine()).toUpperCase();
                isValidCode = ListCountry.isValidISOCountry(menuChoice);
            } else {
                System.out.println("This is not a valid country code! Type LIST for the country list.");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                menuChoice = convertUserInputToCommand(console.nextLine()).toUpperCase();
                isValidCode = ListCountry.isValidISOCountry(menuChoice);
            }
        }
        String country = ListCountry.getCountry(menuChoice);

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please enter city name:");
        menuChoice = convertUserInputToCommand(console.nextLine());
        String city = Validations.removeAllDigits(menuChoice);
        city = WordUtils.capitalizeFully(city.trim());

        Account newAccount = new Account(industry, employeeCount, city, country, opportunity.getDecisionMaker(), opportunity);
        accountList.add(newAccount);

        System.out.println("New Account created with following details: ");
        System.out.println(newAccount.showAccountDetails());
    }

    public static void CRMDefinition() {
        System.out.println("According to Wikipedia:");
        System.out.println("Customer relationship management (CRM) is a process in which a business or other organization \n administers its interactions with customers, typically using data analysis to study large amounts of information.");
        System.out.println();
        System.out.println("CRM systems compile data from a range of different communication channels, including a company's website, \n telephone, email, live chat, marketing materials and more recently, social media. \n They allow businesses to learn more about their target audiences and how to best cater for their needs, thus retaining customers and driving sales growth. \n CRM may be used with past, present or potential customers. \n The concepts, procedures, and rules that a corporation follows when communicating with its consumers are referred to as customer relationship management (CRM). \n This complete connection covers direct contact with customers, such as sales and service-related operations, \n forecasting, and the analysis of consumer patterns and behaviors, from the perspective of the company.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void CRMTrueDefinition() {
        Graphics.trueCRMGraphic();
        Sounds.playSound();
        System.out.println("Lesser known fact is that CRM stands for Club Ricky Martin.");
        System.out.println("Within this definition CRM Users are a group of devoted people who strongly believes that 90's are not yet lost!");
        System.out.println();
        System.out.println("The undeniable guru of the CRM Users is Ricky Martin! Let him guide you through this hard day of work!");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public static void lookupOpportunity(int num) {
        int index = Validations.getOpportunityIndexById(opportunityList, num);
        if (index == -1) {
            System.out.println("Opportunity with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            System.out.println("Opportunity found!");
            System.out.println(opportunityList.get(index).showOpportunityDetails());
        }
    }

    public static void closeOpportunity(int num, Status status) {
        if (!status.toString().equals("CLOSED_LOST") && !status.toString().equals("CLOSED_WON")) {
            System.out.println("This is not a valid status! Type CLOSED_LOST or CLOSED_WON.");
        } else {
            int index = Validations.getOpportunityIndexById(opportunityList, num);
            if (index == -1) {
                System.out.println("Opportunity with ID="
                        .concat(String.valueOf(num))
                        .concat(" was not found!"));
            } else {
                opportunityList.get(index).setStatus(status);
                System.out.println("Opportunity found and updated!");
                System.out.println(opportunityList.get(index).showOpportunityDetails());
            }
        }
    }
}


