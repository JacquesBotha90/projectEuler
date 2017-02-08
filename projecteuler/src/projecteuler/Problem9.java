package projecteuler;

import java.util.ArrayList;

public class Problem9 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    int sum = 1000;

    ArrayList<int[]> results = findPythagTriplet(sum);
    
    for(int[] triplet : results){
      System.out.println("Possible Pythagorean triplet: a = "+triplet[0]+" b = "
          +triplet[1]+" c = "+triplet[2]);
      System.out.println("Product is "+triplet[0]*triplet[1]*triplet[2]);
    }
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static boolean isPythagTriplet(int a, int b, int c){
    if((a*a+b*b)==(c*c)){
      return true;
    } 
    else{
      return false;
    }
  }
  
  static ArrayList<int[]> findPythagTriplet(int sum){
    ArrayList<int[]> results = new ArrayList<int[]>();
    for(int a = 1; a < sum/3; a++){
      for(int b = a+1; b <= (sum-a)/2; b++){
        int c = sum - a - b;
        if(isPythagTriplet(a, b, c)){
          results.add(new int[] {a, b, c});
        }
      }
    }
    return results;
  }

}
