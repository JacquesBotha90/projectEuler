package projecteuler_1to50;

import java.util.ArrayList;
import java.util.Collections;

public class Problem46 {

  public static ArrayList<Integer> primes;
  public static ArrayList<Integer> squareNums;

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    primes = new ArrayList<>();
    squareNums = new ArrayList<>();
    squareNums.add(2);

    int num = 3;
    boolean found = false;
    int squarenum = 2;
    int result = 0;

    while (!found) {
      while (Collections.max(squareNums) < num) {
        squareNums.add(2 * squarenum * squarenum);
        squarenum++;
      }
      if (isPrime(num)) {
        primes.add(num);
      } else if (!passGoldbachConjecture(num)) {
        found = true;
        result = num;
      }
      num += 2;
    }

    System.out.println("The smallest odd composite that cannot be written "
        + "as the sum of a prime and twice a square is " + result);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

  public static boolean passGoldbachConjecture(int num) {
    for (int prime : primes) {
      for (int squarenum : squareNums) {
        if (prime + squarenum == num) {
          return true;
        }
      }
    }
    return false;
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

}
