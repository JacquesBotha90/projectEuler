package projecteuler;

public class Problem19 {

  public static void main(String[] args) {

    long startTime = System.nanoTime();
    
    int numSundays = 0;
    int startMonth = 1;
    int endMonth = 12;
    int startYear = 1901;
    int endYear = 2000;
    
    //Note: This loop only works if the start and end year are not the same.
    for(int y = startYear; y <= endYear; y++){
      if(y == endYear){
        for(int m = 1; m <= endMonth; m++){
          if(isSunday(1, m, y)){
            numSundays++;
          }
        }
      }else if(y == startYear){
        for(int m = startMonth; m <= 12; m++){
          if(isSunday(1, m, y)){
            numSundays++;
          }
        }
      }else{
        for(int m = 1; m <= 12; m++){
          if(isSunday(1, m, y)){
            numSundays++;
          }
        }
      }
    }
    
    System.out.println("The number of Sundays that fell on the first of the month "
        + "during the twentieth century (1 Jan 1901 to 31 Dec 2000) is "+numSundays);
    
    long endTime = System.nanoTime();
    System.out.println("Execution time: "+(endTime - startTime)/1000000+"ms");

  }
  
  static boolean isLeapYear(int year){
    if(year%4 == 0){
      if((year%100 == 0)&&(year%400 != 0)){
        return false;
      } else{
        return true;
      }
    } else{
      return false;
    }
  }
  
  static int daysInMonth(int month, boolean isLeap){
    switch(month){
      case 1: return 31;
      case 2: if(isLeap){
        return 29;
      } else{
        return 28;
      }
      case 3: return 31;
      case 4: return 30;
      case 5: return 31;
      case 6: return 30;
      case 7: return 31;
      case 8: return 31;
      case 9: return 30;
      case 10: return 31;
      case 11: return 30;
      case 12: return 31;
      default: return 0;      
    }
  }
  
  /**
   * Calculates the day by counting the days from 1 Jan 1900 which was a Monday  
   * @param day
   * @param month
   * @param year
   * @return
   */
  static boolean isSunday(int day, int month, int year){
    
    int numDays = 0;
    
    for(int i = 1900; i < year; i++){
      if(isLeapYear(i)){
        numDays = numDays+366;
      } else{
        numDays = numDays+365;
      }
    }
    
    for(int i = 1; i < month; i++){
      numDays = numDays + daysInMonth(i, isLeapYear(year));
    }
    
    numDays = numDays + day;
    
    if(numDays%7 == 0){
      return true;
    } else{
      return false;
    }
  }

}
