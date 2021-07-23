import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    main(System.in, System.out, System.err);
  }

  public static void main(InputStream in, PrintStream out, PrintStream err) {
    //Create a Scanner to collect user input
    Scanner myScanner = new Scanner(in);

    // Get input from the user
    out.println("Please enter your name");
    String userInput = myScanner.nextLine();

    out.println("Welcome "+ userInput);
  }

}