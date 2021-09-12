import DeadCodersSocietyClubRickyMartinStage2Homework3.ApplicationTest;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Contact;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Opportunity;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.ContactRepository;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.OpportunityRepository;
import org.junit.jupiter.api.Test;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ApplicationTest.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class OpportunityTest {

  @Autowired
  ContactRepository contactRepository;

  @Autowired
  OpportunityRepository opportunityRepository;

  @Test
  void whenNewOpportunityIsBeingCreatedNextIdShouldBeSet() {
    //given
    Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    Contact contact2 = new Contact("dummy-name-2", "dummy-phone-number-2", "dummy-email-2", "dummy-company-name-2");
    contact1 = contactRepository.save(contact1);
    contact2 = contactRepository.save(contact2);

    //when
    Opportunity opportunity1 = new Opportunity(Product.FLATBED, 2, contact1);
    Opportunity opportunity2 = new Opportunity(Product.FLATBED, 2, contact2);
    opportunity1 = opportunityRepository.save(opportunity1);
    opportunity2 = opportunityRepository.save(opportunity2);

    //then
    assertEquals(1, opportunity1.getId());
    assertEquals(2, opportunity2.getId());
  }

  @Test
  void printOpportunityDetails() {
    //given
    Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");

    //when
    Opportunity opportunity1 = new Opportunity(Product.FLATBED, 2, contact1);

    //then
    assertEquals("""
        Opportunity details:\s
           ID: 0
           Status: OPEN
           Product: FLATBED
           Quantity: 2
           Contact details:\s
        Contact Details:\s
           ID: 0
           Company Name: dummy-company-name-1
           Name: dummy-name-1
           Phone Number: dummy-phone-number-1
           Email: dummy-email-1
           
        """, opportunity1.showOpportunityDetails());
  }

  @Test
  void gettersAndSettersSetAndGet() {
    //given
    Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    Contact contact2 = new Contact("dummy-name-2", "dummy-phone-number-2", "dummy-email-2", "dummy-company-name-2");

    //when
    Opportunity opportunity1 = new Opportunity(Product.FLATBED, 2, contact1);

    //then
    opportunity1.setProduct(Product.BOX);
    opportunity1.setQuantity(500);
    opportunity1.setDecisionMaker(contact2);

    assertEquals(Product.BOX, opportunity1.getProduct());
    assertEquals(500, opportunity1.getQuantity());
    assertEquals(contact2, opportunity1.getDecisionMaker());


  }


}