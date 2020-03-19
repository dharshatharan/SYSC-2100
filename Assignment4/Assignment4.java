import java.util.*;

/**
 * Class made for Assignment 4 of the course SYSC 2100 
 * @author Dharshatharan J. A.
 * @version 1.0
 */
public class Assignment4 {

  /**
   * Recursive method that sorts an array using selection sort
   * @param <T> Type of the array 
   * @param theArray The array to be sorted
   * @param n the length of the array
   */
  public static <T extends Comparable<? super T>> void recursiveSelectionSort (T[] theArray, int n) {
    int largestValueIndex = n-1;
    for(int currentIndex=n-2 ; currentIndex >= 0 ; --currentIndex) {
      if(theArray[currentIndex].compareTo(theArray[largestValueIndex]) > 0) {
        largestValueIndex = currentIndex;
      }
    }
    if (largestValueIndex != n-1){
      T tempValue = theArray[largestValueIndex];
      theArray[largestValueIndex] = theArray[n-1];
      theArray[n-1] = tempValue;
    }
    if(n > 2){
      recursiveSelectionSort(theArray, n-1);
    }
  }

  /**
   * Recursive method that sorts an array using bubble sort
   * @param <T> Type of the array 
   * @param theArray The array to be sorted
   * @param n the length of the array
   */
  public static <T extends Comparable<? super T>> void recursiveBubbleSort (T[] theArray, int n) {
    boolean sorted = true;
    for(int index=n-1; index>0; --index) {
      if(theArray[index].compareTo(theArray[index-1]) < 0) {
        T temp = theArray[index];
        theArray[index] = theArray[index-1];
        theArray[index-1] = temp;
        sorted = false;
      }
    } 
    if(sorted == false){
      recursiveBubbleSort(theArray, n-1);
    }   
  }

  /**
   * method that check is the given string is part of the language W$W'
   * @param str The string to be checked
   * @return true if the string is part of the language, else false
   */
  public static boolean isInLanguage (String str) {
    Queue<Character> theQueue = new LinkedList<Character>();
    Stack<Character> theStack = new Stack<Character>();
    int length = str.length();
    int index = 0;
    while(str.charAt(index) != '$') {
      theQueue.add(str.charAt(index)); //adding the first bit of the string to a queue
      index++;
    }
    index++;                            // skipping the '$' character
    while(index < length) {
      theStack.add(str.charAt(index));  // adding the second bit of the string to a stack
      index++;
    }
    if(theQueue.size() == theStack.size()) {
      int size = theQueue.size();
      for(int i = 0; i < size; i++) {
        if(theQueue.remove() != theStack.pop()) { // comparing the queue and stack
          return false;
        }
      }
      return true;
    }
    return false;
  }

  /**
   * Method that converts a string of numbers to an integer by removing the spaces
   * @param str the sting of numbers
   * @return the integer after the conversion 
   */
  public static int convertToNumber (String str) {
    int length = str.length();
    int num = 0;
    for(int i=0; i < length; i++) {
      if(str.charAt(i) != ' '){
        num = (num * 10) + Character.getNumericValue(str.charAt(i)); // converts the character to an integer and adds it to the number
      }
    }
    return num;
  }

}