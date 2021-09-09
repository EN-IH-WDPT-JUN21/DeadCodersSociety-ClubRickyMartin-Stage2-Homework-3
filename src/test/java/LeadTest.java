import DeadCodersSocietyClubRickyMartinStage2Homework3.Menu;
import DeadCodersSocietyClubRickyMartinStage2Homework3.RestApplicationTest;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Lead;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.SalesRep;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.LeadRepository;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.SalesRepRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = RestApplicationTest.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class LeadTest {
  InputStream stdin = System.in;

  @Autowired
  Menu menu;

  @Autowired
  LeadRepository leadRepository;

  @Autowired
  SalesRepRepository salesRepRepository;

  @BeforeEach
  void setUp() {
    System.setIn(stdin);
  }

  @AfterEach
  void tearDown() {
    System.setIn(stdin);
  }

  @Test
  void idIncrementation() {
    Lead lead1 = new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
    Lead lead2 = new Lead("Jonathan Reeves", "500500700", "Reeves@gmail.com", "GooglyCats");

    lead1 = leadRepository.save(lead1);
    lead2 = leadRepository.save(lead2);

    assertEquals(lead1.getId() + 1, lead2.getId());
  }

  @Test
  void testAllArgsLeadConstructor() {
    List<Lead> leadList = new ArrayList<>();
    Lead lead1 = new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
    leadList.add(lead1);
    assertEquals("500500500", leadList.get(0).getPhoneNumber());
  }


  @Test
  void testCreateNewLeadExistingSalesRep() {

    SalesRep salesRep = new SalesRep("Bob");
    salesRep = salesRepRepository.save(salesRep);
    String data1 = "Mat\nPoreda\n500500100\nmat.mat@gmail.com\nIronhack\n1\n";
    System.setIn(new ByteArrayInputStream(data1.getBytes()));
    menu.createNewLead();

    assertTrue(leadRepository.findById(1).isPresent());
    assertEquals("500500100", leadRepository.findById(1).get().getPhoneNumber());
    InputStream stdin = System.in;
    System.setIn(stdin);
  }

  @Test
  void printLeadDetails() {
    Lead lead1 = new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
    lead1 = leadRepository.save(lead1);

    assertEquals("""
        Lead details:\s
           ID: 1
           Company Name: GooglyEyes
           Name: John McCormick
           Phone Number: 500500500
           Email: John@gmail.com
                """, lead1.showLeadDetails());
  }

  @Test
  void testtest() {
    Lead lead1 = new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
    leadRepository.save(lead1);
    assertEquals("500500500", leadRepository.findAll().get(0).getPhoneNumber());
  }


}