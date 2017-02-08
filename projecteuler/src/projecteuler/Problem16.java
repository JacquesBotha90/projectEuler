package projecteuler;

import java.math.BigInteger;

public class Problem16 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    BigInteger num = new BigInteger("2");
    int exponent = 1000;
    
    BigInteger target = num.pow(exponent);    
    char[] targetArray = target.toString().toCharArray();
    
    int sum = 0;    
    for(char c : targetArray){
      sum = sum + Character.getNumericValue(c);
    }
    
    System.out.println("The sum of the digits of the number "+num+"^"
        +exponent+" is "+sum);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }

}
