import java.util.*;
import java.io.*; 

/**
 * Class to count the number of times a string appears in a text file
 * @author Dharshatharan J. A.
 * @version 1.0
 */
public class CountSubstrings {

  /**
   * Counts the number of times a string appears in a text file
   * @param fileName file name of the text file
   * @param listType Type of list to be created - ArrayList or LinkedList
   * @param pattern The string to be searched for
   * @return
   */
  private static int CountSubString(String fileName, String listType, String pattern) {
    int count = 0;
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);

      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        List<Character> list = CreateList(data, listType);
        List<Character> patternList = CreateList(pattern, listType);
        int index = findBrute(list, patternList);
        while (index != -1){
          list.remove(index);
          count++;
          index = findBrute(list, patternList);
        }
        
        list.clear();
      } 
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return count;

  }

  /**
   * Creates an ArrayList or LinkedList using the data based on listType
   * @param data Data to be made into a list
   * @param listType type of list to be created 
   * @return
   */
  private static List<Character> CreateList(String data, String listType) {
    int n = data.length();

    if (listType.equals("ArrayList")) {
      ArrayList<Character> list = new ArrayList<Character>();
      for(int i = 0; i < n; i++){
        list.add(data.charAt(i));
      }
      return list;
    } else if (listType.equals("LinkedList")) {
      LinkedList<Character> list = new LinkedList<Character>();
      for(int i = 0; i < n; i++){
        list.addLast(data.charAt(i));
      }
      return list;
    }
    return null;
  }
  
  /*
 * Returns the lowest index at which substring pattern begins in text (or
 * else -1).
 */
  private static int findBrute(List<Character> text, List<Character> pattern) {
    int n = text.size();
    int m = pattern.size();
    for (int i = 0; i <= n - m; i++) { // try every starting index
      // within text
      int k = 0; // k is index into pattern
      while (k < m && text.get(i + k) == pattern.get(k))
      // kth character of pattern matches
      k++;
      if (k == m) // if we reach the end of the pattern,
      return i; // substring text[i..i+m-1] is a match
    }
    return -1; // search failed
  } 

  /**
   * Main fuction of the program that prompts the user to enter file to search and the word to search for
   * @param args
   */
  public static void main(String[] args){
    Scanner myObj = new Scanner(System.in);
    System.out.print("Please enter the path of the input file: ");
    String fileName = myObj.nextLine();
    System.out.print("Enter the pattern to look for: ");
    String pattern = myObj.nextLine();

    myObj.close();

    long startTime = System.currentTimeMillis();
    System.out.print(" Using ArrayLists: " + CountSubString(fileName, "ArrayList", pattern) + " matches, ");
    long arrayListTime = System.currentTimeMillis() - startTime;
    //String arrayListTimeString = String.format("%.1f", arrayListTime);
    System.out.println("derived in " + arrayListTime + " milliseconds.");
    startTime = System.currentTimeMillis();
    System.out.print(" Using LinkedLists: " + CountSubString(fileName, "LinkedList", pattern) + " matches, ");
    long linkedListTime = System.currentTimeMillis() - startTime;
    //String linkedListTimeString = String.format("%.1f", linkedListTime);
    System.out.println("derived in " + linkedListTime + " milliseconds.");
  }

}