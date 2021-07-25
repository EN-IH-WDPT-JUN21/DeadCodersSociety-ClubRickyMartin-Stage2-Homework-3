import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationsTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
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
}