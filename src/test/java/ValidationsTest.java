import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationsTest {
    static List<Lead> leadList=Menu.getLeadList();
    static List<Opportunity> opportunityList=Menu.getOpportunityList();
    static List<Account> accountList=Menu.getAccountList();

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        TestUtils.resetIdCounter(Lead.class);
        TestUtils.resetIdCounter(Opportunity.class);
        TestUtils.resetIdCounter(Account.class);
    }

    @AfterEach
    void tearDown() {
        leadList.clear();
        opportunityList.clear();
        accountList.clear();
    }

    @Test
    void isValidEmailAddress() {
        assertTrue(Validations.isValidEmailAddress("john.mccormick@yahoo.com"));
        assertTrue(Validations.isValidEmailAddress("1234567890@companyname.domain"));
        assertFalse(Validations.isValidEmailAddress("name.lastname.domain.com"));
        assertFalse(Validations.isValidEmailAddress("@com"));
    }

    @Test
    void isValidPhoneNumber() {
        assertTrue(Validations.isValidPhoneNumber("500 400 300"));
        assertTrue(Validations.isValidPhoneNumber("500400300"));
        assertTrue(Validations.isValidPhoneNumber("+48 500 400 300"));
        assertTrue(Validations.isValidPhoneNumber("+48500400300"));
        assertFalse(Validations.isValidPhoneNumber("tel500400300"));
        assertFalse(Validations.isValidPhoneNumber("50040030555522522552225522"));
        assertFalse(Validations.isValidPhoneNumber("0300"));

    }

    @Test
    void isValidFirstName() {
        assertTrue(Validations.isValidFirstName("mat"));
        assertTrue(Validations.isValidFirstName("VARvaRa"));
        assertFalse(Validations.isValidFirstName("malg0rz4ta"));
        assertFalse(Validations.isValidFirstName("jerzy1"));

    }

    @Test
    void isValidLastName() {
        assertTrue(Validations.isValidLastName("poreda-nextname"));
        assertTrue(Validations.isValidLastName("NecHaeva"));
        assertFalse(Validations.isValidLastName("W4rczak"));
        assertFalse(Validations.isValidLastName("Danielewicz12"));
    }

    @Test
    void isValidMenuCommand() {
        assertTrue(Validations.isValidMenuCommand("helP  "));
        assertTrue(Validations.isValidMenuCommand("Show leads"));
        assertTrue(Validations.isValidMenuCommand("close-won 1"));
        assertTrue(Validations.isValidMenuCommand("close won 1"));
        assertTrue(Validations.isValidMenuCommand("look up lead 2"));
        assertFalse(Validations.isValidMenuCommand("look up lead two"));
    }

    @Test
    void removeAllCharacters() {
        assertEquals(0, Validations.removeAllCharacters("helP  "));
        assertEquals(19, Validations.removeAllCharacters("helP 1 9"));
        assertEquals(1, Validations.removeAllCharacters("close-won 1"));
        assertEquals(1234, Validations.removeAllCharacters("""
                        1
                        a
                        2
                        b
                        3
                        4
                        *
                        """));
    }

    @Test
    void removeAllDigitsAndConvertToLowerCaseCommand() {
        assertEquals("help", Validations.removeAllDigits("helP  "));
        assertEquals("help", Validations.removeAllDigits("helP 1 9"));
        assertEquals("close-won", Validations.removeAllDigits("close-won 1"));
        assertEquals("ab*", Validations.removeAllDigits("""
                        1
                        a
                        2
                        b
                        3
                        4
                        *
                        """));
    }

    @Test
    void getLeadIndexByIdReturnNegativeOneIfNotPresent() {
        var lead1=new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        leadList.add(lead1);
        assertEquals(0, Validations.getLeadIndexById(leadList, 1));
        assertEquals(-1, Validations.getLeadIndexById(leadList, 2));
    }

    @Test
    void getOpportunityIndexById() {
        var contact1=new Contact("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        var opportunity1 =new Opportunity(Product.BOX, 500, contact1);
        assertEquals(-1, Validations.getOpportunityIndexById(opportunityList, 1));
        opportunityList.add(opportunity1);
        System.out.println(opportunityList.isEmpty());
        System.out.println(opportunity1.getId());
        assertEquals(0, Validations.getOpportunityIndexById(opportunityList, 1));
    }

    @Test
    void getAccountIndexById() {
        var contact1=new Contact("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        var opportunity1=new Opportunity(Product.BOX, 500, contact1);
        var account1=new Account(Industry.MEDICAL, 500, "Washington", "United States", contact1, opportunity1);
        assertEquals(-1, Validations.getAccountIndexById(accountList, 1));
        accountList.add(account1);
        assertEquals(0, Validations.getAccountIndexById(accountList, 1));
    }

    @Test
    void getProductEnumReturnNullIfInvalidInput() {
        assertEquals(null, Validations.getProduct("Boxer"));
        assertEquals(Product.BOX, Validations.getProduct("Box"));
    }

    @Test
    void getIndustryEnumReturnNullIfInvalidInput() {
        assertEquals(null, Validations.getIndustry("others"));
        assertEquals(Industry.OTHER, Validations.getIndustry("OtheR"));
    }

    @Test
    void getStatusEnumReturnNullIfInvalidInput() {
        assertEquals(null, Validations.getStatus("closed lost"));
        assertEquals(Status.CLOSED_LOST, Validations.getStatus("closed_LOST"));
    }

    @Test
    void isValidInt() {
        assertTrue(Validations.isValidInt("-10"));
        assertTrue(Validations.isValidInt("0"));
        assertFalse(Validations.isValidInt("123.00"));
        assertFalse(Validations.isValidInt("dog"));
        assertFalse(Validations.isValidInt(""));
    }

    @Test
    void getPositiveIntReturn0IfNegative() {
        assertEquals(0,Validations.getPositiveInt("-10"));
        assertEquals(100, Validations.getPositiveInt("100"));
        assertEquals(0, Validations.getPositiveInt("123.00"));
        assertEquals(0, Validations.getPositiveInt("dog"));
        assertEquals(0,Validations.getPositiveInt(""));
    }



}