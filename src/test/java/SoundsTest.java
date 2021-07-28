import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SoundsTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void confirmClipIsOpen() {
        Sounds.playSound();
        assertEquals("Clip is open: true",
                outputStreamCaptor.toString().trim());
    }

    @Test
    void getAudioDirectoryName(){
        File file=Sounds.getAudioDirectory();
        System.out.println(file.getName());
        assertEquals("audio",
                file.getName());
    }

}