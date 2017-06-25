package projecteuler_1to50;

import java.util.ArrayList;

public class Problem14 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    int highestNumber = 1000000;
    int number = 1;
    int numSteps = 1;
    
    for(int i = 1; i < highestNumber; i++){
      ArrayList<Long> chain = collatzChain((long)i);
      
      if(chain.size() > numSteps){
        number = i;        
        numSteps = chain.size();
      }      
    }
    
    System.out.println("Number under "+highestNumber+" with the longest "
        + "Collatz chain is "+number+" with "+numSteps+" steps");
    System.out.println(collatzChain((long)number));
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static ArrayList<Long> collatzChain(Long num){    
    ArrayList<Long> chain = new ArrayList<Long>();
    chain.add(num);
    long step = num;
    
    while(step != 1){
      if(step % 2 == 0){
        step = step/2;        
      } else {
        step = 3*step + 1;
      }
      chain.add(step);
    }
    
    return chain;
  }

}
