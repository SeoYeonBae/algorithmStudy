package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1351_무한수열 {

	static long N, P, Q;
	static Map<Long, Long> A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Long.parseLong(st.nextToken());
		Q = Long.parseLong(st.nextToken());
		
		A = new HashMap<Long, Long>();
		A.put(0L, 1L);
		System.out.println(solve(N));
		
//		for (long i = 1; i <= N; i++) {
//			long x1 = i / P;
//			long x2 = i / Q;
//			
//			A.put(i, A.get(x1) + A.get(x2));
//		}
//		System.out.println(A.get(N));
	}

	private static long solve(long i) {
		if(i == 0) return 1;
		
		if(A.containsKey(i)) return A.get(i);
		
		A.put(i, solve(i / P) + solve(i / Q));
		
		return A.get(i);
		
	}
}
