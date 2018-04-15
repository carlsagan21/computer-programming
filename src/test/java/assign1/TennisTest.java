package assign1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class TennisTest extends StdIOTest {

  @Test
  void mainAM() {
    String input = "1\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "$\n"
            + "$\n"
            + "$\n"
            + "(b)\n"
            + "$\n"
            + "$\n"
            + "$\n",
        outContent.toString());
  }
}