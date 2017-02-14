package projecteuler;

public class Problem21 {

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
    
    int sumOfAmicable = 0;
    int targetNumber = 10000;
    
    for(int i = 2; i <= targetNumber; i++){      
      if(i == sumOfFactors(sumOfFactors(i))){
        if(sumOfFactors(sumOfFactors(i)) != sumOfFactors(i)){
          sumOfAmicable = sumOfAmicable + i;
        }        
      }
    }
    
    System.out.println("The sum of all amicable numbers under "+targetNumber
        +" is "+sumOfAmicable);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static int sumOfFactors(int num){
    
    int sum = 1;
    
    for(int i = 2; i <= Math.sqrt(num); i++){
      if(num%i == 0){          
        sum = sum + i;
        if(i != sum){
          sum = sum + num/i;
        }        
      }
    }
    
    return sum;
  }
}
