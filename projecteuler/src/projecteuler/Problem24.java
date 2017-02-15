package projecteuler;

import java.util.ArrayList;

public class Problem24 {
  
  static int counter = 0;
  static int target = 1000000;
  static boolean stayAlive = true;

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    for(int i = 0; i < 10; i++){
      numbers.add(i);
    }  
    
    recursiveLexicographicOrder(numbers, "");
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static void recursiveLexicographicOrder(ArrayList<Integer> nums, String s){
    if(nums.isEmpty()){
      counter++;
      if(counter == target){
        stayAlive = false;
        System.out.println("The millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9 is "+s);
      }      
    } else{
      if(stayAlive){
        for(int i = 0; i < nums.size(); i++){
          ArrayList<Integer> reduced = (ArrayList<Integer>) nums.clone();
          String next = s+reduced.get(i);
          reduced.remove(i);     
          recursiveLexicographicOrder(reduced, next);
        }
      }      
    }
  }

}
