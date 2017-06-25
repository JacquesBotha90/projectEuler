package projecteuler_1to50;

import java.util.HashSet;

public class Problem12 {

  public static void main(String[] args){
    
    long startTime = System.nanoTime();
    
    int targetNumDivisor = 500;
    boolean hasTargetDivisors = false;
    int n = 2;
    long currentTriangle = 1l;
    HashSet<Long> factors = null;
    
    while(!hasTargetDivisors){
      currentTriangle += n;      
      n++;
      factors = calculateFactors(currentTriangle);
      
      if(factors.size() > targetNumDivisor){
        hasTargetDivisors = true;
      }      
    }
    
    System.out.println("The first triangle number with more than "+
        targetNumDivisor+" factors is "+currentTriangle);
    
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

}
