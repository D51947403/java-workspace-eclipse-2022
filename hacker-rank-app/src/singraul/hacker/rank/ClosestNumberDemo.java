package singraul.hacker.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestNumberDemo {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(8, 7, 1, 2, 4, 9);
		System.out.print(closestNumbers(arr));
	}

	public static List<Integer> closestNumbers(List<Integer> arr) {
		// [1, 2, 4, 7, 8, 9]
		Collections.sort(arr);
		
		List<Integer> resultList = new ArrayList<Integer>();
		int minDiff = arr.get(1) - arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			if (minDiff == arr.get(i) - arr.get(i - 1)) {
				resultList.add(arr.get(i - 1));
				resultList.add(arr.get(i));
			} else if (minDiff > arr.get(i) - arr.get(i - 1)) {
				resultList.clear();
				minDiff = arr.get(i) - arr.get(i - 1);
				resultList.add(arr.get(i - 1));
				resultList.add(arr.get(i));
			}
		}

		return resultList;
	}
}
