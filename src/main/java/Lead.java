import org.apache.commons.lang.WordUtils;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Lead {

    private static AtomicInteger idCounter = new AtomicInteger(0);
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    //constructor based on user input
    public Lead() {
        setId();

        Scanner myScanner = new Scanner(System.in);
        // Get input from the user
        System.out.println("Please enter first name for this lead:");
        String userInput = myScanner.nextLine();
        //valideate if the first name is valid
        while(!Validations.isValidFirstName(userInput)){
            System.out.println("This first name is invalid. Please enter valid first name for this lead:");
            userInput = myScanner.nextLine();
        }
        String name = "".concat(userInput);
        //validate if last name is valid
        System.out.println("Please enter last name for this lead:");
        userInput = myScanner.nextLine();
        while(!Validations.isValidLastName(userInput)){
            System.out.println("This last name is invalid. Please enter valid last name for this lead:");
            userInput = myScanner.nextLine();
        }
        //use trimmed, capitalized name
        name=name.concat(" ").concat(userInput);
        setName(WordUtils.capitalizeFully(name.trim()));

        //validate if phone number is valid
        System.out.println("Please enter phone number for this lead:");
        userInput = myScanner.nextLine();
        while(!Validations.isValidPhoneNumber(userInput)){
            System.out.println("This phone number is invalid. Please enter valid phone number for this lead:");
            userInput = myScanner.nextLine();
        }
        //use validated user input
        setPhoneNumber(userInput);

        //validate if Email address is valid
        System.out.println("Please enter email address for this lead:");
        userInput = myScanner.nextLine();
        while(!Validations.isValidEmailAddress(userInput)){
            System.out.println("This email address is invalid. Please enter valid email address for this lead:");
            userInput = myScanner.nextLine();
        }
        //use validated user input
        setEmail(userInput);

        System.out.println("Please enter company name for this lead:");
        userInput = myScanner.nextLine();
        while(userInput == null || userInput.isEmpty()){
            System.out.println("Company name cannot be empty. Please enter valid company name for this lead:");
            userInput = myScanner.nextLine();
        }
        setCompanyName(userInput);
        myScanner.close();
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        setId();
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    //returns lead details
    public String showLeadDetails(){
        return "ID: ".concat(String.valueOf(this.getId())).concat("\n")
                .concat("Company Name: ").concat(this.getCompanyName()).concat("\n")
                .concat("Name: ").concat(this.getName()).concat("\n")
                .concat("Phone Number: ").concat(this.getPhoneNumber()).concat("\n")
                .concat("Email: ").concat(this.getEmail()).concat("\n");
    }

    public int getId() {
        return this.id;
    }
    public void setId() {
        this.id = idCounter.incrementAndGet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
