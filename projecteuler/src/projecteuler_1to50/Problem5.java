package projecteuler_1to50;

import java.util.ArrayList;
import java.util.HashSet;

public class Problem5 {

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
    
    long target = 20;
    
    System.out.println("The smallest positive number that is "
        + "evenly divisible by all of the numbers from 1 to "+target+" is "
        +smallestConsFactorNum(target));
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");
  }
  
  static HashSet<Long> calculateFactors(long num){
    
    HashSet<Long> factors = new HashSet<Long>();
    
    for(long i = 1l; i < num; i++){      
      if(factors.contains(i)){
        break;
      }else if(num%i == 0){
        factors.add(i);
        factors.add(num/i);
      }      
    }    
    return factors;
  }
  
  static long smallestConsFactorNum(long highestConsecutiveFactor){
    
    long answer = 0;
    ArrayList<Long> primesLessThanTarget = new ArrayList<Long>();
    
    for(long i = highestConsecutiveFactor; i > 1; i--){
      if(identifyPrime(i)){
        primesLessThanTarget.add(i);
      }
    }
    
    long increment = 1;
    for(long i : primesLessThanTarget){
      increment = increment*i;
    }
    boolean allFactors = false;
    
    while(!allFactors){
      answer = answer + increment;
      allFactors = true;
      HashSet<Long> factors = calculateFactors(answer);
      for(long i = 2l; i <= highestConsecutiveFactor; i++){
        if(!factors.contains(i)){
          allFactors = false;
          break;
        }
      }
    }       
    
    return answer;    
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
