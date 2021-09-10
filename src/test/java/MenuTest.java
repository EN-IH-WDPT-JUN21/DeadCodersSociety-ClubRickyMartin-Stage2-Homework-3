import DeadCodersSocietyClubRickyMartinStage2Homework3.*;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.*;

import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Industry;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Product;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Status;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = ApplicationTest.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MenuTest {
  @Autowired
  Menu menu;

  @Autowired
  LeadRepository leadRepository;

  @Autowired
  SalesRepRepository salesRepRepository;

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  ContactRepository contactRepository;

  @Autowired
  OpportunityRepository opportunityRepository;

  DeadCodersSocietyClubRickyMartinStage2Homework3.Validations Validations = new Validations();
  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
  InputStream stdin = System.in;




  @BeforeEach
  void setUp() throws NoSuchFieldException, IllegalAccessException {
    System.setOut(new PrintStream(outputStreamCaptor));
    System.setIn(stdin);

  }

  @AfterEach
  void tearDown() {


    System.setIn(stdin);
  }


  @Test
  void welcomeScreen() {
    //when
    //String data = "help";
    //System.setIn(new ByteArrayInputStream(data.getBytes()));

    menu.welcomeScreen();
    //System.setIn(new ByteArrayInputStream(data.getBytes()));
    //then
    assertEquals("""
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓        ░▓▓▓           ░▓▓▓▓     ▓▓▓▓▓▓▓▓▓▓   ░ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓░     ░     ▓▓            ░ ▓▓░    ▓▓▓▓▓▓▓▓  ░   ░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓      ▓▓    ▓ ▓    ░▓▓▓▓  ░ ░▓▓  ░   ▓▓▓▓▓▓        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓░    ▓▓▓▓   ░▓▓    ░▓▓▓▓      ▓ ░  ░ ░▓▓▓▓▓ ▓      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓     ▓▓▓▓▓▓▓▓▓▓    ░▓▓▓▓ ░░  ░▓ ░ ▓   ▓▓▓▓ ▓     ░ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓     ░▓▓▓▓▓▓▓▓▓▓  ░          ░▓▓   ▓    ▓▓          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓     ░▓▓▓▓▓▓▓▓▓▓  ░         ▓▓▓▓░░ ▓     ▓    ▓  ░░ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓  ░  ░▓▓▓▓▓▓▓▓▓▓     ▓     ▓▓▓▓▓░  ▓ ▓       ▓▓  ░░░▓▓▓▓▓▓▓▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓     ░▓▓▓▓▓▓▓▓▓▓     ▓▓    ░▓▓▓▓░    ▓▓    ░▓▓▓     ▓▓▓▓▓▓      ░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓     ▓▓▓▓     ▓     ▓▓▓  ░ ░▓▓▓░    ▓▓▓ ░░░▓▓      ▓▓▓▓▓▓  ░▓▓  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓ ░  ░ ▓▓      ▓     ▓▓▓░     ▓▓░    ▓▓▓▓ ░░▓▓     ▓▓▓▓▓▓▓░ ░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓░  ░       ░▓▓     ▓▓▓▓  ░  ▓▓ ░ ▓ ▓▓▓▓▓▓▓▓▓ ░   ▓▓▓▓▓▓▓  ░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░ ░  ░ ░▓▓▓▓       ▓▓▓░    ▓░    ▓▓▓▓▓▓▓▓▓     ▓▓▓▓▓▓▓  ░▓   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒   ▓ ░░  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░  ░ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░   ░  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ▒▒▒▓▒▓▒▒▓▒░░▓▒▓ ▒▒▓▓▓░    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ░ ▓▓  ░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▓▒▒▒▒▒▒▒▒▒▒▒▒░    ░▓▓▒░    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ░     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒ ▒▒▒▒▒▒▒▒▒▒░▒▓  ░▒    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒░ ░░▒▒▒░░░  ▒░▒░   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░▓ ░ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▓▒▒▒▒▒▒▒▒▒▒ ░▒▒▒░░░   ░    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░  ▓▓  ░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▓▓▒▒░░   ░▒▒▒▒▒░░▒ ░▒▒▒▒░       ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ░▓▓▓▓▓▓ ░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▒▒▒▒▒▒░▒ ▒▒▒▒▒░▒▒ ▒▒░       ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒  ▓▓▓▓░ ░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▓▓▓▒▒▒▒▒▒░░░ ░░░░▒▒▒░░         ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░  ░▓▓   ░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ▒▓▒▒▒▒▒▒▒▒▒▒▒▒▒░░  ░░▒▒░ ░░      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░    ░   ▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░   ░▒░░      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒  ▓      ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒░▒░  ░░▒▒▒░            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒░░▓░ ▓   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒  ░░▒▒▒▒▒▒          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░ ▓▓▓▓  ░▓▓▓*▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░▓▒▒▒▒░░▒░░░░     ▒▒▒▒▒▒▒▒░     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒░░         ░▒▒▒▒▒▒░░    ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ▓▒▒▒▒▒░          ░░░░░▒░░░ ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▓▓▒▒▒▒░                   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒░                 ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒░░                ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▓▒▒▒░░ ░            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓ ▓▒▒▒░░░░░          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒░▒░░         ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓

        ----------------------------------------------------------------------------------------------------------------------------------------------------
        Welcome to the CRM - Customer Relations Management *
        """.replaceAll("\n", "").replaceAll("\r", ""), outputStreamCaptor.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
    System.setIn(stdin);
  }

  @Test
  void mainMenu() {

    //given
    Lead lead = new Lead("dummy-lead-name", "dummy-phone-number", "dummy-email", "dummy-company-name");
    lead = leadRepository.save(lead);

    //when
    String data = "showleads\n exit\n";
    System.setIn(new ByteArrayInputStream(data.getBytes()));
    menu.mainMenu();
    //then
    var actual = outputStreamCaptor.toString().trim().replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", "");
    assertTrue(actual.contains("Id:1|Name:dummy-lead-name|Phonenumber:dummy-phone-number|Email:dummy-email|Company:dummy-company-name"));
    assertTrue(actual.contains("Whatdoyouwanttodo?"));


    assertEquals(1, leadRepository.count());


    System.setIn(stdin);
  }


  @Test
  void convertUserInputToCommand_outputFormat() {
    //given
    String input = " LooK     up OpporTunity ";

    //when
    String output = Validations.convertUserInputToCommand(input);

    //then
    assertEquals("lookupopportunity", output);
  }

  @Test

  void showLeads_notEmptyLeadList() {
    //given
    Lead lead = new Lead("dummy-lead-name", "dummy-phone-number", "dummy-email", "dummy-company-name");
    lead = leadRepository.save(lead);

    //when
    menu.showLeads();

    //then
    assertEquals(1, leadRepository.count());
  }

  @Test
  void showLeads_notEmptyLeadList_output() {
    //given
    Lead lead = new Lead("dummy-lead-name", "dummy-phone-number", "dummy-email", "dummy-company-name");
    lead = leadRepository.save(lead);

    //when
    menu.showLeads();

    //then
    assertTrue(outputStreamCaptor.toString().contains("Id: 1 | Name: dummy-lead-name | Phone number: dummy-phone-number | Email: dummy-email | Company: dummy-company-name"));
  }

  @Test
  void showLeads_emptyLeadList() {
    assertEquals(0, leadRepository.count());


    //when
    menu.showLeads();


    //then
    assertTrue(outputStreamCaptor.toString().contains("No leads found!"));
  }

  @Test
  void lookupLead_found() {
    //given
    Lead lead = new Lead("dummy-lead-name", "dummy-phone-number", "dummy-email", "dummy-company-name");
    lead = leadRepository.save(lead);

    //when
    menu.lookupLead(lead.getId());

    //then
    var expected = """
        Lead details:
        ID: 1
        Company Name: dummy-company-name
        Name: dummy-lead-name
        Phone Number: dummy-phone-number
        Email: dummy-email""".replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", "");
    var actual = outputStreamCaptor.toString().trim().replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", "");
    assertTrue(actual.contains(expected));
  }

  @Test
  void lookupLead_notFound() {
    //given
    Lead lead = new Lead("dummy-lead-name", "dummy-phone-number", "dummy-email", "dummy-company-name");
    lead = leadRepository.save(lead);

    //when
    menu.lookupLead(lead.getId() + 1);

    //then
    assertTrue(outputStreamCaptor.toString().contains("Lead with ID=2 was not found!"));
  }


  @Test
  void convertLead_found() {
    SalesRep salesRep = new SalesRep("Bob");
    salesRep = salesRepRepository.save(salesRep);

    Account account = new Account(Industry.ECOMMERCE, 2, "Warsaw", "PL", (Opportunity) null, null);
    account = accountRepository.save(account);

    String data1 = "Dummy\nDummy-Dummy\n500500100\ndummy.dummy@gmail.com\nIronhack\n1\n";
    System.setIn(new ByteArrayInputStream(data1.getBytes()));
    menu.createNewLead();
    System.setIn(stdin);

    //given
    Lead lead = new Lead("dummy-lead-name", "500500500", "dummy@email", "dummy-company-name");
    lead = leadRepository.save(lead);
    System.out.println(leadRepository.count());
    menu.lookupLead(lead.getId());

    //when
    String data = "FLATBED\n100\nN\n1\n";
    System.setIn(new ByteArrayInputStream(data.getBytes()));
    menu.convertLead(1);

    //then
    assertTrue(opportunityRepository.findById(1).isPresent());
    assertEquals(100, opportunityRepository.findById(1).get().getQuantity());
    System.setIn(stdin);
  }

  @Test
  void convertLead_notFound() {
    //given
    Lead lead = new Lead("dummy-lead-name", "dummy-phone-number", "dummy-email", "dummy-company-name");
    lead = leadRepository.save(lead);

    //when
    menu.convertLead(Math.toIntExact(lead.getId() + 1));

    //then
    assertTrue(outputStreamCaptor.toString().contains("Lead with ID=2 was not found!"));
  }


  @Test
  void createAccount_userInput() {
    //given
    Contact contact = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    contact = contactRepository.save(contact);
    Opportunity opportunity = new Opportunity(Product.FLATBED, 2, contact);
    opportunity = opportunityRepository.save(opportunity);

    //when
    String data = "PRODUCED\nPRODUCE\n-1\n1\ncountry-code\nPL\ncity\n";

    System.setIn(new ByteArrayInputStream(data.getBytes()));
    menu.createAccount(opportunity);

    //then
    assertTrue(accountRepository.findById(1).isPresent());
    assertEquals(1, accountRepository.findById(1).get().getEmployeeCount());
    System.setIn(stdin);
  }

  @Test
  void CRMDefinition() {
    //when
    menu.CRMDefinition();

    //then
    assertEquals("""
            According to Wikipedia:
            Customer relationship management (CRM) is a process in which a business or other organization\s
            \sadministers its interactions with customers, typically using data analysis to study large amounts of information.
                            
            CRM systems compile data from a range of different communication channels, including a company's website,\s
            \stelephone, email, live chat, marketing materials and more recently, social media.\s
            \sThey allow businesses to learn more about their target audiences and how to best cater for their needs, thus retaining customers and driving sales growth.\s
            \sCRM may be used with past, present or potential customers.\s
            \sThe concepts, procedures, and rules that a corporation follows when communicating with its consumers are referred to as customer relationship management (CRM).\s
            \sThis complete connection covers direct contact with customers, such as sales and service-related operations,\s
            \sforecasting, and the analysis of consumer patterns and behaviors, from the perspective of the company.
            ----------------------------------------------------------------------------------------------------------------------------------------------------""".replaceAll("\n", "").replaceAll("\r", ""),
        outputStreamCaptor.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
  }

  @Test

  void lookupOpportunity_found() {
    //given
    Contact contact = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    contact = contactRepository.save(contact);


    Opportunity opportunity = new Opportunity(Product.FLATBED, 2, contact);
    opportunity = opportunityRepository.save(opportunity);

    //when
    menu.lookupOpportunity(1);

    //then
    var expected = """
        Opportunity details:
        ID: 1
        Status: OPEN
        Product: FLATBED
        Quantity: 2
        Contact details: Contact Details:   \s
        ID: 1
        Company Name: dummy-company-name-1
        Name: dummy-name-1
        Phone Number: dummy-phone-number-1
        Email: dummy-email-1""".replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", "");
    var actual = outputStreamCaptor.toString().trim().replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", "");
    assertTrue(actual.contains(expected));
  }

  @Test
  void lookupOpportunity_notFound() {
    //given
    Contact contact = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    contact = contactRepository.save(contact);


    Opportunity opportunity = new Opportunity(Product.FLATBED, 2, contact);
    opportunity = opportunityRepository.save(opportunity);

    //when
    menu.lookupOpportunity(2);

    //then
    assertTrue(outputStreamCaptor.toString().contains("Opportunity with ID=2 was not found!"));
  }

  @Test
  void lookupAccountNotFound() {
    menu.lookupAccount(1);
    assertTrue(outputStreamCaptor.toString().contains("Account with ID=1 was not found!"));
  }

  @Test
  void lookupAccountDetailsFound() {
    //given
    Contact contact = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    contact = contactRepository.save(contact);


    Opportunity opportunity = new Opportunity(Product.FLATBED, 2, contact);
    opportunity = opportunityRepository.save(opportunity);

    Account account = new Account(Industry.MEDICAL, 100, "Warsaw", "Poland", opportunity, contact);
    account = accountRepository.save(account);

    //when
    menu.lookupAccount(account.getId());

    //then
    var expected = """
        Account details:
        ID: 1
        Industry: MEDICAL
        Employee count: 100
        City: Warsaw
        Country: Poland
        """.replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", "");
    var actual = outputStreamCaptor.toString().trim().replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", "");
    assertTrue(actual.contains(expected));
  }

  @Test
  void closeOpportunityStatus_statusValidation_closed() {
    //given
    Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    Contact contact2 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    contact1 = contactRepository.save(contact1);
    contact2 = contactRepository.save(contact2);
    //when
    Opportunity opportunity1 = new Opportunity(Product.FLATBED, 2, contact1);
    Opportunity opportunity2 = new Opportunity(Product.FLATBED, 2, contact2);
    opportunity1 = opportunityRepository.save(opportunity1);
    opportunity2 = opportunityRepository.save(opportunity2);


    var opportunityStatusBeforeChangeToClosedLost = opportunity1.getStatus(); //OPEN
    var opportunityStatusBeforeChangeToClosedWon = opportunity2.getStatus(); //OPEN
    menu.closeOpportunity(1, Status.CLOSED_LOST);
    menu.closeOpportunity(2, Status.CLOSED_WON);

    //then
    assertTrue(opportunityRepository.findById(1).isPresent());
    assertTrue(opportunityRepository.findById(2).isPresent());
    assertNotEquals(opportunityStatusBeforeChangeToClosedLost, opportunityRepository.findById(1).get().getStatus());
    assertNotEquals(opportunityStatusBeforeChangeToClosedWon, opportunityRepository.findById(1).get().getStatus());
  }

  @Test
  void closeOpportunityStatus_changeToClosedStatus_output() {
    //given
    Contact contact = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    contact = contactRepository.save(contact);
    //when
    Opportunity opportunity = new Opportunity(Product.FLATBED, 2, contact);
    opportunity = opportunityRepository.save(opportunity);

    menu.closeOpportunity(1, Status.CLOSED_LOST);

    //then
    var expected = """
        Opportunity details:
        ID: 1
        Status: CLOSED_LOST
        Product: FLATBED
        Quantity: 2
        Contact details: ContactDetails:
        ID: 1
        Company Name: dummy-company-name-1
        Name: dummy-name-1
        Phone Number: dummy-phone-number-1
        Email: dummy-email-1""".replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", "");
    var actual = outputStreamCaptor.toString().trim().replaceAll("\n", "").replaceAll("\r", "").replaceAll(" ", "");
    assertTrue(actual.contains(expected));
  }

  @Test
  void closeOpportunityStatus_statusValidation_open() {
    //given
    Contact contact = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    contact = contactRepository.save(contact);
    //when
    Opportunity opportunity = new Opportunity(Product.FLATBED, 2, contact);
    opportunity = opportunityRepository.save(opportunity);


    menu.closeOpportunity(1, Status.CLOSED_WON);

    var opportunityStatusBeforeChangeToOpen = Status.CLOSED_WON;
    menu.closeOpportunity(1, Status.OPEN);

    //then
    assertTrue(opportunityRepository.findById(1).isPresent());
    assertEquals(opportunityStatusBeforeChangeToOpen, opportunityRepository.findById(1).get().getStatus());
  }

  @Test
  void closeOpportunityStatus_changeToOpenStatus_output() {
    //given
    Contact contact = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    contact = contactRepository.save(contact);
    //when
    Opportunity opportunity = new Opportunity(Product.FLATBED, 2, contact);
    opportunity = opportunityRepository.save(opportunity);

    menu.closeOpportunity(1, Status.OPEN);

    //then
    assertTrue(outputStreamCaptor.toString().contains("This is not a valid status! Type CLOSED_LOST or CLOSED_WON."));
  }
}