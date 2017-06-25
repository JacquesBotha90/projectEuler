package projecteuler_1to50;

public class Problem37 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    int i = 11;
    int numFound = 0;
    int sum = 0;

    OUTSIDE: while (numFound < 11) {
      int num = i;
      i++;
      if (isPrime(num)) {
        // Check truncate right
        while (String.valueOf(num).length() > 1) {
          num = truncateRight(num);
          if (!isPrime(num)) {
            continue OUTSIDE;
          }
        }
        num = i;
        // Check truncate left
        while (String.valueOf(num).length() > 1) {
          num = truncateLeft(num);
          if (!isPrime(num)) {
            continue OUTSIDE;
          }
        }
        numFound++;
        sum += i - 1;
      }
    }

    System.out.println("The sum of the only eleven primes that are "
        + "both truncatable from left to right and right to left is " + sum);

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

  public static int truncateRight(int num) {
    StringBuilder sValue = new StringBuilder(String.valueOf(num));
    sValue.delete(0, 1);
    return Integer.parseInt(sValue.toString());
  }

  public static int truncateLeft(int num) {
    StringBuilder sValue = new StringBuilder(String.valueOf(num));
    sValue.delete(sValue.length() - 1, sValue.length());
    return Integer.parseInt(sValue.toString());
  }
}
