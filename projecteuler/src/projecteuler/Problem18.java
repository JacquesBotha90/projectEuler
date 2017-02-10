package projecteuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem18 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    ArrayList<String[]> triangle = new ArrayList<String[]>();
    BufferedReader reader = null;

    try {
      ClassLoader classLoader = Problem18.class.getClassLoader();
      File file = new File(classLoader.getResource("Problem18Triangle").getFile());
      reader = new BufferedReader(new FileReader(file));
      String text = null;
      while ((text = reader.readLine()) != null) {
        triangle.add(text.split("\\s"));
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
    
    for(int i = triangle.size()-2; i >= 0; i--){
      for(int j = 0; j < triangle.get(i).length; j++){
        triangle.get(i)[j] = max(Integer.valueOf(triangle.get(i)[j])
            +Integer.valueOf(triangle.get(i+1)[j]), 
            Integer.valueOf(triangle.get(i)[j])+
            Integer.valueOf(triangle.get(i+1)[j+1]));
      }
    }
    
    System.out.println("The maximum total from the top to the bottom "
        + "of the given triangle is "+triangle.get(0)[0]);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static String max(int left, int right){
    
    if(left > right){
      return String.valueOf(left);
    } else{
      return String.valueOf(right);
    }    
  }

}
