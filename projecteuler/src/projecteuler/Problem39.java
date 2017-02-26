package projecteuler;

import java.util.ArrayList;
import java.util.Collections;

public class Problem39 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    ArrayList<Integer> pValues = new ArrayList<Integer>();
    ArrayList<Integer> solutions = new ArrayList<Integer>();

    for (int p = 12; p <= 1000; p++) {
      int numSolutions = 0;
      for (int a = 1; a <= p / 2; a++) {
        for (int b = a; b < p; b++) {
          double result = a + b + Math.sqrt(a * a + b * b);
          if (result == Math.floor(result) && (int) result == p) {
            numSolutions++;
          }
        }
      }
      pValues.add(p);
      solutions.add(numSolutions);
    }

    System.out.println("The number of solutions maximised for p = "
        + pValues.get(solutions.indexOf(Collections.max(solutions))));

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }
}
