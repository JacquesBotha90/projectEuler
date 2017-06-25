package projecteuler_1to50;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem32 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();

    ArrayList<int[]> allProducts = new ArrayList<int[]>();
    HashSet<Integer> foundSolutions = new HashSet<Integer>();
    // Products of character size [1]*[4]=[4]
    for (int i = 1; i <= 9; i++) {
      for (int j = 1000; j <= 9999; j++) {
        int product = i * j;
        if (String.valueOf(product).length() == 4) {
          allProducts.add(new int[] { i, j, product });
        } else {
          break;
        }
      }
    }
    // Products of character size [2]*[3]=[4]
    for (int i = 10; i <= 99; i++) {
      for (int j = 100; j <= 999; j++) {
        int product = i * j;
        if (String.valueOf(product).length() == 4) {
          allProducts.add(new int[] { i, j, product });
        } else {
          break;
        }
      }
    }
    int sum = 0;
    for (int[] nums : allProducts) {
      if (isPandigital(nums) && !foundSolutions.contains(nums[2])) {
        foundSolutions.add(nums[2]);
        sum += nums[2];
      }
    }
    System.out
        .println("The sum of all products whose multiplicand/multiplier/product "
            + "identity can be written as a 1 through 9 pandigital is " + sum);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

  public static boolean isPandigital(int[] product) {
    boolean isPandigital = true;

    ArrayList<String> digits = new ArrayList<String>();
    for (int num : product) {
      String[] test = String.valueOf(num).split("");
      for (String s : test) {
        digits.add(s);
      }
    }
    for (int i = 1; i <= 9; i++) {
      if (!digits.contains(String.valueOf(i))) {
        isPandigital = false;
        break;
      }
    }

    return isPandigital;
  }

}
