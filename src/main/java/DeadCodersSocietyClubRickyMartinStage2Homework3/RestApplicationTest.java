package DeadCodersSocietyClubRickyMartinStage2Homework3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("test")
public class RestApplicationTest {
  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(RestApplicationTest.class);
    app.setLogStartupInfo(false);
    app.run(args);
  }
}
