package projecteuler_1to50;

import java.util.ArrayList;

public class Problem31 {

  public static int numberOfCoinCominations = 0;

  public static void main(String[] args) {

    long startTime = System.nanoTime();

    ArrayList<Integer> coins = new ArrayList<Integer>();
    coins.add(200);
    coins.add(100);
    coins.add(50);
    coins.add(20);
    coins.add(10);
    coins.add(5);
    coins.add(2);
    coins.add(1);

    recursivelyGenerateCombinations(200, coins);

    System.out.println("The number of different ways that £2 can be made using "
        + "any number of coins is "+ numberOfCoinCominations);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

  @SuppressWarnings("unchecked")
  public static void recursivelyGenerateCombinations(int target,
      ArrayList<Integer> availableCoins) {
    if (target < 0) {
      // Terminate branch as solution is invalid
    } else {
      for (int i = 0; i < availableCoins.size(); i++) {
        int newTarget = target - availableCoins.get(i);
        if (newTarget == 0) {
          numberOfCoinCominations++;
        } else {
          ArrayList<Integer> newCoins = (ArrayList<Integer>) availableCoins
              .clone();
          for (int j = 0; j < i; j++) {
            newCoins.remove(0);
          }
          if (newCoins.size() == 1) {
            numberOfCoinCominations++;
          } else {
            recursivelyGenerateCombinations(newTarget, newCoins);
          }
        }
      }
    }
  }

}
