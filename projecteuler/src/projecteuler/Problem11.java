package projecteuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Problem11 {

  public static void main(String[] args) {
    
    long startTime = System.nanoTime();
    
    ArrayList<Long> products = new ArrayList<Long>();
    int numAdjacent = 4;
    int gridSize = 20;
    String[][] grid = new String[gridSize][gridSize];    
    BufferedReader reader = null;
    int counter = 0;

    try {
        ClassLoader classLoader = Problem11.class.getClassLoader();
        File file = new File(classLoader.getResource("Problem11Grid").getFile());
        reader = new BufferedReader(new FileReader(file));
        String text = null;

        while ((text = reader.readLine()) != null) {
          grid[counter] = text.split("\\s");
          counter++;
        }
        
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
        }
    }
    
    //Horizontal products
    for(int i = 0; i < gridSize; i++){
      for(int j = 0; j < gridSize-numAdjacent; j++){
        products.add(Long.valueOf(grid[i][j])*Long.valueOf(grid[i][j+1])
            *Long.valueOf(grid[i][j+2])*Long.valueOf(grid[i][j+3]));
      }
    }
    //Vertical products
    for(int i = 0; i < gridSize-numAdjacent; i++){
      for(int j = 0; j < gridSize; j++){
        products.add(Long.valueOf(grid[i][j])*Long.valueOf(grid[i+1][j])
            *Long.valueOf(grid[i+2][j])*Long.valueOf(grid[i+3][j]));
      }
    }
    //Diagonal (right down) products
    for(int i = 0; i < gridSize-numAdjacent; i++){
      for(int j = 0; j < gridSize-numAdjacent; j++){
        products.add(Long.valueOf(grid[i][j])*Long.valueOf(grid[i+1][j+1])
            *Long.valueOf(grid[i+2][j+2])*Long.valueOf(grid[i+3][j+3]));
      }
    }
    //Diagonal (left down) products
    for(int i = 0; i < gridSize-numAdjacent; i++){
      for(int j = 3; j < gridSize; j++){
        products.add(Long.valueOf(grid[i][j])*Long.valueOf(grid[i+1][j-1])
            *Long.valueOf(grid[i+2][j-2])*Long.valueOf(grid[i+3][j-3]));
      }
    }
    
    System.out.println("Greatest product of "+numAdjacent+" numbers is "+Collections.max(products));
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }

}
