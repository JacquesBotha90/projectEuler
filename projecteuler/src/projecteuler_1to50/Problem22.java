package projecteuler_1to50;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem22 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    ArrayList<String> sortedNames = new ArrayList<String>();
    BufferedReader reader = null;

    try {
      ClassLoader classLoader = Problem22.class.getClassLoader();
      File file = new File(classLoader.getResource("Problem22Names").getFile());
      reader = new BufferedReader(new FileReader(file));
      String text = reader.readLine();
      text = text.replace("\"", "");
      String[] names = text.split(",");
      
//      Collections sorting method. Far more efficient than my method. I will try
//      to optimize my sorting algorithm at a later stage. Perhaps I will try to write
//      a pivot sort algorithm.
//      for(String s : names){
//        sortedNames.add(s);
//      }
//      Collections.sort(sortedNames);
      sortedNames = sortNames(names);
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
    
    int result = 0;
    
    for(String n : sortedNames){
      int alphaValue = 0;
      for(char c : n.toCharArray()){
        alphaValue = alphaValue + alphaValue(c);
      }
      result = result + alphaValue*(sortedNames.indexOf(n)+1);
    }
    
    
    System.out.println("The total of the name scores in the given list is "+result);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static ArrayList<String> sortNames(String[] names){
    
    ArrayList<String> sortedNames = new ArrayList<>(names.length);   
    
    for(String n : names){
      if(n.equals(names[0])){
        sortedNames.add(n);
      } else{
        for(int i = 0; i <= sortedNames.size(); i++){
          if(i == sortedNames.size()){
            sortedNames.add(n);
            break;
          } else if(n.compareTo(sortedNames.get(i)) <= 0){
            sortedNames.add(i, n);
            break;
          }
        }
      }
    }
    
    return sortedNames;
  }
  
  static int alphaValue(char c){
    switch(c){
    case 'A': return 1;
    case 'B': return 2;
    case 'C': return 3;
    case 'D': return 4;
    case 'E': return 5;
    case 'F': return 6;
    case 'G': return 7;
    case 'H': return 8;
    case 'I': return 9;
    case 'J': return 10;
    case 'K': return 11;
    case 'L': return 12;
    case 'M': return 13;
    case 'N': return 14;
    case 'O': return 15;
    case 'P': return 16;
    case 'Q': return 17;
    case 'R': return 18;
    case 'S': return 19;
    case 'T': return 20;
    case 'U': return 21;
    case 'V': return 22;
    case 'W': return 23;
    case 'X': return 24;
    case 'Y': return 25;
    case 'Z': return 26;
    default: return 0;
    }
  }

}
