import java.util.EmptyStackException;
import java.util.LinkedList;
public class StackListBased {
    private static LinkedList<String> items;
    private String top;
    public void createStack() {
        items = new LinkedList<>();
        top = null;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void popAll() {
        while (!isEmpty()) {
            items.clear();
        }
    }
    public void push(String elem) {
        items.addLast(elem);
        top = elem;
    }
    public static String pop() throws EmptyStackException {
        if(items.isEmpty()) {
            System.out.print("Stack is empty");
            throw new EmptyStackException();
        } else {
            String last = items.getLast();
            items.removeLast();
            return last;
        }
    }
    public String peek() throws EmptyStackException {
        if(items.isEmpty()) {
            System.out.print("Stack is empty");
            throw new EmptyStackException();
        } else {
            return top;
        }
    }
}