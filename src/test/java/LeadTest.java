import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeadTest {
    PrintStream standardOut = System.out;
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void setId(){
        Lead lead1=new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        Lead lead2=new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        assertEquals(lead1.getId()+1, lead2.getId());
    }

    @Test
    void testAllArgsLeadConstructor(){
        List<Lead> leadList=new ArrayList<>();
        Lead lead1=new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        leadList.add(lead1);
        assertEquals("500500500", leadList.get(0).getPhoneNumber());
    }

    @Test
    void testNoArgsLeadConstructor(){
        List<Lead> leadList=new ArrayList<>();
        String data = "Mat9" +
                "\n Mat" +
                "\n Poreda9" +
                "\n Poreda \n" +
                "\n PHoneNumber \n" +
                "500500100" +
                "\n mat.mat" +
                "\n mat.mat@gmail.com" +
                "\n" +
                "\n Ironhack";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        Lead lead1=new Lead();
        assertEquals("500500100", lead1.getPhoneNumber());
    }

    @Test
    void printLeadDetails() {
        Lead lead1=new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        ;
        assertEquals("""
                     ID: 5
                     Company Name: GooglyEyes
                     Name: John McCormick
                     Phone Number: 500500500
                     Email: John@gmail.com
                     """, lead1.showLeadDetails());
    }


}