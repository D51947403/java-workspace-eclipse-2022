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

class MaxSubarray {

	/*
	 * Complete the 'maxSubarray' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY arr as parameter.
	 */
	// Kadane's Algorithm
	public static List<Integer> maxSubarray(List<Integer> arr) {
		int maxSA = arr.get(0);// sub array sum
		int maxSS = arr.get(0);// sub sequence sum
		int maxArr = arr.get(0);// max array value
		for (int i = 1; i < arr.size(); i++) {
			maxArr = Math.max(maxArr + arr.get(i), arr.get(i));
			maxSA = Math.max(maxSA, maxArr);
			maxSS = Math.max(Math.max(maxSS, arr.get(i)), maxSS + arr.get(i));
		}
		List<Integer> result = new ArrayList<>();
		result.add(maxSA);
		result.add(maxSS);
		return result;
	}

}

public class MaxSubarrayDemo {
	public static void main(String[] args) throws IOException {
		List<Integer> arr = Arrays.asList(-2, 3, -1, -4, -6);

		List<Integer> result = MaxSubarray.maxSubarray(arr);
		System.out.print(result);

	}
}
