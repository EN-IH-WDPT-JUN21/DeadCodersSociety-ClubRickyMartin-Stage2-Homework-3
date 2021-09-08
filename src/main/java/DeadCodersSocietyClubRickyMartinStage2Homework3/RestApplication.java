package DeadCodersSocietyClubRickyMartinStage2Homework3;

import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Lead;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Locale;

@SpringBootApplication
@Profile("!test")
public class RestApplication implements CommandLineRunner {

  @Autowired
  Menu menu;


  public static void main(String[] args) {
    SpringApplication.run(RestApplication.class, args);

  }

  @Override
  public void run(String... args) {
//        version with the repository being passed

//        var mainMenu = new MainMenu(coffeeRepository);
//        mainMenu.printAllCoffees();

//        version with the use of spring components, the better one!
    Locale.setDefault(new Locale("en", "US"));
    menu.welcomeScreen();
    menu.mainMenu();

  }

}

