package singraul.hacker.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrimeDigitSumsDemo {
	 public static boolean isPrime[] = new boolean[46];

		public static int results[] = new int[400001];

		public static boolean isGood(int n, int val) {
			int max = Math.min(n, 5);
			int mod = 100;
			for (int i = 3; i <= max; i++) {
				mod *= 10;
				int d = val;
				for (int j = 0; j < (max - i + 1); j++) {
					int d2 = d % mod;
					int sum = 0;
					while (d2 > 0) {
						sum += d2 % 10;
						d2 /= 10;
					}
					if (!isPrime[sum]) {
						return false;
					}
					d = d / 10;
				}
			}
			return true;
		}
		
		public static void initSimple() {
			for(int i=100; i<1000; i++) {
				if(isGood(3,i)) {
					results[3]++;
				}
			}
			
			for(int i=1000; i<10000; i++) {
				if(isGood(4,i)) {
					results[4]++;
				}
			}
			results[1]=9;
	        results[2]=90;
		}

		public static void init() {

			Arrays.fill(isPrime, 0, isPrime.length, true);
			isPrime[0] = false;
			isPrime[1] = false;
			for (int i = 2; i < 45; i++) {
				if (isPrime[i]) {
					for (int j = 2; j < i; j++) {
						if (i % j == 0) {
							isPrime[i] = false;
						}
					}
				}
			}

			ArrayList<Integer> good = new ArrayList<Integer>();
			for (int i = 0; i < 100000; i++) {
				if (isGood(5, i)) {
					good.add(i);
				}
			}
			List<Integer> childs[] = new List[good.size()];
			for (int i = 0; i < good.size(); i++) {
				int val = (good.get(i) % 10000) * 10;
				childs[i] = new ArrayList<Integer>();
				for (int j = 0; j < 10; j++) {
					if (good.contains(val + j)) {
						childs[i].add(good.indexOf(val + j));
					}
				}
			}

			int buf1[] = new int[good.size()];
			int buf2[] = new int[good.size()];
			int temp[];
			int count = 0;
			for (int i = 0; i < buf1.length; i++) {
				if (good.get(i) >= 10000) {
					buf1[i] = 1;
					count++;
				}
			}
			results[5] = count;
			int idx = 0;
			for (int i = 6; i < results.length; i++) {
				Arrays.fill(buf2, 0, buf2.length, 0);
				count = 0;

				for (int j = 0; j < buf1.length; j++) {
					if (buf1[j] > 0) {
						List<Integer> next = childs[j];
						for (int k = 0; k < next.size(); k++) {
							idx = next.get(k);
							buf2[idx] += buf1[j];
							buf2[idx] %= 1000000007;
							count += buf1[j];
							count %= 1000000007;
						}
					}
				}
				results[i]=count;
				temp=buf1;
				buf1=buf2;
				buf2=temp;		

			}
		}

	    public static void main(String[] args) {
	        init();
			initSimple();
	        Scanner in = new Scanner(System.in);
	        int q = in.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int n = in.nextInt();
	            System.out.println(results[n]);
	        }
	    }
	
}
