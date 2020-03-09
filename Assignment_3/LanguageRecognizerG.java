import java.util.*;

public class LanguageRecognizerG{

  final char[] E = {'&', '#'};
  final char[] V = {'W', 'A'};
  private LinkedList<Character> data;
  private String st;
  
  public LanguageRecognizerG(String data){
    st = data;
    this.data = CreateList(data);
  }

  private boolean recursiveRecogG(LinkedList<Character> G){
    char first = G.getFirst();
    char next;
    if(G.size() != 1){
      next = G.get(1);
    } else {
      next = '\0';
    }
    char last = G.getLast();
    if((recogE(first)) || (recogV(first) && recogE(next))){
      return true;
    } else if((recogE(first)) && (recogV(last))){
      G.removeFirst();
      G.removeLast();
      return recursiveRecogG(G);
    } else {
      return false;
    }
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
    if(recursiveRecogG(this.data)){
      System.out.println("Recursion: Word \"" + st + "\" IS a word of the G language");
    } else if(st.equals("")){
      System.out.println("Recursion: Word \"\" IS a word of the G language");
    } else {
      System.out.println("Recursion: Word " + st + "is NOT a word of the G language");
    }
  }
}