package projecteuler;

import java.math.BigInteger;

public class Problem25 {

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
    
    int target = 1000;
    int index = 2;
    BigInteger previous = new BigInteger("1");
    BigInteger current = new BigInteger("1");
    
    while(current.toString().length() < target){
      index++;
      current = current.add(previous);
      previous = current.subtract(previous);
    }
    
    System.out.println("The index of the first term in the Fibonacci sequence to contain "
    +target+" digits is "+index);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
}
