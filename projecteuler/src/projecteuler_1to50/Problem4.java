package projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Problem4 {
  
  static ArrayList<Integer> palindromicNumbers = new ArrayList<>();
  static HashMap<Integer, ArrayList<Integer>> products = new HashMap<>();

  public static void main(String[] args) {
    long startTime = System.nanoTime();    
    
    int largestValue = 999;
    findLargestPalindrome(largestValue);
    int result = Collections.max(palindromicNumbers);
    System.out.println("Largest palindromic number from the product of two numbers "
        + "smaller than "+largestValue+" is "+result+" as the product "
            + "of "+products.get(result).get(0)+"*"+products.get(result).get(1));
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");
  }
  
  static boolean isPalindrome(int num){
    boolean isPalindrome = true;
    
    char[] numbers = String.valueOf(num).toCharArray();
    
    for(int i = 0; i < numbers.length - i; i++){
      if(numbers[i] != numbers[numbers.length - 1 - i]){
        isPalindrome = false;
      }
    }    
    return isPalindrome;
  }
  
  static void findLargestPalindrome(int highestVal){
    
    
    int num;
    for(int i  = highestVal; i > 0; i--){
      for(int j = i; j < highestVal + 1; j++){
        num = i*j;
        if(isPalindrome(num)){
          ArrayList<Integer> result = new ArrayList<>();
          result.add(i);
          result.add(j);
          palindromicNumbers.add(num);
          products.put(num, result);
        }
      }
    }
  }

}
