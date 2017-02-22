package projecteuler;

import java.util.ArrayList;

public class Problem34 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();

    ArrayList<Integer> validResult = new ArrayList<Integer>();

    for (int i = 3; i <= 2540160; i++) {
      String[] num = String.valueOf(i).split("");
      int sum = 0;
      for (String digit : num) {
        sum += factorial(Integer.parseInt(digit));
      }
      if (sum == i) {
        validResult.add(i);
      }
    }

    int result = 0;
    for (int num : validResult) {
      result += num;
    }

    System.out.println("Find the sum of all numbers which are equal to the "
        + "sum of the factorial of their digits is " + result);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");

  }

  public static int factorial(int num) {
    int result = 1;
    for (int i = num; i > 1; i--) {
      result *= i;
    }
    return result;
  }

}
