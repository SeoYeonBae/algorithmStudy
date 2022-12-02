package dp;

import java.util.Scanner;

/**
 * @author taeheekim
 */
public class DP3_BinomialCoefTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N차 다항식
		int K = sc.nextInt(); // K항
		int[][] B = new int[N+1][N+1];
//		int[][] B = new int[N+1][K+1];
		
		for(int i=0; i<=N; ++i) {
//			int end = i<K? i : K; // i차와 k항중 작은값 까지만 구하기. 
			for(int j=0; j<=i; ++j) {
//			for(int j=0; j<=end; ++j) {
				if(j==0 || j==i) B[i][j] = 1;// nC0=1, nCn =1로 채움.
				else B[i][j] = B[i-1][j-1] + B[i-1][j];
			}
		}
		System.out.println(B[N][K]);
	}

}
