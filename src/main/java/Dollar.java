import java.security.InvalidParameterException;
import java.util.Scanner;

public class Dollar {

  private static final char DOLLAR_SIGN = '$';
  private static final char AT = '@';
  private static final char SPACE = ' ';

  private static boolean isEven(int i) {
    return (i % 2) == 0;
  }

  private static void printChars(char c, int count) {
    if (count > 0) {
      System.out.print(c);
      printChars(c, count - 1);
    }
  }

  private static void println() {
    System.out.println();
  }

  private static void println(String s) {
    System.out.println(s);
  }

  private static void printLine(int count, int maxLength, boolean isHollow) {
    int halfSpaceSize = (maxLength - count) / 2;
    if (isHollow) {
      printChars(SPACE, halfSpaceSize);
      if (count == 1) {
        printChars(DOLLAR_SIGN, 1);
        println();
      } else {
        printChars(DOLLAR_SIGN, 1);
        printChars(SPACE, count - 2);
        printChars(DOLLAR_SIGN, 1);
        println();
      }
    } else {
      printChars(SPACE, halfSpaceSize);
      printChars(DOLLAR_SIGN, count);
      println();
    }
  }

  private static int getStartCount(boolean isMaxLengthEven) {
    int currCount;
    if (isMaxLengthEven) {
      currCount = 2;
    } else {
      currCount = 1;
    }
    return currCount;
  }

  private static int getMiddleSize(int currCount, int maxLength, boolean isMaxLengthEven) {
    int middleSize = currCount;
    if (isMaxLengthEven) {
      int halfMaxLength = maxLength / 2;
      while (middleSize >= halfMaxLength) {
        middleSize -= 4;
      }
      middleSize += 4;
    } else {
      double halfMaxLength = maxLength * 1.0 / 2;
      while (middleSize >= halfMaxLength) {
        middleSize -= 4;
      }
      middleSize += 4;
    }
    if (middleSize == currCount) {
      middleSize -= 4;
    }
    if (maxLength == 1 || maxLength == 2) {
      middleSize = maxLength;
    }
    return middleSize;
  }

  private static int increasingToMax(int currCount, int maxLength, boolean isHollow) {
    while (currCount < maxLength) {
      printLine(currCount, maxLength, isHollow);
      currCount += 4;
    }

    return currCount;
  }

  private static void mainByType(int maxLength, boolean isHollow) {

//    set starting dollar by isEven
    boolean isMaxLengthEven = isEven(maxLength);
    int currCount = getStartCount(isMaxLengthEven);

//    1. increasing to max
    currCount = increasingToMax(currCount, maxLength, isHollow);

//    2. necessary. first max.
    printLine(maxLength, maxLength, isHollow);

//    get middle size
    int middleSize = getMiddleSize(currCount, maxLength, isMaxLengthEven);

//    3. decreasing to middleSize.
    currCount -= 4;
    while (currCount > middleSize) {
      printLine(currCount, maxLength, isHollow);
      currCount -= 4;
    }

//    4. necessary. middleSize.
    currCount = middleSize;
    if (isHollow) {
      if (isMaxLengthEven) {
        int halfLength = maxLength / 2;
        if (currCount <= halfLength) {
          int halfSpaceSize = (maxLength - currCount) / 2;
          printChars(SPACE, halfSpaceSize - 1);
          printChars(AT, 1);
          printChars(DOLLAR_SIGN, 1);
          printChars(SPACE, currCount - 2);
          printChars(DOLLAR_SIGN, 1);
          printChars(AT, 1);
          println();
        } else {
          printLine(currCount, maxLength, isHollow);
        }
      } else {
        double halfLength = maxLength * 1.0 / 2;
        if (currCount <= halfLength) {
          int halfSpaceSize = (maxLength - currCount) / 2;
          printChars(SPACE, halfSpaceSize - 1);
          if (currCount == 1) {
            printChars(AT, 1);
            printChars(DOLLAR_SIGN, 1);
            printChars(AT, 1);
            println();
          } else {
            printChars(AT, 1);
            printChars(DOLLAR_SIGN, 1);
            printChars(SPACE, currCount - 2);
            printChars(DOLLAR_SIGN, 1);
            printChars(AT, 1);
            println();
          }
        } else {
          printLine(currCount, maxLength, isHollow);
        }

      }
    } else {
      printLine(middleSize, maxLength, isHollow);
    }

//    5. increasing to max.
    if (!(maxLength == 1 || maxLength == 2)) {
      currCount = increasingToMax(currCount + 4, maxLength, isHollow);
    }

//    6. necessary. second max.
    printLine(maxLength, maxLength, isHollow);

//    7. decreasing to bottom.
    currCount -= 4;
    while (currCount > 0) {
      printLine(currCount, maxLength, isHollow);
      currCount -= 4;
    }
  }

  static void mainHelper(int maxLength) {
    // not in spec. but anyway.
    if (maxLength < 1) {
      throw new InvalidParameterException("Invalid maximum length.");
    }

    println("(a)");
    mainByType(maxLength, false);
    println("(b)");
    mainByType(maxLength, true);

  }

  public static void main(String[] args) {
    System.out.print("Type the maximum length: ");
    Scanner sc = new Scanner(System.in);
    int maxLength = sc.nextInt();

    mainHelper(maxLength);
  }
}