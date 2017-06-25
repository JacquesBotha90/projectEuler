package projecteuler;

public class Problem1 {

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
            
    int sum = 0;
    
    for(int i = 1 ; i < 1000; i++){
      if(i%3 == 0){
        System.out.println(i);
        sum = sum + i;
      } else if(i%5 == 0){
        System.out.println(i);
        sum = sum + i;
      }
    }
    
    System.out.println("Final Sum: "+sum);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }

}
