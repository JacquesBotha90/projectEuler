package projecteuler_1to50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Problem27 {

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
    
    ArrayList<int[]> abPairs = new ArrayList<>();
    HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
    ArrayList<Integer> primes = new ArrayList<>();
    primes.add(1);    
    
    for(int i = 2; i < 1000; i++){
      if(isPrime(i)){
        primes.add(i);
      }
    }
    
    for(int a = -999; a < 1000; a++){
      for(int b : primes){
        abPairs.add(new int[] {a,b});
      }
    }
    
    for(int[] ab : abPairs){
      map.put(consecutivePrimes(ab), ab);
    }
    
    int[] maxabPair = map.get(Collections.max(map.keySet()));    
    System.out.println("The quadratic expression that produces the maximum number of "
        + "primes uses abPair "+maxabPair[0]+" "+maxabPair[1]);
    System.out.println("Product of a and b is "+maxabPair[0]*maxabPair[1]);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");    
  }
  
  static int consecutivePrimes(int[] abPair){
    int consecPrimes = 0;
    boolean isPrime = true;
    int n = 0;   
    
    while(isPrime){
      isPrime = isPrime(n*n+abPair[0]*n+abPair[1]);
      if(isPrime){
        consecPrimes++;
      }
      n++;
    }
    
    return consecPrimes;
  }
  
  static boolean isPrime(int num){ 
    if(num <= 0){
      return false;
    }
    boolean isPrime = true;
    for(long i = 2l; i <= Math.sqrt(num); i++){
      if(num%i == 0){          
        isPrime = false;
        break;
      }      
    }
    return isPrime;
  }

}
