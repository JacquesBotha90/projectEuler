package projecteuler;

public class Problem10 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    
    int threshold = 2000000;
    long currentNumber = 3l;
    long sum = 2;
    
    while(currentNumber < threshold){
      boolean isPrime = true;
      for(long i = 2l; i <= Math.sqrt(currentNumber); i++){
        if(currentNumber%i == 0){          
          isPrime = false;
          break;
        }      
      }
      if(isPrime){
        sum += currentNumber;
      }
      currentNumber+=2;
    }
    
    System.out.println("Sum of prime numbers smaller than "+
    threshold+" is "+sum);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }

}
