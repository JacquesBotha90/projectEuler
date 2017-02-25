package projecteuler;

import java.util.ArrayList;
import java.util.Collections;

public class Problem36 {

  public static ArrayList<Integer> bList = new ArrayList<>();

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    int num = 1;
    int highestValue = 1_000_000;
    while (num < highestValue) {
      bList.add(num);
      num *= 2;
    }
    Collections.reverse(bList);

    int sum = 0;

    for (int i = 1; i <= highestValue; i += 2) {
      if (isPalindrome(String.valueOf(i))
          && isPalindrome(String.valueOf(convertToBinary(i)))) {
        sum += i;
      }
    }

    System.out.println("The sum of all numbers less than " + highestValue
        + " which are palindromic in base 10 and base 2 is " + sum);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

  public static StringBuilder convertToBinary(int num) {
    StringBuilder binary = new StringBuilder("");
    int value = num;

    for (int b : bList) {
      if (b <= value) {
        value -= b;
        binary.append(1);
      } else {
        binary.append(0);
      }
    }
    binary.delete(0, binary.indexOf("1"));

    return binary;
  }

  public static boolean isPalindrome(String value) {

    boolean isPalindrome = true;
    for (int i = 0; i < value.length() / 2; i++) {
      if (value.charAt(i) != value.charAt(value.length() - 1 - i)) {
        isPalindrome = false;
        break;
      }
    }
    return isPalindrome;
  }
}
