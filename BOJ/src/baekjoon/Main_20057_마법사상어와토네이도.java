package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static double[] rate = { 0.05, 0.1, 0.1, 0.07, 0.02, 0.07, 0.02, 0.01, 0.01 };
	static int[][] rateR = { { 0, -1, 1, -1, -2, 1, 2, -1, 1 }, { 2, 1, 1, 0, 0, 0, 0, -1, -1 },
			{ 0, 1, -1, 1, 2, -1, -2, 1, -1 }, { -2, -1, -1, 0, 0, 0, 0, 1, 1 } };
	static int[][] rateC = { { -2, -1, -1, 0, 0, 0, 0, 1, 1 }, { 0, -1, 1, -1, -2, 1, 2, -1, 1 },
			{ 2, 1, 1, 0, 0, 0, 0, -1, -1 }, { 0, 1, -1, 1, 2, -1, -2, 1, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int startR = N / 2;
		int startC = N / 2;
		int res = 0;
		int dis = 0;
		// 이동해야하는 칸
		int jump = 1;
		// 이동한 횟수
		int jumpCnt = jump;
		while (true) {
			if(startR == 0 && startC == 0)
				break;
			
			jumpCnt--;
			int d = dis % 4;
			startR += dr[d];
			startC += dc[d];

			// 알파 위치에 저장할 값
			int alpha = map[startR][startC];
			// y에 있는 원래 모래의 양
			int originAmount = map[startR][startC];

			// 모래 흩날리기
			for (int i = 0; i < 9; i++) {
				int r = startR + rateR[d][i];
				int c = startC + rateC[d][i];
				// 흩날리는 모래 양
				int dust = (int) (originAmount * rate[i]);
				// 범위를 벗어남 = 밖으로 나간 모래
				if (r < 0 || r >= N || c < 0 || c >= N) {
					res += dust;
					alpha -= dust;
					continue;
				}
				alpha -= dust;
				map[r][c] += dust;
			}
			int alphaR = startR + dr[d];
			int alphaC = startC + dc[d];
			// 알파가 범위를 벗어남 = 밖으로 나감
			if (alphaR < 0 || alphaR >= N || alphaC < 0 || alphaC >= N)
				res += alpha;
			else
				map[alphaR][alphaC] += alpha;
			map[startR][startC] = 0;
			
			// y의 모래 초기화

			// 이동할 칸만큼 다 이동함
			if (jumpCnt == 0) {
				// 방향 바꾸기
				dis++;
				// 오른쪽 이동으로 바뀔 때 이동해야 하는 칸 하나 늘어남
				if (dis % 4 == 2)
					jump++;
				// 아래쪽 이동으로 바뀔 때 이동해야 하는 칸 하나 늘어남
				else if (dis % 4 == 0)
					jump++;

				jumpCnt = jump;
			}
		}
		System.out.println(res);
	}
}
