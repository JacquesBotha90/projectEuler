package projecteuler;

public class Problem6 {

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    
    long target = 100l;
    long sqofsum = squareOfSum(target);
    long sumofsq = sumOfSquares(target);
    
    System.out.println("The difference between the sum of the squares of all"
        + " numbers up to "+target+" is:");
    System.out.println("Square of sum: "+sqofsum);
    System.out.println("Sum of squares: "+sumofsq);
    System.out.println("Difference: "+(sqofsum-sumofsq));
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static long sumOfSquares(long target){    
    long answer = 0;
    for(long i = 1; i <= target; i++){
      answer = answer + i*i;
    }
    return answer;
  }
  
  static long squareOfSum(long target){
    long answer = 0;
    for(long i = 1; i <= target; i++){
      answer = answer + i;
    }
    return answer*answer;
  }

}
