/**
 * Class that contains the methods required to be written for Assignment 1 in SYSC 2100
 * @author Dharshatharan J. A.
 * @version 1.0
 */
public class Assignment1 {

  /**
   * Recursive method that solves the Spock problem to check how many ways k planets can be visited from n planets
   * @param n Total number of planets that can be visited
   * @param k Number of planets Spock wats to visit
   * @return The number of ways k planets can be visited from n planets
   */
  public static int c(int n, int k){
    System.out.print("c(" + n + "," + k + ") = ");
    if (k == 0 || k == n) {
      System.out.println("1");
      return 1;                           //base case
    } else if(k >= n){ 
      System.out.println("0");
      return 0;                           //base case
     } else {
       System.out.println("c(" + (n-1) + "," + (k-1) + ") + c(" + (n-1) + "," + (k) + ")");
       return c(n-1, k-1) + c(n-1, k);     //recursive method call
     }
  }


  /**
   * Recursive method that Organises a Parade with no two bands playing back to back
   * @param n number of bands and floats
   * @return Number of ways to organise a parade
   */
  public static int p(int n){
    System.out.print("p(" + n + ") = ");
    if (n == 1) {
      System.out.println("2");
      return 2;                           //base case
    } else if(n == 2){ 
      System.out.println("3");
      return 3;                           //base case
     } else {
       System.out.println("p(" + (n-1) + ") + p(" + (n-2) + ")");
       return p(n-1) + p(n-2);            //recursive methode call
     }
  }

  /**
   * Method that prints the character ch n number of time in a line
   * @param ch character to be printed
   * @param n Number of times ch needs to be printed
   */
  public static void writeLine(char ch, int n) {
    String s = "";
    while( n > 0 ){                       //loop that prints ch n times
      s = s + ch;  
      n--;
    }
    System.out.print(s + "\n");;
  }

  /**
   * Method that printes a block of characters
   * @param ch Character to be printed
   * @param n Number of characters in a line
   * @param m Number or rows
   */
  public static void writeBlock(char ch, int n, int m){
    if(m > 0){
      writeLine(ch, n);                   //calling writeLine
      writeBlock(ch, n, m-1);             //recursive method call
    }
  }

  /**
   * Reverses a decimal integer
   * @param number The number to be reversed 
   */
  public static void reverseDigits(int number){
    if((number/10) > 0){
      System.out.print(number%10);         //printing least significant digit
      reverseDigits((number/10));          //recursive method call
    } else {
      System.out.print(number);             //printing the last digit
    }
  }

  /**
   * Recursive method that performs binary search on an array of strings
   */
  public static int myBinarySearch(String[] anArray, int first,int last, String value){
    if (first>last){
      return -1;                                //base case 
    } else {
      int mid = ((first + last)/2);
      if(anArray[mid].compareTo(value)==0){     //binary search
        return mid;
      }
      else if(anArray[mid].compareTo(value)<0){
        return myBinarySearch(anArray, mid+1, last, value);       //recursive method call
      } else {
        return myBinarySearch(anArray, first, mid-1, value);      //recursive method call
      }
    }
  }

  /**
   * Main Method that displays the working of other methods 
   * @param args
   */
  public static void main(String[] args){
    System.out.println("c = " + c(3,2));
    System.out.println("p = " + p(5));
    writeLine('*', 5);
    writeBlock('*', 6, 6);
    reverseDigits(12345);
    System.out.println();
    String[] anArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    System.out.println("Index = " + myBinarySearch(anArray, 0, 9, "i"));
  }
}