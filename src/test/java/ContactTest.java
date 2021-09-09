import DeadCodersSocietyClubRickyMartinStage2Homework3.RestApplicationTest;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Contact;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.AccountRepository;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.ContactRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = RestApplicationTest.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ContactTest {
  @Autowired
  private ContactRepository contactRepository;

  @Test
  void whenNewContactIsBeingCreatedNextIdShouldBeSet() {
    //when
    Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    Contact contact2 = new Contact("dummy-name-2", "dummy-phone-number-2", "dummy-email-2", "dummy-company-name-2");
    contact1 = contactRepository.save(contact1);
    contact2 = contactRepository.save(contact2);

    //then
    assertEquals(1, contact1.getId());
    assertEquals(2, contact2.getId());
  }

  @Test
  void printContactDetails() {
    //when
    Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
    contact1 = contactRepository.save(contact1);
    //then
    assertEquals("""
        Contact Details:\s
           ID: 1
           Company Name: dummy-company-name-1
           Name: dummy-name-1
           Phone Number: dummy-phone-number-1
           Email: dummy-email-1
           """, contact1.showContactDetails());
  }


  @Test
  void gettersAndSettersSetAndGet() {
    //given
    Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");

    //when
    contact1.setName("setName");
    contact1.setPhoneNumber("500500500");
    contact1.setEmail("email@email");
    contact1.setCompanyName("setCompanyName");

    //then
    assertEquals("setName", contact1.getName());
    assertEquals("500500500", contact1.getPhoneNumber());
    assertEquals("email@email", contact1.getEmail());
    assertEquals("setCompanyName", contact1.getCompanyName());

  }

}