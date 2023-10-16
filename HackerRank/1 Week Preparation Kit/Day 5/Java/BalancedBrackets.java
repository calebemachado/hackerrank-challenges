import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        if(s.length() % 2 != 0) {
            return "NO";
        }
        
        StringBuilder sb = new StringBuilder(s);
        int p1 = 0;
        int p2 = p1 + 1;
        while(p2 < sb.length()) {
            if(getCorrespondingBracket(sb.charAt(p1)) != sb.charAt(p2)) {
                p2++;
                p1++;
            } else {
                sb.replace(p1, p2 + 1, "");
                p1 = 0;
                p2 = p1 + 1;
            }
            
            if(sb.length() != 0 && p2 == sb.length()) {
                return "NO";
            }
        }
        
        return "YES";
    }
    
    public static char getCorrespondingBracket(char bracket) {
        switch (bracket) {
            case '{': return '}';
            // case '}': return '{';
            case '(': return ')';
            // case ')': return '(';
            case '[': return ']';
            // case ']': return '[';
            default: return ' ';
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
