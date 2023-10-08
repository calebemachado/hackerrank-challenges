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
     * Complete the 'towerBreakers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int towerBreakers(int n, int m) {
        if(m == 1 || n % 2 == 0) {
            return 2;
        } else {
            return 1;
        }

        // The solution below should work for small towers and number of towers, but seems to take too much time when the numbers is too high
        // And in fact make the same calculations for every tower, this is a waste of time and computational resources.
        // It was my first attempt, at last I understood the possible scnearios drawing the odds of each player when n,m were even or odd
        // //Player one bad luck, we don't have more plays available
        // if(m == 1) {
        //     return 2;
        // }
        
        // int rounds = 1;
        
        // List<Integer> towers = new ArrayList<>();
        // for(int i = 1; i <= n; i++){
        //     System.out.println(String.format("Adding tower %s de %s", i, n));
        //     towers.add(m);
        // }   
        
        // //Still have playable towers to decrease height
        // while(towers.size() > 1) {
        //     rounds++;
        //     System.out.println(String.format("Increasing rounds %s", rounds));
            
        //     int temp = towers.get(0);
        //     System.out.println(String.format("Current tower height %s", temp));
        //     //Find optimal number to decrease tower height
        //     for(int i = temp - 1; i > 0; i--) {
        //         System.out.println(String.format("Finding max even divider from %s | current: %s", temp, i));
        //         if (temp % i == 0) {
        //             towers.set(0, i);
        //             System.out.println(String.format("Tower decreased height %s", towers.get(0)));
        //             break;
        //         }
        //     }
            
        //     //If the current tower reached height 1, remove it from the pool of playable towers
        //     if(towers.get(0) == 1) {
        //         towers.remove(0);
        //         System.out.println(String.format("Removing tower, current towers available %s", towers.size()));
        //     }
        // }
        
        // System.out.println(String.format("No available plays, winner is %s", rounds % 2 == 0 ? 2 : 0));
        // return rounds % 2 == 0 ? 2 : 1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.towerBreakers(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
