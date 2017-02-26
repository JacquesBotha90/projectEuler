package projecteuler;

import java.util.ArrayList;
import java.util.Collections;

public class Problem38 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    ArrayList<Integer> validAnswers = new ArrayList<Integer>();

    for (int i = 1; i <= 9999; i++) {
      ArrayList<Integer> products = new ArrayList<Integer>();
      products.add(i);
      int digits = String.valueOf(i).length();
      int j = 2;
      while (digits < 9) {
        int p = i * j;
        products.add(p);
        digits += String.valueOf(p).length();
      }
      if (digits != 9) {
        continue;
      }
      if (isPandigital(products)) {
        validAnswers.add(productsValue(products));
      }
    }

    System.out.println("The largest 1 to 9 pandigital 9-digit number that "
        + "can be formed as the concatenated product of an integer with "
        + "(1,2, ... , n) where n > 1 is " + Collections.max(validAnswers));

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

  public static boolean isPandigital(ArrayList<Integer> products) {
    boolean isPandigital = true;

    ArrayList<String> digits = new ArrayList<String>();
    for (int num : products) {
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

  public static int productsValue(ArrayList<Integer> products) {
    String digits = "";
    for (int num : products) {
      String[] test = String.valueOf(num).split("");
      for (String s : test) {
        digits += s;
      }
    }
    return Integer.parseInt(digits);
  }

}
