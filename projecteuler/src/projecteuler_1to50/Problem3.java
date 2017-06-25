package projecteuler_1to50;

import java.util.Collections;
import java.util.HashSet;

public class Problem3 {    
  
  public static void main(String[] args) {
    
  long startTime = System.nanoTime();
  
  long num = 600851475143l; 
  HashSet<Long> factors = calculateFactors(num);
  HashSet<Long> primeFactors = new HashSet<Long>();
  
  System.out.println("Factors of "+num+" (not sorted):");
  for(long i : factors){
    System.out.print(i);
    if(identifyPrime(i)){
      primeFactors.add(i);
      System.out.print(" <--Prime");
    }
    System.out.println("");
  }
  System.out.println("Largest prime factor of "+num+": "+Collections.max(primeFactors));
  
  long endTime = System.nanoTime();
  System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");
  
  }
  
  static HashSet<Long> calculateFactors(long num){
    
    HashSet<Long> factors = new HashSet<Long>();
    
    for(long i = 2l; i < num; i++){      
      if(factors.contains(i)){
        break;
      }else if(num%i == 0){
        factors.add(i);
        factors.add(num/i);
      }      
    }    
    return factors;
  }
  
  static boolean identifyPrime(long num){
    
    boolean isPrime = true;
    
    for(long i = 2l; i <= num/2; i++){
      if(num%i == 0){
        isPrime = false;
        return isPrime;
      }      
    }
    
    return isPrime;
  }

}
