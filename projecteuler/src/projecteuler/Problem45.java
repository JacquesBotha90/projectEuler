package projecteuler;

public class Problem45 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    long currentPent = 1;
    int p = 2;
    long currentHex = 1;
    int h = 2;
    int numFound = 0;

    while (numFound < 2) {
      currentHex = hexagonal(h++);
      while (currentPent < currentHex) {
        currentPent = pentagonal(p++);
      }
      if (currentHex == currentPent) {
        numFound++;
      }
    }

    System.out.println("The second smallest number that is triangular, "
        + "pentagonal and hexagonal is " + currentHex);

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");
  }

  public static long pentagonal(long num) {
    return num * (3 * num - 1) / 2;
  }

  public static long hexagonal(long num) {
    return num * (2 * num - 1);
  }

}
