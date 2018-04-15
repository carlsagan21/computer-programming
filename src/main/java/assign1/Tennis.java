package assign1;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Tennis {

  private static final int MALE_SET_COUNT = 3;
  private static final int FEMALE_SET_COUNT = 2;
  private static final int GAME_COUNT = 6;
  private static final int POINT_COUNT = 4;
  private static final int TIE_BREAK_COUNT = 7;

  private static int pointL = 0;
  private static int pointR = 0;
  private static boolean isPointDeuce = false;
  private static int pointDeuceAdvantage = 0; // -2: L win, -1: L, 0: None, 1: R, 2: R win

  private static int gameL = 0;
  private static int gameR = 0;
  private static boolean isTieBreak = false;
  private static int[] gameLResults = new int[MALE_SET_COUNT * 2 - 1];
  private static int[] gameRResults = new int[MALE_SET_COUNT * 2 - 1];
  private static boolean[] gameTieBreaks = new boolean[MALE_SET_COUNT * 2 - 1];
  private static int[] gameLTBPoints = new int[MALE_SET_COUNT * 2 - 1];
  private static int[] gameRTBPoints = new int[MALE_SET_COUNT * 2 - 1];

  private static int setL = 0;
  private static int setR = 0;

  private static void print(String s) {
    System.out.print(s);
  }

  private static void print(int i) {
    System.out.print(i);
  }

  private static void println() {
    System.out.println();
  }

  private static void println(String s) {
    System.out.println(s);
  }

  private static boolean isAustralian(String matchType) {
    return matchType.equals("A");
  }

  private static boolean isFemale(String genderType) {
    return genderType.equals("F");
  }

  private static boolean isLeft(String winner) {
    return winner.equals("L");
  }

  private static int point2Call(int point) {
    if (isTieBreak) {
      return point;
    } else {
      if (point == 0) {
        return 0;
      } else if (point == 1) {
        return 15;
      } else if (point == 2) {
        return 30;
      } else if (point == 3) {
        return 40;
      } else {
        throw new InvalidParameterException("Invalid point.");
      }
    }
  }

  private static int getSets() {
    return setL + setR;
  }

  private static boolean isFirstSet() {
    return setL == 0 && setR == 0;
  }

  private static void resetPointState() {
    pointL = 0;
    pointR = 0;
    isPointDeuce = false;
    pointDeuceAdvantage = 0;
  }

  private static void saveGameResult() {
    int sets = getSets();
    gameLResults[sets] = gameL;
    gameRResults[sets] = gameR;
    if (isTieBreak) {
      gameTieBreaks[sets] = true;
      gameLTBPoints[sets] = pointL;
      gameRTBPoints[sets] = pointR;
    } else {
      gameTieBreaks[sets] = false;
    }
  }

  private static void resetGameState() {
    gameL = 0;
    gameR = 0;
    isTieBreak = false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    print("Type the match (A: Australian Open/U: US Open): ");
    boolean isMatchAustralian = isAustralian(sc.next());
    print("Type the gender (F: Female/M: Male): ");
    boolean isGenderFemale = isFemale(sc.next());

    int SET_COUNT = isGenderFemale ? FEMALE_SET_COUNT : MALE_SET_COUNT;

    if (isMatchAustralian) {
      print("Australian");
    } else {
      print("US");
    }
    print(" Open/");
    if (isGenderFemale) {
      print("Female");
    } else {
      print("Male");
    }
    println(" chosen.");

    boolean isWinLeft;
    int gameWinner; // -1: L won, 0: Not decided, 1: R won
    int setWinner;

    while (true) {

//      print current
      print("Current: ");
//      prev sets
      for (int i = 0; i < getSets(); i++) {
        print(gameLResults[i]);
        print("-");
        print(gameRResults[i]);
        if (gameTieBreaks[i]) {
          print("(");
          print(gameLTBPoints[i]);
          print("-");
          print(gameRTBPoints[i]);
          print(")");
        }

        if (i != getSets() - 1) {
          print(" ");
        }
      }
//      if first or there is point, print current game
      if (isFirstSet() || (gameL != 0 || gameR != 0 || pointL != 0 || pointR != 0)) {
//        if there is no new point, remove space
        if (!isFirstSet()) {
          print(" ");
        }
        print(gameL);
        print("-");
        print(gameR);
      }

//      if there is point, print point. consider deuce.
      if (pointL != 0 || pointR != 0) {
        print("(");
        print(point2Call(pointL));
        if (isPointDeuce && pointDeuceAdvantage == -1) { // L has an advantage.
          print("A");
        }
        print("-");
        print(point2Call(pointR));
        if (isPointDeuce && pointDeuceAdvantage == 1) { // R has an advantage.
          print("A");
        }
        print(")");
      }
      println();

      print("Type the winner (L: Left/R: Right): ");
      isWinLeft = isLeft(sc.next());

      if (isWinLeft) {
        if (isPointDeuce) {
          pointDeuceAdvantage--;
        } else {
          pointL++;
        }
      } else {
        if (isPointDeuce) {
          pointDeuceAdvantage++;
        } else {
          pointR++;
        }
      }

//      set point state and count up game.
      gameWinner = 0;
      if (isTieBreak) {
        if (pointL >= TIE_BREAK_COUNT && pointL >= pointR + 2) {
          gameWinner--;
        } else if (pointR >= TIE_BREAK_COUNT && pointL + 2 <= pointR) {
          gameWinner++;
        }
      } else {
        if (pointL == POINT_COUNT - 1 && pointR == POINT_COUNT - 1) {
//        deuce
          isPointDeuce = true;
          if (pointDeuceAdvantage == -2) { // L won in deuce
            gameWinner--;
          } else if (pointDeuceAdvantage == 2) { // R won in deuce
            gameWinner++;
          }
        } else {
//        not deuce
          if (pointL >= POINT_COUNT) {
            gameWinner--;
          } else if (pointR >= POINT_COUNT) {
            gameWinner++;
          }
        }
      }

      if (gameWinner == -1) {
        gameL++;
      } else if (gameWinner == 1) {
        gameR++;
      }

//      set game state and count up set.
      setWinner = 0;
      if (isMatchAustralian && getSets() == SET_COUNT * 2 - 2) {
//        Advantage set
        if (gameL >= GAME_COUNT && gameL >= gameR + 2) {
          setWinner--;
        } else if (gameR >= GAME_COUNT && gameL + 2 <= gameR) {
          setWinner++;
        }
      } else {
        if (gameL == GAME_COUNT && gameR == GAME_COUNT
            || gameL == GAME_COUNT + 1 && gameR == GAME_COUNT
            || gameL == GAME_COUNT && gameR == GAME_COUNT + 1) {
//        tie break
          isTieBreak = true;
          if (gameL == GAME_COUNT + 1) {
            setWinner--;
          } else if (gameR == GAME_COUNT + 1) {
            setWinner++;
          }
        } else if (gameL >= GAME_COUNT - 1 && gameR >= GAME_COUNT - 1) {
//        game deuce. if isTieBreak true, don't get in here.
          if (gameL == GAME_COUNT + 1) {
            setWinner--;
          } else if (gameR == GAME_COUNT + 1) {
            setWinner++;
          }
        } else {
//        not game deuce
          if (gameL == GAME_COUNT && gameR <= GAME_COUNT - 2) {
            setWinner--;
          } else if (gameR == GAME_COUNT && gameL <= GAME_COUNT - 2) {
            setWinner++;
          }
        }
      }

      if (setWinner == -1) {
        saveGameResult();
        resetGameState();
        setL++;
      } else if (setWinner == 1) {
        saveGameResult();
        resetGameState();
        setR++;
      }

//      reset point after saving game. if we reset point before game, we cannot save tiebreak point state.
      if (gameWinner != 0) {
        resetPointState();
      }

//      end condition according to set
      if (setL == SET_COUNT || setR == SET_COUNT) {
        println("Game finished!");
        return;
      }
    }
  }
}
