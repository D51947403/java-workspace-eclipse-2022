package singraul.stream;
/**
 * https://www.baeldung.com/java-when-to-use-parallel-stream
 */
import java.util.Arrays;
import java.util.List;

public class SequentialStreamDemo {

	public static void main(String[] args) {
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
		
		listOfNumbers.stream().forEach(number ->
	    System.out.println(number + " " + Thread.currentThread().getName()));

	}

}
