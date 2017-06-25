package projecteuler_1to50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Problem26 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    ArrayList<Integer> recurringLengths = new ArrayList<Integer>();
    int upperLimit = 1000;
    
    for(int i = 2; i <= upperLimit; i++){
      Result temp = calculateReciprocal(i);
      map.put(temp.recurringLength, i);
      recurringLengths.add(temp.recurringLength);
    }
    
    int maxRecurringLength = Collections.max(recurringLengths);
    int answer = map.get(maxRecurringLength);
    
    System.out.println("The value of d < 1000 for which 1/d contains the "
        + "longest recurring cycle in its decimal fraction part is "+answer+
        " with a recurring cycle length of "+maxRecurringLength);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static Result calculateReciprocal(int denominator){
    Result r = null;
    ArrayList<Integer> remainders = new ArrayList<Integer>();
    String answer = "0.";
    boolean isTerminating = false;
    int currentRemainder = 0;
    int currentNumerator = 10;
    
    while(!isTerminating){
      answer = answer + currentNumerator/denominator;
      currentRemainder = currentNumerator%denominator;
      if (currentRemainder == 0) {
        isTerminating  = true;
        r = new Result(isTerminating, 0, answer);
        break;
      } else{
        if(remainders.contains(currentRemainder)){
          int rl = remainders.size() - remainders.indexOf(currentRemainder);
          String a = answer+" recurring with repeating pattern of length "+rl;
          r = new Result(isTerminating, rl, a);
          break;
        } else{
          remainders.add(currentRemainder);
          currentNumerator = currentRemainder*10;
        }
      }
    }    
    
    return r;
  }
}

class Result{
  boolean isTerminating;
  int recurringLength;
  String answer;
  
  Result(boolean it, int rl, String a){
    this.isTerminating = it;
    this.recurringLength = rl;
    this.answer = a;
  }
  
}
