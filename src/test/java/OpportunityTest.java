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
}