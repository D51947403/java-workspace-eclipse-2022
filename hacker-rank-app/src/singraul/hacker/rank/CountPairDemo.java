package singraul.hacker.rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CountPairDemo {

	public static void main(String[] args) {
		
		int k=3;
		List<Integer> arrList = Arrays.asList(1,3,4,5, 8, 2);
         int result = countPair(arrList , k);
         System.out.println("Result "+result);
	}

	private static int countPair(List<Integer> arrList, int k) {
		HashSet<String>  countSet = new HashSet<String>();
		
		Collections.sort(arrList);
		int i=0, j=0;
		int diff =0;
		
		while (j < arrList.size() && i < arrList.size()) {
			diff= arrList.get(j) -arrList.get(i);
			if(diff < k)
				j++;
			else if(diff > k)
				i++;
			else if (diff ==k) {
				countSet.add(arrList.get(i)+""+arrList.get(j));
				i++; j++;
			}
				
		}
		return countSet.size();
	}

}
