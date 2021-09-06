import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Contact;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Opportunity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import DeadCodersSocietyClubRickyMartinStage2Homework3.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpportunityTest {

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
    }


    @Test
    void whenNewOpportunityIsBeingCreatedNextIdShouldBeSet() {
        //given
        Contact contact1 = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");
        Contact contact2 = new Contact("dummy-name-2", "dummy-phone-number-2", "dummy-email-2", "dummy-company-name-2");

        //when
        Opportunity opportunity1 = new Opportunity(Product.FLATBED, 2, contact1);
        Opportunity opportunity2 = new Opportunity(Product.FLATBED, 2, contact2);

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
        assertEquals("ID: "+String.valueOf(opportunity1.getId())+"\n"+
                """
                Status: OPEN
                Product: FLATBED
                Quantity: 2
                Contact details:\s
                """+
                "ID: "+String.valueOf(contact1.getId())+"\n"+
                """
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