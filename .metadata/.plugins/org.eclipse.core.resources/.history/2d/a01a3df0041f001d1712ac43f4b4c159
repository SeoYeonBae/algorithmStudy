package swea.D3;

import java.io.*;
import java.util.*;

public class Solution_5215_햄버거다이어트 {

	static int[] cal, score;
	static int L, N;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());


		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			max = 0;
			score = new int[N];
			cal = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static void comb(int start, int sumScore, int sumCal) {
		for (int i = start; i < N; i++) {
			if (sumCal + cal[i] <= L) {
				int nextScore = sumScore + score[i];
				int nextCal = sumCal + cal[i];				
				if (max < nextScore)
					max = nextScore;
				comb(i + 1, nextScore, nextCal);
			}
		}
	}
}
