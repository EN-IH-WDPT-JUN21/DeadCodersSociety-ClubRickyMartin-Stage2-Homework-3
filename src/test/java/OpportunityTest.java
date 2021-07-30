import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpportunityTest {

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        TestUtils.resetIdCounter(Opportunity.class);
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
        assertEquals("""
                ID: 1
                Status: OPEN
                Product: FLATBED
                Quantity: 2
                Contact details:\s
                ID: 1
                Company Name: dummy-company-name-1
                Name: dummy-name-1
                Phone Number: dummy-phone-number-1
                Email: dummy-email-1
                """, opportunity1.showOpportunityDetails());
    }
}