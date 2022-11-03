package singraul.stream;

/**
 * https://www.baeldung.com/java-when-to-use-parallel-stream
 */
import java.util.Arrays;
import java.util.List;

public class ParallelStreamDemo {
	public static void main(String[] args) {
		List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);

		listOfNumbers.parallelStream()
				.forEach(number -> System.out.println(number + " " + Thread.currentThread().getName()));

		int sum = listOfNumbers.parallelStream().reduce(0, Integer::sum) + 5;
		System.out.println("Sum : " + sum);
	}
}
