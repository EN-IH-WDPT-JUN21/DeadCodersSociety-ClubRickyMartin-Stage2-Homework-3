import DeadCodersSocietyClubRickyMartinStage2Homework3.Menu;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Contact;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Opportunity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Industry;
import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Product;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AccountTest {
    Menu Menu;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
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
//        assertNotNull(acc.getContactList());
//        assertEquals(0, acc.getContactList().size());
//        assertNotNull(acc.getOpportunityList());
//        assertEquals(0, acc.getOpportunityList().size());
    }

    @Test
    void firstAccountGetsIdOne() {
        //when
        Account acc = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());

        //then
        assertEquals(0, acc.getId());
    }

    @Test
    void secondAccountGetsIdTwo() {
        //when
        Account acc1 = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());
        Account acc2 = new Account(Industry.PRODUCE, 10, "Berlin", "USA", Collections.emptyList(), Collections.emptyList());

        //then
        assertEquals(0, acc1.getId());
        assertEquals(1, acc2.getId());
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

    @Test
    void noListsAccountCreated() {
        //given
        Contact contact = new Contact("dummy-name-1", "dummy-phone-number-1", "dummy-email-1", "dummy-company-name-1");

        //when
        Opportunity opportunity = new Opportunity(Product.FLATBED, 2, contact);
        Menu.opportunityList.add(opportunity);
        Account account = new Account(Industry.MEDICAL, 100, "Warsaw", "Poland", opportunity, contact);

        //then
        assertEquals("Warsaw", account.getCity());
    }

    @Test
    void gettersAndSettersSetAndGet(){
        //given
        Account acc1 = new Account(Industry.PRODUCE, 10, "Berlin", "USA", new ArrayList<>(), new ArrayList<>());
        Account acc2 = new Account(Industry.OTHER, 100, "Warsaw", "Poland", new ArrayList<>(), new ArrayList<>());
        Contact contact2 = new Contact("dummy-name-2", "dummy-phone-number-2", "dummy-email-2", "dummy-company-name-2");
        Opportunity opportunity1 = new Opportunity(Product.FLATBED, 2, contact2);

        //when
        acc1.setCity(acc2.getCity());
        acc1.setCountry(acc2.getCountry());
        acc1.setIndustry(acc2.getIndustry());
        acc1.setEmployeeCount(acc2.getEmployeeCount());
//        acc2.getContactList().add(contact2);
//        acc2.getOpportunityList().add(opportunity1);
//        acc1.setContactList(acc2.getContactList());
//        acc1.setOpportunityList(acc2.getOpportunityList());

        //then
        assertEquals(acc1.getCity(), acc2.getCity());
        assertEquals(acc1.getIndustry(), acc2.getIndustry());
        assertEquals(acc1.getEmployeeCount(), acc2.getEmployeeCount());
        assertEquals(acc1.getCountry(), acc2.getCountry());
//        assertEquals(acc1.getOpportunityList(), acc2.getOpportunityList());
//        assertEquals(acc1.getContactList(), acc2.getContactList());

    }


}