package projecteuler_1to50;

import java.util.ArrayList;

public class Problem44 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    ArrayList<Integer> pentagonalNumbers = new ArrayList<>();
    ArrayList<int[]> validAnswers = new ArrayList<>();

    for (int i = 1; i <= 2500; i++) {
      pentagonalNumbers.add(correspondingPentagonal(i));
    }

    OUTERLOOP: for (int i = 0; i < pentagonalNumbers.size(); i++) {
      for (int j = 0; j < i; j++) {
        int a = pentagonalNumbers.get(i);
        int b = pentagonalNumbers.get(j);
        if (pentagonalNumbers.contains(a - b)
            && pentagonalNumbers.contains(a + b)) {
          validAnswers.add(new int[] { a, b, (a - b) });
          break OUTERLOOP;
        }
      }
    }

    System.out
        .println("The smallest difference for two valid pentagonal nunbers is "
            + validAnswers.get(0)[2]);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

  public static int correspondingPentagonal(int num) {
    return num * (3 * num - 1) / 2;
  }

}
