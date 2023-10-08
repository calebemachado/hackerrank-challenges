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
        //Identify the k index when k > 26
        while(k > 26) {
            k = k - 26;
        }
        
        String alphabetS = "abcdefghijklmnopqrstuvwxyz";
        //Create the new alphabet order, removing first part and appending to the end of the string
        char[] translatedC = alphabetS.substring(k).concat(alphabetS.substring(0, k)).toCharArray();
        
        //Initialize result string
        StringBuilder result = new StringBuilder();
        //Split string informed into array of chars
        char[] sArray = s.toCharArray();
        //Iterate over each char to find in alphabet the letter index then, find the correspondent at position in the new alphabet
        for(int i = 0; i < sArray.length; i++){
            //Check if char is letter, if not just append to result and continue
            if(Character.isLetter(sArray[i])) {
                //Check if char is uppercase, if yes bring the lowercase correspondent and transform to uppercase, if not bring the correspondent
                if(!Character.isUpperCase(sArray[i])) {
                    int positionAt = alphabetS.indexOf(sArray[i]);
                    result.append(translatedC[positionAt]);
                } else {
                    int positionAt = alphabetS.indexOf(Character.toLowerCase(sArray[i]));
                    result.append(Character.toUpperCase(translatedC[positionAt]));
                }
            } else {
                result.append(sArray[i]);
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
