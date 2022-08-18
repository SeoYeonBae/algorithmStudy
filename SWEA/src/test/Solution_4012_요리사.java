package test;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {

	static int N; // 재료의 수
	static int[][] map; // 재료 시너지 배열
	static int[] A, B; // 재료 조합 만들기 위한 배열
	static int[] idxA, idxB; // 재료 조합의 시너지를 계산하기 위한 순서 조합
	static boolean[] isA;
	static int res; // 두 음식간의 최소
	static int sumA, sumB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		idxA = new int[2];
		idxB = new int[2];

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			A = new int[N / 2];
			B = new int[N / 2];
			isA = new boolean[N];
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			res = Integer.MAX_VALUE;
			combA(0, 0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}

		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

	private static void combA(int cnt, int start) { 
		if (cnt == N / 2) {
			int k = 0;
			for (int i = 0; i < N; i++) {	// A 조합 만들면 B 조합 만들기
				if (isA[i])continue; // A에서 썼으면 무시
				B[k++] = i;
			}
			cookingComb(0, 0);
			res = Math.min(res, Math.abs(sumA - sumB));
			sumA = 0;
			sumB = 0;
			return;
		}

		for (int i = start; i < N; i++) {	// A 조합 만들기
			A[cnt] = i;
			isA[i] = true;
			combA(cnt + 1, i + 1);
			isA[i] = false;
		}
	}
	
	private static void cookingComb(int cnt, int start) {
		if (cnt == 2) {
			int synergyA = map[idxA[0]][idxA[1]] + map[idxA[1]][idxA[0]];
			int synergyB = map[idxB[0]][idxB[1]] + map[idxB[1]][idxB[0]];

			sumA += synergyA;
			sumB += synergyB;

			return;
		}

		for (int i = start; i < N / 2; i++) {
			idxA[cnt] = A[i];
			idxB[cnt] = B[i];
			cookingComb(cnt + 1, i + 1);
		}
	}
}
