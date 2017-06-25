package projecteuler_1to50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Problem49 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    ArrayList<Integer> primes = new ArrayList<>();
    ArrayList<int[]> permutationTriplets = new ArrayList<>();

    for (int i = 1000; i <= 9999; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }

    for (int i = 0; i < primes.size(); i++) {
      int p = primes.get(i);
      HashSet<Integer> permutations = new HashSet<>();
      String pString = String.valueOf(p);
      int[] digits = new int[pString.length()];
      for (int j = 0; j < pString.length(); j++) {
        digits[j] = Character.getNumericValue(pString.charAt(j));
      }

      class innerPermutations {
        {
          recursivePermutation(digits, 0);
        }

        public void recursivePermutation(int[] digits, int startPos) {
          if (startPos == digits.length) {
            String val = "";
            for (int i : digits) {
              val += i;
            }
            if (String.valueOf(Integer.parseInt(val)).length() == 4) {
              permutations.add(Integer.parseInt(val));
            }
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
      new innerPermutations();
      primes.removeAll(permutations);
      ArrayList<Integer> primePermutations = new ArrayList<>();
      for (int perm : permutations) {
        if (isPrime(perm)) {
          primePermutations.add(perm);
        }
      }

      if (primePermutations.size() < 3) {
        continue;
      }

      ArrayList<Integer> sorted = new ArrayList<>();
      sorted.addAll(primePermutations);
      Collections.sort(sorted);

      for (int l = 0; l < sorted.size() - 2; l++) {
        for (int m = (l + 1); m < sorted.size() - 1; m++) {
          int diff = sorted.get(m) - sorted.get(l);
          for (int n = (m + 1); n < sorted.size(); n++) {
            if (diff == sorted.get(n) - sorted.get(m)) {
              permutationTriplets.add(new int[] { sorted.get(l), sorted.get(m),
                  sorted.get(n) });
            }
          }
        }
      }
    }

    System.out
        .println("The 4-digit sequences exhibiting the behaviour required are:");
    for (int[] r : permutationTriplets) {
      for (int result : r) {
        System.out.print(result);
      }
      System.out.println(" ");
    }

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

}
