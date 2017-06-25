package projecteuler_1to50;

import java.math.BigInteger;

public class Problem20 {

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
    
    BigInteger product = new BigInteger("1");
    int factorialLimit = 100;
    
    for(int i = factorialLimit; i > 1; i--){
      product = product.multiply(new BigInteger(String.valueOf(i)));
    }
    
    int sum = 0;
    for(int i = 0; i < product.toString().length(); i++){
      sum = sum + Integer.valueOf(String.valueOf(product.toString().charAt(i)));
    }
    
    System.out.println("The sum of the digits of "+factorialLimit+"! is "+sum);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");
  }

}
