package projecteuler_1to50;

import java.util.ArrayList;

public class Problem35 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();

    ArrayList<Integer> circularPrimes = new ArrayList<Integer>();
    circularPrimes.add(2);
    int upperlimit = 1_000_000;

    for (int i = 3; i <= upperlimit; i += 2) {
      if (isPrime(i)) {
        boolean isCircular = true;
        int[] rotations = getRotations(i);
        for (int r : rotations) {
          if (!isPrime(r)) {
            isCircular = false;
            break;
          }
        }
        if (isCircular) {
          circularPrimes.add(i);
        }
      }
    }

    System.out.println("The number of circular primes below " + upperlimit
        + " is " + circularPrimes.size());

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");

  }

  public static int[] getRotations(int num) {
    int numRotations = String.valueOf(num).length();
    int[] rotations = new int[numRotations];

    for (int i = 0; i < numRotations; i++) {
      String[] digits = String.valueOf(num).split("");
      String[] rotated = new String[numRotations];
      for (int j = 0; j < numRotations; j++) {
        if (i + j >= numRotations) {
          rotated[i + j - numRotations] = digits[j];
        } else {
          rotated[i + j] = digits[j];
        }
      }
      String rotatedNumber = "";
      for (String digit : rotated) {
        rotatedNumber += digit;
      }
      rotations[i] = Integer.parseInt(rotatedNumber);
    }

    return rotations;
  }

  public static boolean isPrime(int num) {
    if (num <= 0) {
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
