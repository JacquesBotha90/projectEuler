package projecteuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Problem13 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();

    ArrayList<String> lines = new ArrayList<String>();
    ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> answer = new ArrayList<Integer>();
    BufferedReader reader = null;

    try {
      ClassLoader classLoader = Problem13.class.getClassLoader();
      File file = new File(classLoader.getResource("Problem13Numbers").getFile());
      reader = new BufferedReader(new FileReader(file));
      String text = null;

      while ((text = reader.readLine()) != null) {
        lines.add(new StringBuilder(text).reverse().toString());
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

    for (String s : lines) {
      for (int i = 0; i < s.length(); i++) {
        if (numbers.size() <= i) {
          numbers.add(new ArrayList<Integer>());
        }
        numbers.get(i).add(Integer.valueOf(String.valueOf(s.charAt(i))));
      }
    }
    // Add new element to numbers for overflow
    numbers.add(new ArrayList<Integer>());

    int position = 0;
    boolean completed = false;

    while (!completed) {
      int sum = 0;
      for (int i = 0; i < numbers.get(position).size(); i++) {        
        sum += numbers.get(position).get(i);
      }
      
      position++;
      
      String colAnswer = String.valueOf(sum); 
      int finalDigit = Integer.valueOf(colAnswer.substring(colAnswer.length() - 1));
      int carryOver = Integer.valueOf(colAnswer.substring(0, colAnswer.length() - 1));
           
      answer.add(finalDigit);
      numbers.get(position).add(carryOver);
      
      if(position == numbers.size()-1){
        completed = true;
        answer.add(position, carryOver);
      }

    }
    Collections.reverse(answer);
    
    System.out.println("The sum of all numbers:");
    for(int i = 0; i < answer.size(); i++){
      System.out.print(answer.get(i));
    }
    System.out.println("");

    long endTime = System.nanoTime();
    System.out.println("Execution time: " + (endTime - startTime) / 1000000
        + "ms");

  }

}
