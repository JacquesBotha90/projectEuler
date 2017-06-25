package projecteuler_1to50;

import java.util.ArrayList;

public class Problem15 {
  
  static long numPaths = 0;
  static ArrayList<Long> solutions;

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
    
    int gridSize = 20;
    solutions = new ArrayList<Long>();
    
    for(int i = 0; i < gridSize; i++){
      solutions.add(0l);
    }
    solutions.set(0, 2l);
    
//    recursiveLatticePath(1, 0, gridSize);
    recursiveLatticePath2(0, 0, gridSize);
    
    System.out.println("The total number of lattice paths through a "
    +gridSize+"x"+gridSize+" grid is "+numPaths*2);
    
    System.out.println(solutions);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static void recursiveLatticePath(int x, int y, int gridSize){
    
    if(x == gridSize && y == gridSize){
      numPaths++;
    } else if(x == gridSize){
      recursiveLatticePath(x, y+1, gridSize);      
    } else if(y == gridSize){
      recursiveLatticePath(x+1, y, gridSize);      
    } else{
      recursiveLatticePath(x+1, y, gridSize);
      recursiveLatticePath(x, y+1, gridSize);
    }    
  }
  
  static void recursiveLatticePath2(int x, int y, int gridSize){
    if((x == y) && x != 0){      
      if(x == gridSize){
        solutions.set(gridSize - 1, solutions.get(gridSize-1)+1);
      } else {
        if(solutions.get(gridSize-x-1) == 0){
          recursiveLatticePath2(0, 0, gridSize-x);
        }
        solutions.set(gridSize-1, solutions.get(gridSize-1)+solutions.get(gridSize-x-1));
      }            
    }    
    else if(x == gridSize){
      recursiveLatticePath2(x, y+1, gridSize);      
    } else if(y == gridSize){
      recursiveLatticePath2(x+1, y, gridSize);      
    } else{
      recursiveLatticePath2(x+1, y, gridSize);
      recursiveLatticePath2(x, y+1, gridSize);
    }    
  }

}
