package projecteuler_1to50;

import java.util.ArrayList;

public class Problem23 {

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
    
    ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
        
    for(int i = 1; i < 28123; i++){
      if(isAbundant(i)){
        abundantNumbers.add(i);
      }
    }
    
    int sum = 0;
    for(int i = 1; i < 28123; i++){
      boolean sumOfAbundants = false;
      for(int a : abundantNumbers){        
        if(a >= i){
          break;
        }
        else{
          int diff = i - a;
          if(abundantNumbers.contains(diff)){
            sumOfAbundants = true;
            break;
          }
        }        
      }
      if(!sumOfAbundants){
        sum = sum + i;
      }
    }
    System.out.println(sum);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");
  }
  
  static int sumOfFactors(int num){
    
    int sum = 1;
    
    for(int i = 2; i <= Math.sqrt(num); i++){
      if(num%i == 0){          
        sum = sum + i;
        if(i != num/i){
          sum = sum + num/i;
        } 
      }
    }    
    return sum;
  }
  
  static boolean isAbundant(int num){
    if(sumOfFactors(num)>num){
      return true;
    } else{
      return false;
    }
  }

}
