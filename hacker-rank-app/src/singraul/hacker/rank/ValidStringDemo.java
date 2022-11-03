package singraul.hacker.rank;
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

class ValidString {

    /*
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
         if( s.length() ==1)
         return "YES";
         
         char [] charArr = s.toCharArray();
         HashMap <Character, Integer> map = new HashMap<>();
         for( char c : charArr){
             map.put(c, map.getOrDefault(c, 0)+1);
         }
         int [] freqArr = new int[map.size()];
         int i=0;
         for( Map.Entry<Character, Integer> entry : map.entrySet() ){
             freqArr[i]=entry.getValue();
             i++;
         }
         Arrays.sort(freqArr);
         int first=freqArr[0] ;
         int second =freqArr[1];
         int last = freqArr[freqArr.length-1];
         int secondLast = freqArr[freqArr.length-2];
       
         if( last == first)
           return "YES";
         if (secondLast==first && last==secondLast+1)
           return "YES";
         if (first==1 && second==last)
          return "YES";
          
         return "NO";
    }

}

public class ValidStringDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = ValidString.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
