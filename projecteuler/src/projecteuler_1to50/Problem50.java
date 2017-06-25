package projecteuler_1to50;

import java.util.ArrayList;

public class Problem50 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    int upperLimit = 1_000_000;
    ArrayList<Integer> primes = new ArrayList<>();
    primes.add(2);

    for (int i = 3; i < upperLimit; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }

    int maxSum = 0;
    int p = 0;
    while (maxSum < upperLimit) {
      maxSum += primes.get(p);
      p++;
    }

    int currentPrime = 0;
    int numConsecutive = p - 1;

    WHILE: while (numConsecutive > 2) {
      for (int i = 0; i < primes.size() - numConsecutive; i++) {
        int sum = 0;
        for (int j = i; j < i + numConsecutive; j++) {
          sum += primes.get(j);
        }
        if (isPrime(sum) && sum < upperLimit) {
          currentPrime = sum;
          break WHILE;
        }
      }
      numConsecutive--;
    }

    System.out.println("The prime below " + upperLimit + " that can be written as "
        + "the sum of the most consecutive primes is " + currentPrime);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000 + "ms");
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
