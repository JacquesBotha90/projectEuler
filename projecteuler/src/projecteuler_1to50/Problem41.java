package projecteuler_1to50;

import java.util.ArrayList;
import java.util.Collections;

public class Problem41 {

  public static ArrayList<Integer> pandigitalNumbers = new ArrayList<>();

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    ArrayList<Integer> primePandigitalNumbers = new ArrayList<>();

    for (int i = 1; i <= 9; i++) {
      int[] digits = new int[i];
      for (int j = 0; j < i; j++) {
        digits[j] = j + 1;
      }
      recursivePermutation(digits, 0);
    }

    for (int i : pandigitalNumbers) {
      if (isPrime(i)) {
        primePandigitalNumbers.add(i);
      }
    }

    System.out.println("The largest n-digit pandigital prime that exists is "
        + Collections.max(primePandigitalNumbers));

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

  public static boolean isPrime(int num) {
    if (num <= 1) {
      return false;
    }
    boolean isPrime = true;
    for (long i = 2l; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }

  public static void recursivePermutation(int[] digits, int startPos) {
    if (startPos == digits.length) {
      String val = "";
      for (int i : digits) {
        val += i;
      }
      pandigitalNumbers.add(Integer.parseInt(val));
    } else {
      for (int i = startPos; i < digits.length; i++) {
        int[] clone = digits.clone();
        int temp = clone[i];
        clone[i] = clone[startPos];
        clone[startPos] = temp;
        recursivePermutation(clone, startPos + 1);
      }

    }
  }
}
