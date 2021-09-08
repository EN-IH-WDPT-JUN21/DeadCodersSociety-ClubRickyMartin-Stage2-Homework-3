package DeadCodersSocietyClubRickyMartinStage2Homework3;

import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.*;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Industry;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Product;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Status;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.*;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.*;

@Component
public class Menu {

    final LeadRepository leadRepository;
    final SalesRepRepository salesRepRepository;
    final AccountRepository accountRepository;
    final ContactRepository contactRepository;
    final OpportunityRepository opportunityRepository;

    @Autowired
    public Menu(LeadRepository leadRepository, SalesRepRepository salesRepRepository, AccountRepository accountRepository, ContactRepository contactRepository, OpportunityRepository opportunityRepository) {
        this.leadRepository = leadRepository;
        this.salesRepRepository = salesRepRepository;
        this.accountRepository =accountRepository;
        this.contactRepository = contactRepository;
        this.opportunityRepository = opportunityRepository;
        //this.reportingRepository = reportingRepository;
    }

    Validations Validations=new Validations();
    public   Scanner console = new Scanner(System.in);
    private  String menuChoice;
    private  int numericInput;


    //print the welcome screen
    public void welcomeScreen(){
        Graphics.mainMenuGraphic();
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the CRM - Customer Relations Management *");

    }


    //main element of menu
    public  void mainMenu(){
        boolean runProgram=true;
        console = new Scanner(System.in);

        //run the loop until user will choose to exit
        while(runProgram) {

            System.out.println();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("What do you want to do?");
            //trims and concatenates user input to make it easier to verify with pattern
            menuChoice = Validations.convertUserInputToCommand(console.nextLine());

            //check if the input is one of the valid options
            boolean validMainMenuOption = Validations.isValidMenuCommand(menuChoice);

            //loop while input is an invalid option
            while (!validMainMenuOption) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("This is not a valid option! Type help for the list of available commands.");
                menuChoice = Validations.convertUserInputToCommand(console.nextLine());
                validMainMenuOption = Validations.isValidMenuCommand(menuChoice);
            }

            //removes all digits to convert input into menu command
            String command = Validations.removeAllDigits(menuChoice);

            //removes all characters to extract id from input
            numericInput = Validations.removeAllCharacters(menuChoice);
            switch (command) {

                case "help" -> help();

                case "reports" -> reports();

                case "newlead" -> createNewLead();

                case "newsalesrep" -> createNewSalesRep();

                case "showleads" -> showLeads();

                case "showsalesreps" -> showSalesReps();

                case "showaccounts" -> showAccounts();

                case "showopportunities" -> showOpportunities();

                case "lookuplead" -> lookupLead(numericInput);

                case "lookupopportunity" -> lookupOpportunity(numericInput);

                case "lookupaccount" -> lookupAccount(numericInput);

                case "convert" -> convertLead(numericInput);

                case "close-lost" -> closeOpportunity(numericInput, Status.CLOSED_LOST);

                case "closelost" -> closeOpportunity(numericInput, Status.CLOSED_LOST);

                case "close-won" -> closeOpportunity(numericInput, Status.CLOSED_WON);

                case "closewon" -> closeOpportunity(numericInput, Status.CLOSED_WON);

                //////////Reports
                case "reportleadbysalesrep"->{for(String record: leadRepository.reportLeadBySalesRep()){System.out.println(record);}}
                case "reportopportunitybysalesrep"->{for(String record: opportunityRepository.reportOpportunityBySalesRep()){System.out.println(record);}}
                case "reportclosed-wonbysalesrep"->{for(String record: opportunityRepository.reportCLOSEDWONbySalesRep()){System.out.println(record);}}
                case "reportclosed-lostbysalesrep"->{for(String record: opportunityRepository.reportCLOSEDLOSTbySalesRep()){System.out.println(record);}}
                case "reportopenbysalesrep"->{for(String record: opportunityRepository.reportOPENbySalesRep()){System.out.println(record);}}
                case "reportopportunitybytheproduct"->{for(String record: opportunityRepository.reportOpportunitybytheproduct()){System.out.println(record);}}
                case "reportclosed-wonbytheproduct"->{for(String record: opportunityRepository.reportCLOSEDWONbytheproduct()){System.out.println(record);}}
                case "reportclosed-lostbytheproduct"->{for(String record: opportunityRepository.reportCLOSEDLOSTbytheproduct()){System.out.println(record);}}
                case "reportopenbytheproduct"->{for(String record: opportunityRepository.reportOPENbytheproduct()){System.out.println(record);}}
                case "reportopportunitybycountry"->{for(String record: opportunityRepository.reportOpportunitybyCountry()){System.out.println(record);}}
                case "reportclosed-wonbycountry"->{for(String record: opportunityRepository.reportCLOSEDWONbyCountry()){System.out.println(record);}}
                case "reportclosed-lostbycountry"->{for(String record: opportunityRepository.reportCLOSEDLOSTbyCountry()){System.out.println(record);}}
                case "reportopenbycountry"->{for(String record: opportunityRepository.reportOPENbyCountry()){System.out.println(record);}}
                case "reportopportunitybycity"->{for(String record: opportunityRepository.reportOpportunitybyCity()){System.out.println(record);}}
                case "reportclosed-wonbycity"->{for(String record: opportunityRepository.reportCLOSEDWONbyCity()){System.out.println(record);}}
                case "reportclosed-lostbycity"->{for(String record: opportunityRepository.reportCLOSEDLOSTbyCity()){System.out.println(record);}}
                case "reportopenbycity"->{for(String record: opportunityRepository.reportOPENbyCity()){System.out.println(record);}}
                case "reportopportunitybyindustry"->{for(String record: opportunityRepository.reportOpportunitybyIndustry()){System.out.println(record);}}
                case "reportclosed-wonbyindustry"->{for(String record: opportunityRepository.reportCLOSEDWONbyIndustry()){System.out.println(record);}}
                case "reportclosed-lostbyindustry"->{for(String record: opportunityRepository.reportCLOSEDLOSTbyIndustry()){System.out.println(record);}}
                case "reportopenbyindustry"->{for(String record: opportunityRepository.reportOPENbyIndustry()){System.out.println(record);}}
                case "meanemployeecount"->{for(String record: accountRepository.meanEmployeeCount()){System.out.println(record);}}
                case "medianemployeecount"->{for(String record: accountRepository.medianEmployeeCount()){System.out.println(record);}}
                case "maxemployeecount"->{for(String record: accountRepository.maxEmployeeCount()){System.out.println(record);}}
                case "minemployeecount"->{for(String record: accountRepository.minEmployeeCount()){System.out.println(record);}}
                case "meanquantity"->{for(String record: accountRepository.meanQuantity()){System.out.println(record);}}
                case "medianquantity"->{for(String record: accountRepository.medianQuantity()){System.out.println(record);}}
                case "maxquantity"->{for(String record: accountRepository.maxQuantity()){System.out.println(record);}}
                case "minquantity"->{for(String record: accountRepository.minQuantity()){System.out.println(record);}}
                case "meanoppsperaccount"->{for(String record: accountRepository.meanOppsperAccount()){System.out.println(record);}}
                case "medianoppsperaccount"->{for(String record: accountRepository.medianOppsperAccount()){System.out.println(record);}}
                case "maxoppsperaccount"->{for(String record: accountRepository.maxOppsperAccount()){System.out.println(record);}}
                case "minoppsperaccount"->{for(String record: accountRepository.minOppsperAccount()){System.out.println(record);}}

                case "definition" -> CRMDefinition();

                case "play" -> Sounds.playSound();

                case "exit" -> runProgram = false;

                //hidden menu option for users who will spot asterisks in welcome screen
                case "*" -> CRMTrueDefinition();

                // case "Report DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Lead by DeadCodersSocietyClubRickyMartinStage2Homework3.dao.SalesRep" -> Report()


                //just a security valve - probably redundant
                default -> System.out.println("This option is not yet implemented");
            }
        }

        //exit program
    }

    public  void createNewLead() {
        String name;
        String phoneNumber;
        String email;
        String companyName;
        SalesRep salesRep;
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

        //ask for SalesRep Id. If not existing ask again
        System.out.println("Please enter SalesRep Id for this lead:");
        userInput = console.nextLine();
        while(userInput == null || userInput.isEmpty() || salesRepRepository.findById(Integer.valueOf(userInput)).isEmpty()){
            if(salesRepRepository.findAll().isEmpty()){
                System.out.println("No salesRep was found! Please create new salesRep.");
                createNewSalesRep();
                System.out.println("Please enter SalesRep Id for this lead:");
                userInput = console.nextLine();
            }else {
                System.out.println("No SalesRep with given ID was found. Please enter valid Id:");
                userInput = console.nextLine();
            }
        }
        salesRep=salesRepRepository.findById(Integer.parseInt(userInput.trim())).get();

        //create new lead
        if(leadRepository.findFirstByNameAndPhoneNumberAndEmailAndCompanyNameAndSalesRep(name, phoneNumber, email, companyName, salesRep).isEmpty()) {
            leadRepository.save(new Lead(name, phoneNumber, email, companyName, salesRep));
            Lead lead = leadRepository.findFirstByNameAndPhoneNumberAndEmailAndCompanyNameAndSalesRep(name, phoneNumber, email, companyName, salesRep).get();
            System.out.println(lead.showLeadDetails());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("New lead created: ");
            //System.out.println(newLead.showLeadDetails());
        }else {
            System.out.println("Lead with given data already exists: ");
            System.out.println(leadRepository.findFirstByNameAndPhoneNumberAndEmailAndCompanyNameAndSalesRep(name, phoneNumber, email, companyName, salesRep).get().showLeadDetails());
        }
    }

    public  void createNewSalesRep() {
        String name;
        SalesRep salesRep;
        console = new Scanner(System.in);

        System.out.println("Please enter first name for this SalesRep:");
        // Get input from the user
        String userInput = console.nextLine();
        //valideate if the first name is valid
        while(!Validations.isValidFirstName(userInput)){
            System.out.println("This first name is invalid. Please enter valid first name for this SalesRep:");
            userInput = console.nextLine();
        }
        //use validated, trimmed first name and last name
        name = "".concat(userInput.trim());

        //validate if last name is valid
        System.out.println("Please enter last name for this SalesRep:");
        userInput = console.nextLine();
        while(!Validations.isValidLastName(userInput)){
            System.out.println("This last name is invalid. Please enter valid last name for this SalesRep:");
            userInput = console.nextLine();
        }
        //use trimmed, capitalized name
        name=WordUtils.capitalizeFully(name.concat(" ").concat(userInput.trim())).trim();

        //create new SalesRep
        if(salesRepRepository.findFirstByName(name).isPresent()){
            System.out.println("SalesRep with given name already exists:");
            System.out.println(salesRepRepository.findFirstByName(name).get().showSalesRepDetails());
        }else {
            salesRepRepository.save(new SalesRep(name));
            salesRep=salesRepRepository.findFirstByName(name).get();
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("New SalesRep created: ");
            System.out.println(salesRep.showSalesRepDetails());
        }

    }



    //helper menu to display available commands
    public  void help(){
        System.out.println(
                """
                        Available commands are:
                        New SalesRep - allows creation of a new SalesRep,
                        Show SalesReps - displays a list of all available SalesRep,
                        Lookup SalesRep id - display SalesRep with given id,
                        New Lead - allows creation of a new Lead,
                        Show Leads - displays a list of all available Leads,
                        Lookup Lead id - display Lead with given id,
                        Convert id - converts Lead with given id to an Opportunity,
                        Lookup Opportunity id - display Opportunity with given id,
                        Lookup Account id - display Account with given id,
                        Close-lost id - closes Opportunity with given id with status LOST,
                        Close-won id - closes Opportunity with given id with status WON,
                        Help - displays list of available commands,
                        Reports - displays a list of available reports,
                        Definition - displays definition of CRM,
                        Play - play some motivating music,
                        EXIT - terminates the program.
                        """
        );

    }

    //helper menu to display available reports
    public  void reports(){
        System.out.println(
                """
                        Available reports are:
                        By SalesRep
                        1. A count of Leads by SalesRep can be displayed by typing “Report Lead by SalesRep”
                        2. A count of all Opportunities by SalesRep can be displayed by typing “Report Opportunity by SalesRep”
                        3. A count of all CLOSED_WON Opportunities by SalesRep can be displayed by typing “Report CLOSED-WON by SalesRep”
                        4. A count of all CLOSED_LOST Opportunities by SalesRep can be displayed by typing “Report CLOSED-LOST by SalesRep”
                        5. A count of all OPEN Opportunities by SalesRep can be displayed by typing “Report OPEN by SalesRep”
                                                
                                                
                        By Product
                        1. A count of all Opportunities by the product can be displayed by typing “Report Opportunity by the product”
                        2. A count of all CLOSED_WON Opportunities by the product can be displayed by typing “Report CLOSED-WON by the product”
                        3. A count of all CLOSED_LOST Opportunities by the product can be displayed by typing “Report CLOSED-LOST by the product”
                        4. A count of all OPEN Opportunities by the product can be displayed by typing “Report OPEN by the product”
                                                
                                                
                        By Country
                        1. A count of all Opportunities by country can be displayed by typing “Report Opportunity by Country”
                        2. A count of all CLOSED_WON Opportunities by country can be displayed by typing “Report CLOSED-WON by Country”
                        3. A count of all CLOSED_LOST Opportunities by country can be displayed by typing “Report CLOSED-LOST by Country”
                        4. A count of all OPEN Opportunities by country can be displayed by typing “Report OPEN by Country”
                                                
                                                
                        By City
                        1. A count of all Opportunities by the city can be displayed by typing “Report Opportunity by City”
                        2. A count of all CLOSED_WON Opportunities by the city can be displayed by typing “Report CLOSED-WON by City”
                        3. A count of all CLOSED_LOST Opportunities by the city can be displayed by typing “Report CLOSED-LOST by City”
                        4. A count of all OPEN Opportunities by the city can be displayed by typing “Report OPEN by City”
                                                
                                                
                        By Industry
                        1. A count of all Opportunities by industry can be displayed by typing “Report Opportunity by Industry”
                        2. A count of all CLOSED_WON Opportunities by industry can be displayed by typing “Report CLOSED-WON by Industry”
                        3. A count of all CLOSED_LOST Opportunities by industry can be displayed by typing “Report CLOSED-LOST by Industry”
                        4. A count of all OPEN Opportunities by industry can be displayed by typing “Report OPEN by Industry”
                                                
                                                
                        EmployeeCount States
                        1. The mean employeeCount can be displayed by typing “Mean EmployeeCount”
                        2. The median employeeCount can be displayed by typing “Median EmployeeCount”
                        3. The maximum employeeCount can be displayed by typing “Max EmployeeCount”
                        4. The minimum employeeCount can be displayed by typing “Min EmployeeCount”
                                                
                                                
                        Quantity States
                        1. The mean quantity of products order can be displayed by typing “Mean Quantity”
                        2. The median quantity of products order can be displayed by typing “Median Quantity”
                        3. The maximum quantity of products order can be displayed by typing “Max Quantity”
                        4. The minimum quantity of products order can be displayed by typing “Min Quantity”
                                                
                                                
                        Opportunity States
                        1. The mean number of Opportunities associated with an Account can be displayed by typing “Mean Opps per Account”
                        2. The median number of Opportunities associated with an Account can be displayed by typing “Median Opps per Account”
                        3. The maximum number of Opportunities associated with an Account can be displayed by typing “Max Opps per Account”
                        4. The minimum number of Opportunities associated with an Account can be displayed by typing “Min Opps per Account”
                                                                  
                        """
        );

    }

    //show list of leads stored in leadList
    public  void showLeads(){
        if (leadRepository.findAll().size()==0){
            System.out.println("No leads found!");
        } else {
            for (Lead lead : leadRepository.findAll()) {
                System.out.println("Id: ".concat(String.valueOf(lead.getId()))
                        .concat(" | Name: ").concat(lead.getName())
                        .concat(" | Phone number: ").concat(lead.getPhoneNumber())
                        .concat(" | Email: ").concat(lead.getEmail())
                        .concat(" | Company: ").concat(lead.getCompanyName())
                        .concat(" | SalesRep id: ").concat(String.valueOf(lead.getSalesRep().getId()))
                        .concat(" | SalesRep name: ").concat(lead.getSalesRep().getName()));
            }
        }
    }

    //show list of leads stored in leadList
    public  void showSalesReps(){
        if (salesRepRepository.findAll().size()==0){
            System.out.println("No SalesReps found!");
        } else {
            for (SalesRep salesRep : salesRepRepository.findAll()) {
                System.out.println("Id: ".concat(String.valueOf(salesRep.getId()))
                        .concat(" Name: ").concat(salesRep.getName()));
            }
        }
    }

    //show list of leads stored in leadList
    public  void showAccounts(){
        if (accountRepository.findAll().size()==0){
            System.out.println("No Accounts found!");
        } else {
            for (Account account : accountRepository.findAll()) {
                System.out.println(account.showAccountDetails());
            }
        }
    }

    public  void showOpportunities(){
        if (opportunityRepository.findAll().size()==0){
            System.out.println("No opportunities found!");
        } else {
            for (Opportunity opportunity : opportunityRepository.findAll()) {
                System.out.println(opportunity.showOpportunityDetails());
            }
        }
    }

    //verify if lead with given id exists and return its details
    public void lookupLead(int num){
        if(leadRepository.findById(num).isEmpty()){
            System.out.println("Lead with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            System.out.println("Lead found!");
            System.out.println(leadRepository.findById(num).get().showLeadDetails());
        }
    }

    //convert lead with given id into a new opportunity
    public void convertLead(int num) {
        Account account;
        Contact decisionMaker;
        Opportunity newOpportunity;
        String userInput;
        Lead lead;

        console = new Scanner(System.in);
        Product product;
        int     quantity;
        if (leadRepository.findById(num).isEmpty()) {
            System.out.println("Lead with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            lead = leadRepository.findById(num).get();
            //save and return contact
            contactRepository.save(new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName()));
            decisionMaker = contactRepository.findFirstByNameAndPhoneNumberAndEmailAndCompanyName(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName()).get();
            System.out.println("Lead found!");
            System.out.println("New contact created with following data:");
            System.out.println(decisionMaker.showContactDetails());
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please choose the product for this opportunity. Available options are: ");
            System.out.println(java.util.Arrays.asList(Product.values()));

            menuChoice = Validations.convertUserInputToCommand(console.nextLine());
            //loop while input is an invalid enum DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Product
            while (Validations.getProduct(menuChoice) == null) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("This is not a valid option! available options are:");
                System.out.println(java.util.Arrays.asList(Product.values()));
                menuChoice = Validations.convertUserInputToCommand(console.nextLine());
            }
            //fetch valid enum
            product = Validations.getProduct(menuChoice);

            //get quantity for given product
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Please choose the number of trucks for this opportunity.");
            numericInput = Validations.getPositiveInt(console.nextLine());
            while (numericInput <= 0) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("This is not a valid quantity!");
                numericInput = Validations.getPositiveInt(console.nextLine());
            }
            quantity = numericInput;

            //create new opportunity, save it  and print its details
            if (opportunityRepository.findFirstByProductAndQuantityAndDecisionMakerAndSalesRep(product, quantity, decisionMaker, lead.getSalesRep()).isPresent()) {
                System.out.println("Opportunity with given details already exists:");
                newOpportunity = opportunityRepository.findFirstByProductAndQuantityAndDecisionMakerAndSalesRep(product, quantity, decisionMaker, lead.getSalesRep()).get();
                System.out.println(newOpportunity.showOpportunityDetails());
            } else {
                opportunityRepository.save(new Opportunity(product, quantity, decisionMaker, lead.getSalesRep()));
                newOpportunity = opportunityRepository.findFirstByProductAndQuantityAndDecisionMakerAndSalesRep(product, quantity, decisionMaker, lead.getSalesRep()).get();
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("New opportunity created as following: ");
                System.out.println(newOpportunity.showOpportunityDetails());
            }

            //remove converted lead from the list
            leadRepository.delete(lead);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Lead id: ".concat(String.valueOf(lead.getId())).concat(" was removed."));

            //Ask if new Account should be created
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Do you want to create a new Account? (Y/N).");
            userInput = console.nextLine();
            while (!Validations.inputIsYesOrNo(userInput)) {
                System.out.println("This is not a valid option. Do you want to create a new Account? (Y/N).");
                userInput = console.nextLine();
            }
            //if user do not want to create new account but no account is found create one
            if ((Validations.convertUserInputToCommand(userInput).matches("no") || Validations.convertUserInputToCommand(userInput).matches("n")) && accountRepository.findAll().isEmpty()) {
                System.out.println("There are no existing accounts!");
                account=createAccount(opportunityRepository.findFirstByProductAndQuantityAndDecisionMakerAndSalesRep(product, quantity, decisionMaker, lead.getSalesRep()).get());
            }else if(Validations.convertUserInputToCommand(userInput).matches("no") || Validations.convertUserInputToCommand(userInput).matches("n")){
                //Ask for account ID
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Please provide Account id. Type list for all accounts.");
                userInput = console.nextLine();
                numericInput = Validations.getPositiveInt(userInput);
                while (numericInput <= 0 || accountRepository.findById(numericInput).isEmpty()) {
                    if (userInput.toLowerCase().trim().matches("list")) {
                        showAccounts();
                    } else {
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("This is not a valid account id!");
                        numericInput = Validations.getPositiveInt(console.nextLine());
                    }
                }
                account=accountRepository.findById(numericInput).get();
            }else {
                account = createAccount(opportunityRepository.findFirstByProductAndQuantityAndDecisionMakerAndSalesRep(product, quantity, decisionMaker, lead.getSalesRep()).get());
            }
            decisionMaker.setAccount(account);
            contactRepository.save(decisionMaker);
            newOpportunity.setAccount(account);
            opportunityRepository.save(newOpportunity);
            }

    }


    //create new account
    public Account createAccount(Opportunity opportunity){
        Account account;

        console = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Please choose the industry for this Account. Available options are: ");
        System.out.println(Arrays.asList(Industry.values()));

        //ask for enum and validate input
        menuChoice= Validations.convertUserInputToCommand(console.nextLine());
        //loop while input is an invalid option
        while (Validations.getIndustry(menuChoice)==null) {
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("This is not a valid option! available options are:");
            System.out.println(java.util.Arrays.asList(Industry.values()));
            menuChoice= Validations.convertUserInputToCommand(console.nextLine());
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
        menuChoice= Validations.convertUserInputToCommand(console.nextLine()).toUpperCase();
        boolean isValidCode=ListCountry.isValidISOCountry(menuChoice);

        //loop until input matches one of correct ISO codes
        while (!isValidCode) {
            if(menuChoice.equalsIgnoreCase("list")) {
                ListCountry.run();
                menuChoice= Validations.convertUserInputToCommand(console.nextLine()).toUpperCase();
                isValidCode=ListCountry.isValidISOCountry(menuChoice);
            }else {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("This is not a valid country code! Type LIST for the country list.");
                menuChoice = Validations.convertUserInputToCommand(console.nextLine()).toUpperCase();
                isValidCode = ListCountry.isValidISOCountry(menuChoice);
            }
        }
        //fetch country name based on ISO code
        String country=ListCountry.getCountry(menuChoice);

        //ask for city name, trim and capitalize it
        System.out.println("Please enter city name:");
        menuChoice= Validations.convertUserInputToCommand(console.nextLine());
        //validate if city is empty
        while(menuChoice == null || menuChoice.isEmpty()){
            System.out.println("City name cannot be empty. Please enter valid city:");
            menuChoice = Validations.convertUserInputToCommand(console.nextLine());
        }
        String city=Validations.removeAllDigits(menuChoice);
        city=WordUtils.capitalizeFully(city.trim());

        //create new account with given data
        accountRepository.save(new Account(industry, employeeCount, city, country, opportunity, opportunity.getDecisionMaker()));
        account=accountRepository.findFirstByIndustryAndEmployeeCountAndCityAndCountry(industry, employeeCount, city, country).get();
        System.out.println("New Account created!");
        System.out.println(account.showAccountDetails());
        return account;
    }

    //verify if given DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account exists in the list and print details
    public  void lookupOpportunity(int num){
        if(opportunityRepository.findById(num).isEmpty()){
            System.out.println("Opportunity with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            System.out.println("Opportunity found!");
            System.out.println(opportunityRepository.findById(num).get().showOpportunityDetails());
        }
    }
    //verify if given opportunity exists in the list and print details
    public  void closeOpportunity(int num, Status status) {
        if (!status.toString().equals("CLOSED_LOST") && !status.toString().equals("CLOSED_WON")) {
            System.out.println("This is not a valid status! Type CLOSED_LOST or CLOSED_WON.");
        } else {
            if (opportunityRepository.findById(num).isEmpty()) {
                System.out.println("Opportunity with ID="
                        .concat(String.valueOf(num))
                        .concat(" was not found!"));
            } else {
                Opportunity opportunity=opportunityRepository.findById(num).get();
                opportunity.setStatus(status);
                opportunityRepository.save(opportunity);
                System.out.println("Opportunity found and updated!");
                System.out.println(opportunityRepository.findById(num).get().showOpportunityDetails());
                if (status==Status.CLOSED_WON){
                    System.out.println("You've won this opportunity! Congratulations! \nLet's celebrate it with some music!");
                    Sounds.playSound();
                }
            }
        }
    }

    //verify if given DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account exists in the list and print details
    public  void lookupAccount(int num){
        if(accountRepository.findById(num).isEmpty()){
            System.out.println("Account with ID="
                    .concat(String.valueOf(num))
                    .concat(" was not found!"));
        } else {
            System.out.println("Account found!");
            System.out.println(accountRepository.findById(num).get().showAccountDetails());
        }
    }


    //print CRM definition from Wikipedia
    public  void CRMDefinition(){
        System.out.println("According to Wikipedia:");
        System.out.println("Customer relationship management (CRM) is a process in which a business or other organization \n administers its interactions with customers, typically using data analysis to study large amounts of information.");
        System.out.println();
        System.out.println("CRM systems compile data from a range of different communication channels, including a company's website, \n telephone, email, live chat, marketing materials and more recently, social media. \n They allow businesses to learn more about their target audiences and how to best cater for their needs, thus retaining customers and driving sales growth. \n CRM may be used with past, present or potential customers. \n The concepts, procedures, and rules that a corporation follows when communicating with its consumers are referred to as customer relationship management (CRM). \n This complete connection covers direct contact with customers, such as sales and service-related operations, \n forecasting, and the analysis of consumer patterns and behaviors, from the perspective of the company.");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    //print lesser known definition of CRM ;)
    public  void CRMTrueDefinition(){
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


