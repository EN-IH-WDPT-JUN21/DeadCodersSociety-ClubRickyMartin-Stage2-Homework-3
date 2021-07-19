
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Lead tl=new Lead("John", "+48 501 501 501", "john_mck@gmail.com","MCWoodworking");
        System.out.println(tl.showLeadDetails());

        Sounds.playSound();
        Scanner myScanner =new Scanner(System.in);
        // Get input from the user
        System.out.println("Please enter your name");
        String userInput = myScanner.nextLine();


    }


}
