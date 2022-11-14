package d4;

import java.io.*;
import java.util.*;

public class Solution_1486_장훈이의높은선반 {

	static int N, B, res;
	static int[] height;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 점원의 수
			B = Integer.parseInt(st.nextToken());	// 선반의 높이
			
			height = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());	// 점원들의 키
			}
			
			res = Integer.MAX_VALUE;
			subset(0, 0);
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void subset(int cnt, int sum) {
		if(cnt == N) {
			if(sum < B)
				return;
			sum -= B;
			res = Math.min(res, sum);
			return;
		}
		
		subset(cnt + 1, sum + height[cnt]);	// 해당 점원 선택 o
		subset(cnt + 1, sum);	// 해당 점원 선택 x
	}
}
