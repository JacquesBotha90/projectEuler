package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem47 {

  public static ArrayList<Integer> primes;

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    primes = new ArrayList<>();
    primes.add(2);

    int targetDistinct = 4;
    ArrayList<Integer> currentDistinctPrimes = new ArrayList<>();
    int num = 3;
    int currentConsecutive = 0;

    while (currentConsecutive < targetDistinct) {
      if (isPrime(num)) {
        primes.add(num);
        currentDistinctPrimes.clear();
        currentConsecutive = 0;
      } else {
        HashSet<Integer> primefactors = primeFactorization(num);
        if (primefactors.size() == targetDistinct) {
          boolean isDistinct = true;
          for (int i : primefactors) {
            if (currentDistinctPrimes.contains(i)) {
              isDistinct = false;
              currentDistinctPrimes.clear();
              currentConsecutive = 0;
              break;
            }
          }
          if (isDistinct) {
            currentConsecutive++;
            currentDistinctPrimes.addAll(primefactors);
          }
        } else {
          currentDistinctPrimes.clear();
          currentConsecutive = 0;
        }
      }
      num++;
    }

    System.out
        .println("The first number of the first " + targetDistinct + " four "
            + "consecutive integers to have " + targetDistinct
            + " four distinct prime " + "factors each is "
            + (num - targetDistinct));

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

  public static HashSet<Integer> primeFactorization(int num) {
    HashSet<Integer> primeFactors = new HashSet<>();

    int result = num;
    for (int p : primes) {
      int factor = 1;
      while (result % p == 0) {
        result = result / p;
        factor *= p;
      }
      if (factor != 1) {
        primeFactors.add(factor);
      }
    }
    if (result == 1) {
      return primeFactors;
    }
    return null;
  }

}
