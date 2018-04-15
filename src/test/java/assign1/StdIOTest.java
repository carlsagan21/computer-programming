package assign1;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StdIOTest {

  private static InputStream stdin = System.in;
  static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  @BeforeAll
  static void setUpStreams() {
    stdin = System.in;
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @AfterEach
  void resetStreams() {
    outContent.reset();
    errContent.reset();
  }

  @AfterAll
  static void restoreStreams() {
    System.setIn(stdin);
    System.setOut(System.out);
    System.setErr(System.err);
  }

  @Test
  void dummyTest() {}
}
