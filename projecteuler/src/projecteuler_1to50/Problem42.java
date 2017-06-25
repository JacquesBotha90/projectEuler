package projecteuler_1to50;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem42 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    ArrayList<String> wordsList = new ArrayList<String>();
    ArrayList<Integer> triangleNumbers = new ArrayList<Integer>();
    BufferedReader reader = null;

    try {
      ClassLoader classLoader = Problem42.class.getClassLoader();
      File file = new File(classLoader.getResource("Problem42Words").getFile());
      reader = new BufferedReader(new FileReader(file));
      String text = reader.readLine();
      text = text.replace("\"", "");
      String[] wordsArray = text.split(",");
      for (String w : wordsArray) {
        wordsList.add(w);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (reader != null) {
          reader.close();
        }
      } catch (IOException e) {
      }
    }

    for (int i = 1; i < 100; i++) {
      triangleNumbers.add(correspondingTriangleNumber(i));
    }

    int numTriangleNumbers = 0;

    for (String n : wordsList) {
      int alphaValue = 0;
      for (char c : n.toCharArray()) {
        alphaValue = alphaValue + alphaValue(c);
      }
      if (triangleNumbers.contains(alphaValue)) {
        numTriangleNumbers++;
      }
    }

    System.out.println("The number of triangle words in the list is "
        + numTriangleNumbers);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");

  }

  public static int correspondingTriangleNumber(int num) {
    return num * (num + 1) / 2;
  }

  public static int alphaValue(char c) {
    switch (c) {
    case 'A':
      return 1;
    case 'B':
      return 2;
    case 'C':
      return 3;
    case 'D':
      return 4;
    case 'E':
      return 5;
    case 'F':
      return 6;
    case 'G':
      return 7;
    case 'H':
      return 8;
    case 'I':
      return 9;
    case 'J':
      return 10;
    case 'K':
      return 11;
    case 'L':
      return 12;
    case 'M':
      return 13;
    case 'N':
      return 14;
    case 'O':
      return 15;
    case 'P':
      return 16;
    case 'Q':
      return 17;
    case 'R':
      return 18;
    case 'S':
      return 19;
    case 'T':
      return 20;
    case 'U':
      return 21;
    case 'V':
      return 22;
    case 'W':
      return 23;
    case 'X':
      return 24;
    case 'Y':
      return 25;
    case 'Z':
      return 26;
    default:
      return 0;
    }
  }

}
