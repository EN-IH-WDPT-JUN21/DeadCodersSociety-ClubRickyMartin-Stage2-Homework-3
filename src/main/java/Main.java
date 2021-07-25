
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lead tl = new Lead("John", "+48 501 501 501", "john_mck@gmail.com", "MCWoodworking");
        System.out.println(tl.showLeadDetails());

        //temporary
        Menu.mainMenu();
        Menu.CRMDefinition();
        Menu.CRMTrueDefinition();
        System.out.println();
        Graphics.trueCRMGraphic();

        System.out.println();
        Scanner myScanner = new Scanner(System.in);
        // Get input from the user
        System.out.println("Please enter your mail");
        String userInput = myScanner.nextLine();
        System.out.println(Validations.isValidEmailAddress(userInput));

        System.out.println("Please enter your phone number");
        userInput = myScanner.nextLine();
        System.out.println(Validations.isValidPhoneNumber(userInput));

        System.out.println("Please enter your first name");
        userInput = myScanner.nextLine();
        System.out.println(Validations.isValidFirstName(userInput));

        System.out.println("Please enter your last name");
        userInput = myScanner.nextLine();
        System.out.println(Validations.isValidLastName(userInput));
    }
}
