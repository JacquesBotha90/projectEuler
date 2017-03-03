package projecteuler;

import java.math.BigInteger;

public class Problem48 {

  public static void main(String[] args) {

    BigInteger result = new BigInteger("0");

    int limit = 1000;

    for (int i = 1; i <= limit; i++) {
      result = result.add(new BigInteger(String.valueOf(i)).pow(i));
    }

    System.out.println("The last ten digits of the series, 1^1 + 2^2 + 3^3 "
        + "+ ... + 1000^1000 is "
        + result.toString().substring(result.toString().length() - 10));

  }

}
