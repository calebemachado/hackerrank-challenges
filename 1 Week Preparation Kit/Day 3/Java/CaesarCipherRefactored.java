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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    public static String caesarCipher(String s, int k) {
        k %= 26;
        
        String alphabetS = "abcdefghijklmnopqrstuvwxyz";
        char[] translatedC = (alphabetS.substring(k) + alphabetS.substring(0, k)).toCharArray();
        
        StringBuilder result = new StringBuilder();
        char[] sArray = s.toCharArray();
        
        for(char c : sArray){
            if(Character.isLetter(c)) {
                int positionAt = alphabetS.indexOf(Character.toLowerCase(c));
                char translatedChar = (Character.isUpperCase(c)) 
                                        ? Character.toUpperCase(translatedC[positionAt])
                                        : translatedC[positionAt];
                result.append(translatedChar);
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
