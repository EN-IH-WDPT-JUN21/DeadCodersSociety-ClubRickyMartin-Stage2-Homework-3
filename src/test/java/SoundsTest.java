import DeadCodersSocietyClubRickyMartinStage2Homework3.Sounds;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
    File file = Sounds.getAudioDirectory();
    assumeTrue(null != file);

    Sounds.playSound();
    assertTrue(outputStreamCaptor.toString().contains("Clip is open: true"));
  }

  @Test
  void getAudioDirectoryName() {
    File file = Sounds.getAudioDirectory();
    assumeTrue(null != file);

    assertEquals("audio",
        file.getName());
  }

}