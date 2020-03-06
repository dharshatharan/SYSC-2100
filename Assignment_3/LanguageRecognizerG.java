package assignment3;
import java.util.*;

public class LanguageRecognizerG{

  final char[] E = {'&', '#'};
  final char[] V = {'W', 'A'};
  
  private boolean recursiveRecogG(LinkedList<Character> G){
    if()
  }

  private boolean recogE(char e){
    if((e==E[0]) || (e==E[1])){
      return true;
    }
    return false;
  }

  private boolean recogV(char v){
    if((v==V[0]) || (v==V[1])){
      return true;
    }
    return false;
  }

  private LinkedList<Character> CreateList(String data) {
    int n = data.length();
    LinkedList<Character> list = new LinkedList<Character>();
    for(int i = 0; i < n; i++){
      list.addLast(data.charAt(i));
    }
    return list;
  }

  public void recursivePrintG(){

  }
}