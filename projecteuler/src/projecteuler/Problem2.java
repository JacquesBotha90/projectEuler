package projecteuler;

public class Problem2 {

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
    
    int prev = 1;
    int curr = 2;
    int next = 0;
    int sum = 2;
    
    while(next < 4000000){
      System.out.println(curr = curr + prev);
      prev = curr - prev;
      if(curr%2 == 0){
        System.out.println("Added "+curr);
        sum = sum + curr;
        next = curr + prev;
      }
    }
    
    System.out.println("Final Sum: "+sum);
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }

}
