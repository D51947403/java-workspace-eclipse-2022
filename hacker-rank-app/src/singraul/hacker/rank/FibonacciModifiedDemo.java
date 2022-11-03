package singraul.hacker.rank;

import java.io.IOException;
import java.math.BigInteger;

class FibonacciModified {

	/*
	 * Complete the 'fibonacciModified' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER t1 2. INTEGER t2 3. INTEGER n
	 */

	public static BigInteger fibonacciModified(int t1, int t2, int n) {
		    BigInteger fn=new BigInteger("0");
		    BigInteger f1=new BigInteger(Integer.toString(t1));
		    BigInteger f2=new BigInteger(Integer.toString(t2));
		for (int i = 3; i <= n; i++) {
			fn = f1.add(f2.multiply(f2));
			f1 = f2;
			f2 = fn;
		}
		return fn;
	}

}

public class FibonacciModifiedDemo {
	public static void main(String[] args) throws IOException {

		BigInteger result = FibonacciModified.fibonacciModified(0, 1, 5);
		System.out.println("result " + result);

	}
}
