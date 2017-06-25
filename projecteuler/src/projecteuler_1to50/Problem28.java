package projecteuler;

public class Problem28 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    int spiralSize = 1001;
    int fourCounter = 0;
    int skipSize = 2;
    int skipCounter = 1;
    int sum = 1;
    
    for(int i = 2; i <= spiralSize*spiralSize; i++){
      if(skipCounter == skipSize){        
        sum = sum + i;
        fourCounter++;
        skipCounter = 1;
      } else {
        skipCounter++;
      }      
      if(fourCounter == 4){
        fourCounter = 0;
        skipSize = skipSize + 2;
      }
    }
    System.out.println("The sum of the numbers on the diagonals in a "+spiralSize+
        " by "+spiralSize+" is "+sum);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms"); 

  }

}
