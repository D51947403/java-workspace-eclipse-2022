package singraul.hacker.rank;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MaxConnectedRegion {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */
   static int maxConnectedCells=0;
    public static int connectedCell(List<List<Integer>> matrix) {
        for (int i=0; i< matrix.size(); i++){
            for(int j=0; j<matrix.get(i).size(); j++){
                if(matrix.get(i).get(j)==1){
                  dfs(matrix, i, j,0) ;
                }
            }
        }
        return maxConnectedCells;
    }

private static void dfs(List<List<Integer>> matrix , int i , int j, int currCell ){
    if( i < 0 || i >= matrix.size()|| j<0 || j>= matrix.get(0).size() || 
    matrix.get(i).get(j)==0 ){
        return ;
    } 
    currCell++;
    matrix.get(i).set(j, 0 );
    maxConnectedCells=Math.max(maxConnectedCells, currCell);
    
    dfs(matrix, i, j-1,currCell);// left
    dfs(matrix, i, j+1,currCell); //right
    dfs(matrix, i-1, j,currCell); //top
    dfs(matrix, i+1, j,currCell); // down
    dfs(matrix, i-1, j-1,currCell); // top left
    dfs(matrix, i-1, j+1,currCell);// top right
    dfs(matrix, i+1, j-1,currCell); // bottom left
    dfs(matrix, i+1, j+1,currCell); // bottom right
     matrix.get(i).set(j, 1 );
}
}
public class MaxConnectedCellDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = MaxConnectedRegion.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
