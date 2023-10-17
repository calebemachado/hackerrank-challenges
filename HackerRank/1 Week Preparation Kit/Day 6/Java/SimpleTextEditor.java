import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    
    private static final Stack<String> stack = new Stack<>();
    // public static int counter = 0;
    
    public static void append(String s) {
        // counter++;
        // System.out.println(String.format("%s: %s", counter, stack.toString()));
        if(stack.isEmpty()) {
            stack.addElement(s);
        } else {
            String top = stack.peek();
            String result = new StringBuilder(top).append(s).toString();
            stack.addElement(result);
        }
    }
    
    public static void delete(Integer idx) {
        // counter++;
        // System.out.println(String.format("%s: %s", counter, stack.toString()));
        if(!stack.isEmpty()) {
            String top = stack.peek();
            int endIndex = top.length() - idx;
            if(idx < top.length()) {
                String result = top.substring(0, endIndex);
                stack.addElement(result);
            } else {
                stack.addElement("");
            }
        }
    }
    
    public static void print(Integer idx) {
        // counter++;
        // System.out.println(String.format("%s: %s", counter, stack.toString()));
        if(!stack.isEmpty()) {
            String top = stack.peek();
            if(idx <= top.length()) {
                System.out.println(top.charAt(idx - 1));
            }
        }
    }
    
    public static void undo() {
        // counter++;
        // System.out.println(String.format("%s: %s", counter, stack.toString()));
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        
        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                int option = Integer.parseInt(firstMultipleInput[0]);

                switch (option){
                    case 1: {
                        Solution.append(firstMultipleInput[1]);
                        break;
                    }
                    case 2: {
                        Solution.delete(Integer.parseInt(firstMultipleInput[1]));
                        break;
                    }
                    case 3: {
                        Solution.print(Integer.parseInt(firstMultipleInput[1]));
                        break;
                    }
                    case 4: {
                        Solution.undo();
                        break;
                    }
                    default: throw new IllegalArgumentException("Invalid option");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}