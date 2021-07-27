import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  private InputStream provideInput(String data) {
    return new ByteArrayInputStream(data.getBytes());
  }
  private String getOutput(OutputStream outStream) {
    return outStream.toString().replaceAll("\r\n", "\n").replaceAll("\r", "\n");
  }
  @Test
  void mainTest() {
    var outStream = new ByteArrayOutputStream();
    var out = new PrintStream(outStream);

    var errStream = new ByteArrayOutputStream();
    var err = new PrintStream(errStream);

    Main.main(provideInput("Warja"), out, err);

    assertEquals("Please enter your name\n" +
        "Welcome Warja\n", getOutput(outStream));
    assertEquals("", getOutput(errStream));
  }
}