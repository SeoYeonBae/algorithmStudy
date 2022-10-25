package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2501_약수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (K == 1) {
			System.out.println(1);
		} else {
			List<Integer> divisor = new ArrayList<Integer>();

			for (int i = 1; i <= Math.sqrt(N); i++) {
				if (N % i == 0) {
					if (i * i == N)
						divisor.add(i);
					else {
						divisor.add(i);
						divisor.add(N / i);
					}
				}
			}

			if (divisor.size() < K)
				System.out.println(0);
			else {
				Collections.sort(divisor);
				System.out.println(divisor.get(K - 1));
			}
		}
		br.close();
	}
}
