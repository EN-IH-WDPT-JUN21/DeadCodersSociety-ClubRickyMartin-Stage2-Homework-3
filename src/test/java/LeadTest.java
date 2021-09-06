import DeadCodersSocietyClubRickyMartinStage2Homework3.Menu;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Lead;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.LeadRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LeadTest {
    InputStream stdin = System.in;
    Menu Menu;

    @Autowired
    LeadRepository leadRepository;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        System.setIn(stdin);


    }

    @AfterEach
    void tearDown() {
        System.setIn(stdin);
    }

    @Test
    void idIncrementation(){
        Lead lead1=new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        Lead lead2=new Lead("Jonathan Reeves", "500500700", "Reeves@gmail.com", "GooglyCats");
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
    void testCreateNewLead(){
        String data1 = "Mat\nPoreda\n500500100\nmat.mat@gmail.com\nIronhack\n";
        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        Menu.createNewLead();
        assertEquals("500500100", Menu.leadList.get(0).getPhoneNumber());
        InputStream stdin = System.in;
        System.setIn(stdin);

    }


    @Test
    void testCreateNewLead2(){

        String data1 = "Mat\nPoreda\n500500100\nmat.mat@gmail.com\nIronhack\n";

        System.setIn(new ByteArrayInputStream(data1.getBytes()));
        Menu.createNewLead();
        assertEquals("500500100", Menu.leadList.get(0).getPhoneNumber());
        InputStream stdin = System.in;
        System.setIn(stdin);

    }


    @Test
    void printLeadDetails() {
        Lead lead1=new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        ;
        assertEquals("""
                     ID: 1
                     Company Name: GooglyEyes
                     Name: John McCormick
                     Phone Number: 500500500
                     Email: John@gmail.com
                     """, lead1.showLeadDetails());
    }

    @Test
    void testtest() {
        Lead lead1 = new Lead("John McCormick", "500500500", "John@gmail.com", "GooglyEyes");
        leadRepository.save(lead1);
        ;
        assertEquals("500500500", leadRepository.findAll().get(0).getPhoneNumber());
    }


}