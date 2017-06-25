package projecteuler;

import java.util.ArrayList;

public class Problem30 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();

    ArrayList<Integer> answers = new ArrayList<Integer>();
    int power = 5;
    
    int upperLimit = 0;
    int maxSingle = power(9, power);
    boolean isPossible = true;
    int maxNumberOfDigits = 1;
    while(isPossible){
      if(power(10,maxNumberOfDigits) <= maxSingle*maxNumberOfDigits){
        maxNumberOfDigits++;
      }
      else{
        isPossible = false;
        upperLimit = maxSingle*maxNumberOfDigits;
      }
    }

    for (int i = 2; i <= upperLimit; i++) {
      String num = String.valueOf(i);
      int sumOfFifthPower = 0;
      for (char c : num.toCharArray()) {
        sumOfFifthPower = sumOfFifthPower
            + power(Integer.valueOf(String.valueOf(c)), power);
      }
      if (sumOfFifthPower == i) {
        answers.add(i);
      }
    }

    int sum = 0;
    for (int i : answers) {
      sum += i;
    }

    System.out
        .println("The sum of all the numbers that can be written as the sum of fifth powers of their digits is "
            + sum);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");

  }

  static int power(int num, int exp) {
    int result = num;
    for (int i = 1; i < exp; i++) {
      result = result * num;
    }
    return result;
  }

}
