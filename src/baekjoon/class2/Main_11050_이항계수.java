package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11050_이항계수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(fac(N) / (fac(N - K) * fac(K)));
	}

	private static int fac(int n) {
		int res = 1;
		for(int i = 1; i <= n; i++)
			res *= i;
		return res;
	}

}
