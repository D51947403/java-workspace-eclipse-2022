package singraul.hacker.rank;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class InsertionSortDemo {
	public static void insertionSort1(int n, List<Integer> arr) {
		int temp;
		for (int i = n - 1; i > 0; i--) {
			temp = arr.get(i);

			if (arr.get(i - 1) > temp) {
				arr.set(i, arr.get(i - 1));
				printArray(arr);
				arr.set(i - 1, temp);
			}
		}
		printArray(arr);
	}

	public static void printArray(List<Integer> arr) {
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}

		System.out.println("");
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter array elements : ");
		int n=6;
		List<Integer> arrList = Arrays.asList(1,3,4,5, 8, 2);
		insertionSort1(n, arrList);
		
	}
}
