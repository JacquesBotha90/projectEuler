package projecteuler_1to50;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem43 {

  public static ArrayList<BigInteger> pandigitalNumbers = new ArrayList<BigInteger>();

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    ArrayList<Integer> primes = new ArrayList<>();
    ArrayList<BigInteger> validAnswers = new ArrayList<BigInteger>();
    primes.add(1);
    primes.add(2);

    int num = 3;
    while (primes.size() < 8) {
      if (isPrime(num)) {
        primes.add(num);
      }
      num++;
    }

    int[] digits = new int[10];
    for (int i = 0; i <= 9; i++) {
      digits[i] = i;
    }
    recursivePermutation(digits, 0);

    for (BigInteger pandigital : pandigitalNumbers) {
      if (pandigital.toString().length() < 10) {
        continue;
      }
      boolean test = true;
      for (int i = 1; i < primes.size(); i++) {
        String product = "" + intAt(i, pandigital) + intAt(i + 1, pandigital)
            + intAt(i + 2, pandigital);

        if (Integer.parseInt(product) % primes.get(i) != 0) {
          test = false;
          break;
        }
      }
      if (test) {
        validAnswers.add(pandigital);
      }
    }

    BigInteger sum = new BigInteger("0");
    for (BigInteger answer : validAnswers) {
      sum = sum.add(new BigInteger(String.valueOf(answer)));
    }

    System.out.println("The sum of all 0 to 9 pandigital numbers with "
        + "substring divisibility is " + sum);

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
      pandigitalNumbers.add(new BigInteger(val));
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

  public static int intAt(int position, BigInteger number) {
    String num = String.valueOf(number);
    char digit = num.charAt(position);
    return Character.getNumericValue(digit);
  }

}
