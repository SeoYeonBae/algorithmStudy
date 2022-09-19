package baekjoon.class4;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407_조합 {

	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		BigInteger[] dp = new BigInteger[N + 1];
		BigInteger num;
		dp[1] = new BigInteger("1");
		for (int i = 2; i <= N; i++) {
			num = new BigInteger(String.valueOf(i));
			dp[i] = dp[i - 1].multiply(num);
		}
		
		System.out.println(dp[N].divide(dp[N-M].multiply(dp[M])));
		br.close();
	}
}
