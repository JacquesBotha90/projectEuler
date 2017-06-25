package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem33 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();

    ArrayList<int[]> validAnswers = new ArrayList<int[]>();

    for (int denominator = 12; denominator <= 99; denominator++) {
      if (denominator % 10 != 0) {
        for (int numerator = 11; numerator < denominator; numerator++) {
          for (int num = 1; num <= 9; num++) {
            if (String.valueOf(numerator).contains(String.valueOf(num))
                && String.valueOf(denominator).contains(String.valueOf(num))) {
              ArrayList<String> numerString = new ArrayList<String>(
                  Arrays.asList(String.valueOf(numerator).split("")));
              numerString.remove(String.valueOf(num));
              ArrayList<String> denomString = new ArrayList<String>(
                  Arrays.asList(String.valueOf(denominator).split("")));
              denomString.remove(String.valueOf(num));
              if (((double) numerator / denominator) == Double
                  .valueOf(numerString.get(0))
                  / Double.valueOf(denomString.get(0))) {
                validAnswers.add(new int[] { numerator, denominator });
              }
            }
          }
        }
      }
    }

    int numeratorProduct = 1;
    int denominatorProduct = 1;
    for (int[] answer : validAnswers) {
      numeratorProduct *= answer[0];
      denominatorProduct *= answer[1];
    }

    int[] result = findLowestCommonTerms(numeratorProduct, denominatorProduct);

    System.out
        .println("The product of the four digit cancelling fractions given in its lowest common terms is "
            + result[0] + "/" + result[1]);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

  static int[] findLowestCommonTerms(int num, int denom) {
    for (int i = num; i > 1; i--) {
      if ((num % i == 0) && (denom % i == 0)) {
        num = num / i;
        denom = denom / i;
        break;
      }
    }
    return new int[] { num, denom };
  }

}
