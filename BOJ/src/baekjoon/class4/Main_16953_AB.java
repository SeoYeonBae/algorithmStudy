package baekjoon.class4;

import java.io.*;
import java.util.StringTokenizer;

public class Main_16953_AB {

	static long M;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		res = Integer.MAX_VALUE;
		dfs(N, 0);
		if (res != Integer.MAX_VALUE)
			System.out.println(res + 1);
		else
			System.out.println(-1);
		
		br.close();
	}

	private static void dfs(long num, int cnt) {
		if (num > M) {
			return;
		} else if (num == M) {
			if (cnt < res)
				res = cnt;
			return;
		} else {
			dfs(num * 2, cnt + 1);
			dfs(Long.parseLong(num + "" + 1), cnt + 1);
		}
	}
}
