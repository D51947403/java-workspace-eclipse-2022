package singraul.hacker.rank;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class RunningTimeDemo {

    /*
     * Complete the 'runningTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int runningTime(List<Integer> arr) {
    // Write your code here
    int shiftCount=0;
    int n= arr.size();
         for(int i=0; i<n; i++){
             int j=i;
             while(j>0){
                 if(arr.get(j) < arr.get(j-1)){
                   int temp = arr.get(j);
                   arr.set(j, arr.get(j-1));
                   arr.set(j-1, temp);  
                   shiftCount++;
                 }
                 j--;
             }
         }
          return shiftCount;
    }

}

public class InsertionSortRunningTime {
    public static void main(String[] args) throws IOException {
   
		List<Integer> arrList = Arrays.asList(1,3,4,5, 8, 2);
		RunningTimeDemo.runningTime(arrList);
    }
}