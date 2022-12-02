package dp;

import java.util.Scanner;

/**
 * @author taeheekim
 */
public class DP1_FibonacciTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] D = new long[N+1];
		D[1] = 1;
		for(int i=2; i<=N; ++i) {
			D[i] = D[i-2]+D[i-1];
		}
		System.out.println(D[N]);

	}

}
