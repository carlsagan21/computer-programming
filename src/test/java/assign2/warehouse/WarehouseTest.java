package assign2.warehouse;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class Constants {

  private Constants() {
    throw new IllegalStateException("Utility class");
  }

  private static final String PROJECT_ROOT_PATH = "src/main/java/assign2/warehouse/";
  static final String STOCK_PATH = PROJECT_ROOT_PATH + "stock.txt";
  static final String INPUT_PATH = PROJECT_ROOT_PATH + "input.txt";
  static final String TX_PATH = PROJECT_ROOT_PATH + "tx.txt";

  static final String QUERY_DELIMITER = ",";
}

class WarehouseTest extends StdIOTest {

  private static String readFile(File file) throws IOException {
    return new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
  }

  private static int getLastIdOfTxContent(String txContent) {
    String[] lines = txContent.split("\\r?\\n");
    return lines.length == 1 ? 0
        : parseInt(lines[lines.length - 1].split(Constants.QUERY_DELIMITER)[0]);
  }

  @Test
  void basicTest() throws IOException {
    File stockFile = new File(Constants.STOCK_PATH);
    File inputFile = new File(Constants.INPUT_PATH);
    File txFile = new File(Constants.TX_PATH);
    PrintStream stockOut = new PrintStream(stockFile);
    PrintStream inputOut = new PrintStream(inputFile);
    String txPrevContent = readFile(txFile);
    int lastId = getLastIdOfTxContent(txPrevContent);

    // write to input file
    inputOut.print("I,C,Intel i7-7700K,300000,2\n"
        + "I,C,Intel i7-8700K,330000,2\n"
        + "I,C,AMD Ryzen 7 1700,190000,2\n"
        + "S,C,Intel i7-8700K,1\n"
        + "S,G,NVIDIA GTX1070Ti,6\n"
        + "E,P,Noname 800W,5\n");
    inputOut.close();

    // write to stock file
    stockOut.print("1,C,Intel i7-7700K,300000,1\n"
        + "2,C,AMD Ryzen 7 1700,200000,3\n"
        + "3,G,NVIDIA GTX1070Ti,800000,10\n"
        + "4,R,Samsung DDR4-17000 16G,200000,0\n"
        + "5,R,SK Hynix DDR4-19200 16G,240000,1\n"
        + "6,P,Noname 800W,80000,3\n");
    stockOut.close();

    // run warehouse
    Warehouse.main(new String[]{});

    // check stock
    assertEquals("1,C,Intel i7-7700K,300000,3\n"
            + "2,C,AMD Ryzen 7 1700,190000,5\n"
            + "3,G,NVIDIA GTX1070Ti,800000,4\n"
            + "4,R,Samsung DDR4-17000 16G,200000,0\n"
            + "5,R,SK Hynix DDR4-19200 16G,240000,1\n"
            + "6,P,Noname 800W,80000,3\n"
            + "7,C,Intel i7-8700K,330000,1\n",
        readFile(stockFile)
    );

    // check tx
    assertEquals(txPrevContent
            + (lastId + 1) + ",I,1,300000,2,600000\n"
            + (lastId + 2) + ",I,7,330000,2,660000\n"
            + (lastId + 3) + ",I,2,190000,2,380000\n"
            + (lastId + 4) + ",S,7,330000,1,330000\n"
            + (lastId + 5) + ",S,3,800000,6,4800000\n"
            + (lastId + 6) + ",E,6,80000,3,240000\n",
        readFile(txFile)
    );

    assertEquals(
        "The part became cheap.\n"
            + "The part partially exchanged.\n",
        outContent.toString());
  }

  @Test
  void overSellTest() throws IOException {
    File stockFile = new File(Constants.STOCK_PATH);
    File inputFile = new File(Constants.INPUT_PATH);
    File txFile = new File(Constants.TX_PATH);
    PrintStream stockOut = new PrintStream(stockFile);
    PrintStream inputOut = new PrintStream(inputFile);
    String txPrevContent = readFile(txFile);
    int lastId = getLastIdOfTxContent(txPrevContent);

    // write to input file
    inputOut.print("I,C,Intel i7-7700K,300000,2\n"
        + "I,C,AMD Ryzen 7 1700,190000,2\n"
        + "S,C,Intel i7-7700K,5\n"
        + "I,C,AMD Ryzen 7 1700,190000,2\n");
    inputOut.close();

    // write to stock file
    stockOut.print("1,C,Intel i7-7700K,300000,1\n"
        + "2,C,AMD Ryzen 7 1700,200000,3\n");
    stockOut.close();

    // run warehouse
    Warehouse.main(new String[]{});

    // check stock
    assertEquals("1,C,Intel i7-7700K,300000,3\n"
            + "2,C,AMD Ryzen 7 1700,190000,5\n",
        readFile(stockFile)
    );

    // check tx
    assertEquals(txPrevContent
            + (lastId + 1) + ",I,1,300000,2,600000\n"
            + (lastId + 2) + ",I,2,190000,2,380000\n",
        readFile(txFile)
    );

    assertEquals("The part became cheap.\n",
        outContent.toString());
  }

  @Test
  void notExistSellTest() throws IOException {
    File stockFile = new File(Constants.STOCK_PATH);
    File inputFile = new File(Constants.INPUT_PATH);
    File txFile = new File(Constants.TX_PATH);
    PrintStream stockOut = new PrintStream(stockFile);
    PrintStream inputOut = new PrintStream(inputFile);
    String txPrevContent = readFile(txFile);
    int lastId = getLastIdOfTxContent(txPrevContent);

    // write to input file
    inputOut.print("I,C,Intel i7-7700K,300000,2\n"
        + "I,C,AMD Ryzen 7 1700,190000,2\n"
        + "S,C,Intel i7-8700K,1\n"
        + "I,C,AMD Ryzen 7 1700,190000,2\n");
    inputOut.close();

    // write to stock file
    stockOut.print("1,C,Intel i7-7700K,300000,1\n"
        + "2,C,AMD Ryzen 7 1700,200000,3\n");
    stockOut.close();

    // run warehouse
    Warehouse.main(new String[]{});

    // check stock
    assertEquals("1,C,Intel i7-7700K,300000,3\n"
            + "2,C,AMD Ryzen 7 1700,190000,5\n",
        readFile(stockFile)
    );

    // check tx
    assertEquals(txPrevContent
            + (lastId + 1) + ",I,1,300000,2,600000\n"
            + (lastId + 2) + ",I,2,190000,2,380000\n",
        readFile(txFile)
    );

    assertEquals("The part became cheap.\n",
        outContent.toString());
  }

  @Test
  void notExistExchangeTest() throws IOException {
    File stockFile = new File(Constants.STOCK_PATH);
    File inputFile = new File(Constants.INPUT_PATH);
    File txFile = new File(Constants.TX_PATH);
    PrintStream stockOut = new PrintStream(stockFile);
    PrintStream inputOut = new PrintStream(inputFile);
    String txPrevContent = readFile(txFile);
    int lastId = getLastIdOfTxContent(txPrevContent);

    // write to input file
    inputOut.print("I,C,Intel i7-7700K,300000,2\n"
        + "I,C,AMD Ryzen 7 1700,190000,2\n"
        + "E,C,Intel i7-8700K,1\n"
        + "I,C,AMD Ryzen 7 1700,190000,2\n");
    inputOut.close();

    // write to stock file
    stockOut.print("1,C,Intel i7-7700K,300000,1\n"
        + "2,C,AMD Ryzen 7 1700,180000,3\n");
    stockOut.close();

    // run warehouse
    Warehouse.main(new String[]{});

    // check stock
    assertEquals("1,C,Intel i7-7700K,300000,3\n"
            + "2,C,AMD Ryzen 7 1700,190000,5\n",
        readFile(stockFile)
    );

    // check tx
    assertEquals(txPrevContent
            + (lastId + 1) + ",I,1,300000,2,600000\n"
            + (lastId + 2) + ",I,2,190000,2,380000\n",
        readFile(txFile)
    );

    assertEquals("The part became expensive.\n",
        outContent.toString());
  }

  @AfterAll
  static void restoreFiles() throws IOException {
    File stockFile = new File(Constants.STOCK_PATH);
    File inputFile = new File(Constants.INPUT_PATH);
    File txFile = new File(Constants.TX_PATH);
    PrintStream stockOut = new PrintStream(stockFile);
    PrintStream inputOut = new PrintStream(inputFile);
    String txPrevContent = readFile(txFile);
    int lastId = getLastIdOfTxContent(txPrevContent);

    // write to input file
    inputOut.print("I,C,Intel i7-7700K,300000,2\n"
        + "I,C,Intel i7-8700K,330000,2\n"
        + "I,C,AMD Ryzen 7 1700,190000,2\n"
        + "S,C,Intel i7-8700K,1\n"
        + "S,G,NVIDIA GTX1070Ti,6\n"
        + "E,P,Noname 800W,5\n");
    inputOut.close();

    // write to stock file
    stockOut.print("1,C,Intel i7-7700K,300000,1\n"
        + "2,C,AMD Ryzen 7 1700,200000,3\n"
        + "3,G,NVIDIA GTX1070Ti,800000,10\n"
        + "4,R,Samsung DDR4-17000 16G,200000,0\n"
        + "5,R,SK Hynix DDR4-19200 16G,240000,1\n"
        + "6,P,Noname 800W,80000,3\n");
    stockOut.close();
  }
}