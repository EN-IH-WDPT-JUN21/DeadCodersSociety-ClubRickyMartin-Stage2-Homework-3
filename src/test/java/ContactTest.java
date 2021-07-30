import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactTest {

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        TestUtils.resetIdCounter(Contact.class);
    }

    @Test
    void whenNewContactIsBeingCreatedNextIdShouldBeSet() {
        //when
        Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
        Contact contact2 = new Contact("dummy-name-2", "dummy-phone-number-2", "dummy-email-2", "dummy-company-name-2");

        //then
        assertEquals(1, contact1.getId());
        assertEquals(2, contact2.getId());
    }

    @Test
    void printContactDetails() {
        //when
        Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");

        //then
        assertEquals("""
                ID: 1
                Company Name: dummy-company-name-1
                Name: dummy-name-1
                Phone Number: dummy-phone-number-1
                Email: dummy-email-1
                 """, contact1.showContactDetails());
    }
}