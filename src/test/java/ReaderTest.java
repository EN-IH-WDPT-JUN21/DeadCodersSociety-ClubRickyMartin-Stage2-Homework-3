import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Reader console2=Reader.getInstance();




    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        console2=Reader.getInstance();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void newReaderInstanceEqualsToNextReaderInstance() {
        var console=Reader.getInstance();
        var console2=Reader.getInstance();
        assertTrue(console.equals(console2));
    }
}