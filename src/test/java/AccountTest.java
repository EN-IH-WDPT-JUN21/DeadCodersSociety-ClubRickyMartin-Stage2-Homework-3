import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountTest {

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        TestUtils.resetIdCounter(Account.class);
    }

    @Test
    void accountPropertiesHaveGivenValues() {
        //when
        Account acc = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());

        //then
        assertEquals(Industry.PRODUCE, acc.getIndustry());
        assertEquals(10, acc.getEmployeeCount());
        assertEquals("Berlin", acc.getCity());
        assertEquals("USA", acc.getCountry());
        assertNotNull(acc.getContactList());
        assertEquals(0, acc.getContactList().size());
        assertNotNull(acc.getOpportunityList());
        assertEquals(0, acc.getOpportunityList().size());
    }

    @Test
    void firstAccountGetsIdOne() {
        //when
        Account acc = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());

        //then
        assertEquals(1, acc.getId());
    }

    @Test
    void secondAccountGetsIdTwo() {
        //when
        Account acc1 = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());
        Account acc2 = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());

        //then
        assertEquals(1, acc1.getId());
        assertEquals(2, acc2.getId());
    }

    @Test
    void printAccountDetails() {
        //when
        Account acc = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());

        //then
        assertEquals("""
                ID: 1
                Industry: PRODUCE
                Employee count: 10
                City: Berlin
                Country: USA
                 """, acc.showAccountDetails());
    }
}