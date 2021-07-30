import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeadTest {

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        TestUtils.resetIdCounter(Lead.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void idIncrementation(){
        Lead lead1=new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        Lead lead2=new Lead("Jonathan Reeves", "500500700", "Reeves@gmail.com", "GooglyCats");
        assertEquals(lead1.getId()+1, lead2.getId());
    }

    @Test
    void testAllArgsLeadConstructor(){
        List<Lead> leadList = new ArrayList<>();
        Lead lead1 = new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        leadList.add(lead1);
        assertEquals("500500500", leadList.get(0).getPhoneNumber());
    }

    @Test
    void testCreateNewLead() {
        String data = """
                Mat9
                Mat
                Poreda9
                Poreda
                PHoneNumber
                500500100
                mat.mat
                mat.mat@gmail.com

                Ironhack
                """;

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Menu.createNewLead();
        assertEquals("500500100", Menu.leadList.get(0).getPhoneNumber());
    }

    @Test
    void printLeadDetails() {
        Lead lead1=new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");

        assertEquals("""
                     ID: 1
                     Company Name: GooglyEyes
                     Name: John McCormick
                     Phone Number: 500500500
                     Email: John@gmail.com
                     """, lead1.showLeadDetails());
    }
}