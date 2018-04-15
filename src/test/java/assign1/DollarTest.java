package assign1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class DollarTest extends StdIOTest {

  @Test
  void test1() {
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

  @Test
  void test2() {
    String input = "2\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "$$\n"
            + "$$\n"
            + "$$\n"
            + "(b)\n"
            + "$$\n"
            + "$$\n"
            + "$$\n",
        outContent.toString());
  }

  @Test
  void test3() {
    String input = "3\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + " $\n"
            + "$$$\n"
            + " $\n"
            + "$$$\n"
            + " $\n"
            + "(b)\n"
            + " $\n"
            + "$ $\n"
            + "@$@\n"
            + "$ $\n"
            + " $\n",
        outContent.toString());
  }

  @Test
  void test4() {
    String input = "4\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + " $$\n"
            + "$$$$\n"
            + " $$\n"
            + "$$$$\n"
            + " $$\n"
            + "(b)\n"
            + " $$\n"
            + "$  $\n"
            + "@$$@\n"
            + "$  $\n"
            + " $$\n",
        outContent.toString());
  }

  @Test
  void test5() {
    String input = "5\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "  $\n"
            + "$$$$$\n"
            + "  $\n"
            + "$$$$$\n"
            + "  $\n"
            + "(b)\n"
            + "  $\n"
            + "$   $\n"
            + " @$@\n"
            + "$   $\n"
            + "  $\n",
        outContent.toString());
  }

  @Test
  void test6() {
    String input = "6\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "  $$\n"
            + "$$$$$$\n"
            + "  $$\n"
            + "$$$$$$\n"
            + "  $$\n"
            + "(b)\n"
            + "  $$\n"
            + "$    $\n"
            + " @$$@\n"
            + "$    $\n"
            + "  $$\n",
        outContent.toString());
  }

  @Test
  void test7() {
    String input = "7\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "   $\n"
            + " $$$$$\n"
            + "$$$$$$$\n"
            + " $$$$$\n"
            + "$$$$$$$\n"
            + " $$$$$\n"
            + "   $\n"
            + "(b)\n"
            + "   $\n"
            + " $   $\n"
            + "$     $\n"
            + " $   $\n"
            + "$     $\n"
            + " $   $\n"
            + "   $\n",
        outContent.toString());
  }

  @Test
  void test8() {
    String input = "8\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "   $$\n"
            + " $$$$$$\n"
            + "$$$$$$$$\n"
            + " $$$$$$\n"
            + "$$$$$$$$\n"
            + " $$$$$$\n"
            + "   $$\n"
            + "(b)\n"
            + "   $$\n"
            + " $    $\n"
            + "$      $\n"
            + " $    $\n"
            + "$      $\n"
            + " $    $\n"
            + "   $$\n",
        outContent.toString());
  }

  @Test
  void test9() {
    String input = "9\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "    $\n"
            + "  $$$$$\n"
            + "$$$$$$$$$\n"
            + "  $$$$$\n"
            + "$$$$$$$$$\n"
            + "  $$$$$\n"
            + "    $\n"
            + "(b)\n"
            + "    $\n"
            + "  $   $\n"
            + "$       $\n"
            + "  $   $\n"
            + "$       $\n"
            + "  $   $\n"
            + "    $\n",
        outContent.toString());
  }

  @Test
  void test11() {
    String input = "11\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "     $\n"
            + "   $$$$$\n"
            + " $$$$$$$$$\n"
            + "$$$$$$$$$$$\n"
            + " $$$$$$$$$\n"
            + "$$$$$$$$$$$\n"
            + " $$$$$$$$$\n"
            + "   $$$$$\n"
            + "     $\n"
            + "(b)\n"
            + "     $\n"
            + "   $   $\n"
            + " $       $\n"
            + "$         $\n"
            + " $       $\n"
            + "$         $\n"
            + " $       $\n"
            + "   $   $\n"
            + "     $\n",
        outContent.toString());
  }

  @Test
  void test12() {
    String input = "12\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "     $$\n"
            + "   $$$$$$\n"
            + " $$$$$$$$$$\n"
            + "$$$$$$$$$$$$\n"
            + " $$$$$$$$$$\n"
            + "   $$$$$$\n"
            + " $$$$$$$$$$\n"
            + "$$$$$$$$$$$$\n"
            + " $$$$$$$$$$\n"
            + "   $$$$$$\n"
            + "     $$\n"
            + "(b)\n"
            + "     $$\n"
            + "   $    $\n"
            + " $        $\n"
            + "$          $\n"
            + " $        $\n"
            + "  @$    $@\n"
            + " $        $\n"
            + "$          $\n"
            + " $        $\n"
            + "   $    $\n"
            + "     $$\n",
        outContent.toString());
  }

  @Test
  void test13() {
    String input = "13\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "      $\n"
            + "    $$$$$\n"
            + "  $$$$$$$$$\n"
            + "$$$$$$$$$$$$$\n"
            + "  $$$$$$$$$\n"
            + "$$$$$$$$$$$$$\n"
            + "  $$$$$$$$$\n"
            + "    $$$$$\n"
            + "      $\n"
            + "(b)\n"
            + "      $\n"
            + "    $   $\n"
            + "  $       $\n"
            + "$           $\n"
            + "  $       $\n"
            + "$           $\n"
            + "  $       $\n"
            + "    $   $\n"
            + "      $\n",
        outContent.toString());
  }

  @Test
  void test16() {
    String input = "16\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "       $$\n"
            + "     $$$$$$\n"
            + "   $$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$\n"
            + "     $$$$$$\n"
            + "       $$\n"
            + "(b)\n"
            + "       $$\n"
            + "     $    $\n"
            + "   $        $\n"
            + " $            $\n"
            + "$              $\n"
            + " $            $\n"
            + "   $        $\n"
            + " $            $\n"
            + "$              $\n"
            + " $            $\n"
            + "   $        $\n"
            + "     $    $\n"
            + "       $$\n",
        outContent.toString());
  }

  @Test
  void test20() {
    String input = "20\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "         $$\n"
            + "       $$$$$$\n"
            + "     $$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$\n"
            + "       $$$$$$\n"
            + "         $$\n"
            + "(b)\n"
            + "         $$\n"
            + "       $    $\n"
            + "     $        $\n"
            + "   $            $\n"
            + " $                $\n"
            + "$                  $\n"
            + " $                $\n"
            + "   $            $\n"
            + "    @$        $@\n"
            + "   $            $\n"
            + " $                $\n"
            + "$                  $\n"
            + " $                $\n"
            + "   $            $\n"
            + "     $        $\n"
            + "       $    $\n"
            + "         $$\n",
        outContent.toString());
  }

  @Test
  void test28() {
    String input = "28\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "             $$\n"
            + "           $$$$$$\n"
            + "         $$$$$$$$$$\n"
            + "       $$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$$$$$$$$$\n"
            + "       $$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$$$$$$$$$\n"
            + "       $$$$$$$$$$$$$$\n"
            + "         $$$$$$$$$$\n"
            + "           $$$$$$\n"
            + "             $$\n"
            + "(b)\n"
            + "             $$\n"
            + "           $    $\n"
            + "         $        $\n"
            + "       $            $\n"
            + "     $                $\n"
            + "   $                    $\n"
            + " $                        $\n"
            + "$                          $\n"
            + " $                        $\n"
            + "   $                    $\n"
            + "     $                $\n"
            + "      @$            $@\n"
            + "     $                $\n"
            + "   $                    $\n"
            + " $                        $\n"
            + "$                          $\n"
            + " $                        $\n"
            + "   $                    $\n"
            + "     $                $\n"
            + "       $            $\n"
            + "         $        $\n"
            + "           $    $\n"
            + "             $$\n",
        outContent.toString());
  }

  @Test
  void test35() {
    String input = "35\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "                 $\n"
            + "               $$$$$\n"
            + "             $$$$$$$$$\n"
            + "           $$$$$$$$$$$$$\n"
            + "         $$$$$$$$$$$$$$$$$\n"
            + "       $$$$$$$$$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "       $$$$$$$$$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + " $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "     $$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "       $$$$$$$$$$$$$$$$$$$$$\n"
            + "         $$$$$$$$$$$$$$$$$\n"
            + "           $$$$$$$$$$$$$\n"
            + "             $$$$$$$$$\n"
            + "               $$$$$\n"
            + "                 $\n"
            + "(b)\n"
            + "                 $\n"
            + "               $   $\n"
            + "             $       $\n"
            + "           $           $\n"
            + "         $               $\n"
            + "       $                   $\n"
            + "     $                       $\n"
            + "   $                           $\n"
            + " $                               $\n"
            + "$                                 $\n"
            + " $                               $\n"
            + "   $                           $\n"
            + "     $                       $\n"
            + "       $                   $\n"
            + "     $                       $\n"
            + "   $                           $\n"
            + " $                               $\n"
            + "$                                 $\n"
            + " $                               $\n"
            + "   $                           $\n"
            + "     $                       $\n"
            + "       $                   $\n"
            + "         $               $\n"
            + "           $           $\n"
            + "             $       $\n"
            + "               $   $\n"
            + "                 $\n",
        outContent.toString());
  }

  @Test
  void test41() {
    String input = "41\n";
    System.setIn(new ByteArrayInputStream(input.getBytes()));
    Dollar.main(new String[]{});
    assertEquals(
        "Type the maximum length: (a)\n"
            + "                    $\n"
            + "                  $$$$$\n"
            + "                $$$$$$$$$\n"
            + "              $$$$$$$$$$$$$\n"
            + "            $$$$$$$$$$$$$$$$$\n"
            + "          $$$$$$$$$$$$$$$$$$$$$\n"
            + "        $$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "        $$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "          $$$$$$$$$$$$$$$$$$$$$\n"
            + "        $$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "        $$$$$$$$$$$$$$$$$$$$$$$$$\n"
            + "          $$$$$$$$$$$$$$$$$$$$$\n"
            + "            $$$$$$$$$$$$$$$$$\n"
            + "              $$$$$$$$$$$$$\n"
            + "                $$$$$$$$$\n"
            + "                  $$$$$\n"
            + "                    $\n"
            + "(b)\n"
            + "                    $\n"
            + "                  $   $\n"
            + "                $       $\n"
            + "              $           $\n"
            + "            $               $\n"
            + "          $                   $\n"
            + "        $                       $\n"
            + "      $                           $\n"
            + "    $                               $\n"
            + "  $                                   $\n"
            + "$                                       $\n"
            + "  $                                   $\n"
            + "    $                               $\n"
            + "      $                           $\n"
            + "        $                       $\n"
            + "          $                   $\n"
            + "        $                       $\n"
            + "      $                           $\n"
            + "    $                               $\n"
            + "  $                                   $\n"
            + "$                                       $\n"
            + "  $                                   $\n"
            + "    $                               $\n"
            + "      $                           $\n"
            + "        $                       $\n"
            + "          $                   $\n"
            + "            $               $\n"
            + "              $           $\n"
            + "                $       $\n"
            + "                  $   $\n"
            + "                    $\n",
        outContent.toString());
  }
}