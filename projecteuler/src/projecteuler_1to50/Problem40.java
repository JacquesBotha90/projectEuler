package projecteuler_1to50;

public class Problem40 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();

    StringBuilder irrationalFraction = new StringBuilder();
    int num = 0;

    while (irrationalFraction.length() <= 1000000) {
      irrationalFraction.append(num);
      num++;
    }

    int i = 1;
    int product = 1;
    while (i <= 1000000) {
      product *= Character.getNumericValue(irrationalFraction.charAt(i));
      i *= 10;
    }

    System.out
        .println("The value of d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000 is "
            + product);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

}
