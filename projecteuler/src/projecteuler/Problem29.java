package projecteuler;

import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    HashSet<BigInteger> distinctTerms = new HashSet<BigInteger>();
    int aLower = 2;
    int aUpper = 100;
    int bLower = 2;
    int bUpper = 100;
    
    for(int a = aLower; a <= aUpper; a++){
      for(int b = bLower; b <= bUpper; b++){
        distinctTerms.add(power(a, b));
      }
    }
    
    System.out.println("The number of distinct terms in the sequence generated by "
        + "a^b for "+aLower+" <= a <= "+aUpper+" and "+bLower+" <= b <= "+aUpper+
        " is "+distinctTerms.size());
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms"); 

  }
  
  static BigInteger power(int num, int exp){    
    BigInteger result = new BigInteger(String.valueOf(num));    
    for(int i = 1; i < exp; i++){
      result = result.multiply(new BigInteger(String.valueOf(num)));
    }
    return result;
  }

}
