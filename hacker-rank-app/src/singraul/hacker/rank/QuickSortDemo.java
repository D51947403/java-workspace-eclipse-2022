package singraul.hacker.rank;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class QuickSortSolution {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quickSort(List<Integer> arr) {
        
      int left = 0;
      int right = arr.size()-1;
     
      return quickSortSolution(arr, left, right);
      
    }
private static List<Integer> quickSortSolution (List<Integer> arr, int left, int right){
     int pivot=arr.get((left + right)/2);
     int i=left ; int j=right;
    while (i <= j ){
        while( arr.get(i) < pivot){
            i++;
        } 
        while(arr.get(j) > pivot){
            j--;
        }
        if(i <= j){
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j,temp);
            j--;
            i++;
        }
        if(left < j){
            quickSortSolution(arr, left, j);
        }
        if(i < right){
            quickSortSolution(arr, i, right); 
        }
    }
   return arr; 
 }
}

public class QuickSortDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> result = QuickSortSolution.quickSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
