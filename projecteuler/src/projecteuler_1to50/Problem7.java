package projecteuler_1to50;

public class Problem7 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    
    int target = 10001;
    int counter = 1;
    long currentPrime = 2l;
    long currentNumber = 3l;
    
    while(counter < target){
      boolean isPrime = true;
      for(long i = 2l; i <= Math.sqrt(currentNumber); i++){
        if(currentNumber%i == 0){          
          isPrime = false;
          break;
        }      
      }
      if(isPrime){
        currentPrime = currentNumber;          
        counter= counter+2;
      }
      currentNumber++;
    }
    
    System.out.println("Prime number "+counter+" is "+currentPrime);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }

}
