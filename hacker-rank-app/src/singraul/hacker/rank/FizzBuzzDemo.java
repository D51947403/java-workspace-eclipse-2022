package singraul.hacker.rank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class FizzBuzz {

	/*
	 * Complete the 'fizzBuzz' function below.
	 *
	 * The function accepts INTEGER n as parameter.
	 */

	public static void fizzBuzz(int n) {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0 && i % 5 != 0) {
				System.out.println("Fizz");
			} else if (i % 3 != 0 && i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

}

public class FizzBuzzDemo {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter value of n ");
		int n = Integer.parseInt(bufferedReader.readLine().trim());

		FizzBuzz.fizzBuzz(n);

		bufferedReader.close();
	}
}
