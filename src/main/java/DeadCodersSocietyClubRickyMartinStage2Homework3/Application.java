package DeadCodersSocietyClubRickyMartinStage2Homework3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Locale;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    Menu menu;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        Locale.setDefault(new Locale("en", "US"));
        menu.welcomeScreen();
        menu.mainMenu();
    }

}

