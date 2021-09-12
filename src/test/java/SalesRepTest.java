import DeadCodersSocietyClubRickyMartinStage2Homework3.ApplicationTest;
import DeadCodersSocietyClubRickyMartinStage2Homework3.Menu;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Lead;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.SalesRep;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.LeadRepository;
import DeadCodersSocietyClubRickyMartinStage2Homework3.repository.SalesRepRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = ApplicationTest.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class SalesRepTest {
    InputStream stdin = System.in;

    @Autowired
    Menu menu;

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() {
        System.setIn(stdin);
    }

    @AfterEach
    void tearDown() {
        System.setIn(stdin);
    }

    @Test
    void idIncrementation() {
        SalesRep salesRep1 = new SalesRep("John McCormick");
        SalesRep salesRep2 = new SalesRep("Jonathan Reeves");

        salesRep1 = salesRepRepository.save(salesRep1);
        salesRep2 = salesRepRepository.save(salesRep2);

        assertEquals(salesRep1.getId() + 1, salesRep2.getId());
    }

    @Test
    void printSalesRepDetails() {
        SalesRep salesRep1 = new SalesRep("John McCormick");
        salesRep1 = salesRepRepository.save(salesRep1);

        assertEquals("""
                SalesRep details:\s
                ID: 1
                Name: John McCormick
                """, salesRep1.showSalesRepDetails());
    }

}
