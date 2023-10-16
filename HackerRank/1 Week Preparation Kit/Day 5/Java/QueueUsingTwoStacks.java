import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Solution {
    
    private final static LinkedList<Integer> queue = new LinkedList<>();
    
    public static void enqueue(int value){
        queue.addLast(value);
    }
    
    public static void dequeue(){
        queue.removeFirst();
    }
    
    public static void printFrontElement(){
        System.out.println(queue.getFirst());
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
                        Solution.enqueue(Integer.parseInt(firstMultipleInput[1]));
                        break;
                    }
                    case 2: {
                        Solution.dequeue();
                        break;
                    }
                    case 3: {
                        Solution.printFrontElement();
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