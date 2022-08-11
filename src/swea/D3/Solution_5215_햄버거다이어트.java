package swea.D3;

import java.io.*;
import java.util.*;

public class Solution_5215_햄버거다이어트 {

	static int[] cal, score, hamburger;
	static int L, N;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 재료의 수
		L = Integer.parseInt(st.nextToken()); // 제한 칼로리

		hamburger = new int[N];
goa
		score = new int[N];
		cal = new int[N];

		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}

			sb.append("#").append(tc).append(" ").append(max);
			max = 0;
		}
		System.out.println(sb);
		br.close();
	}


}
