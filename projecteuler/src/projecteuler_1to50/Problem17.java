package projecteuler_1to50;

public class Problem17 {
  
  /*
   * Note: This method can only print out numbers up to 9999 at the moment, but the 
   * toWords() method can easily be extended.
   */

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    int start = 1;
    int end = 1000;
    String result = "";
    
    for(int i = start; i <= end; i++){
      result = result+toWords(i);
    }
    
    System.out.println("The number of characters used to write out the "
        + "numbers between "+start+" and "+end+" (inclusive) "
            + "is "+result.length());
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static String toWords(int num){    
    String words = "";
    
    if(num > 999){
      int thousand = (num/1000)%10;
      int hundred = (num/100)%10;
      int ten = (num/10)%10;
      int one = (num/1)%10;
      words = ones(thousand)+"thousand"+toWords(hundred*100+ten*10+one);
    } else if(num > 99){
      int hundred = (num/100)%10;
      int ten = (num/10)%10;
      int one = (num/1)%10;
      if(ten == 0 && one == 0){
        words = ones(hundred)+"hundred";
      } else{
        words = ones(hundred)+"hundredand"+toWords(ten*10+one);
      }      
    } else if(num > 19){
      int ten = (num/10)%10;
      int one = (num/1)%10;
      words = tens(ten)+ones(one);
    } else if(num > 9){
      words = teens(num);
    } else{
      words = ones(num);
    }    
    
    return words;
  }
  
  static String ones(int num){
    String words = "";
    
    switch (num) {
    case 1:  words = "one";
      break;
    case 2:  words = "two";
      break;
    case 3:  words = "three";
      break;
    case 4:  words = "four";
      break;
    case 5:  words = "five";
      break;
    case 6:  words = "six";
      break;
    case 7:  words = "seven";
      break;
    case 8:  words = "eight";
      break;
    case 9:  words = "nine";
      break;
    default: 
      break;
    }    
    return words;
  }
  
  static String tens(int num){
    String words = "";
    
    switch (num) {
    case 2:  words = "twenty";
      break;
    case 3:  words = "thirty";
      break;
    case 4:  words = "forty";
      break;
    case 5:  words = "fifty";
      break;
    case 6:  words = "sixty";
      break;
    case 7:  words = "seventy";
      break;
    case 8:  words = "eighty";
      break;
    case 9:  words = "ninety";
      break;
    default: 
      break;
    }    
    return words;
  }
  
  static String teens(int num){
    String words = "";
    
    switch (num) {
    case 10:  words = "ten";
      break;
    case 11:  words = "eleven";
      break;
    case 12:  words = "twelve";
      break;
    case 13:  words = "thirteen";
      break;
    case 14:  words = "fourteen";
      break;
    case 15:  words = "fifteen";
      break;
    case 16:  words = "sixteen";
      break;
    case 17:  words = "seventeen";
      break;
    case 18:  words = "eighteen";
      break;
    case 19:  words = "nineteen";
      break;
    default: 
      break;
    }    
    return words;
  }

}
