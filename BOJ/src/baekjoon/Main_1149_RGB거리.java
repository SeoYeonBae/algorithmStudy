package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] homes = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				homes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] cost = new int[3];
		Arrays.fill(cost, 0);

		for (int i = 1; i < N; i++) {
			homes[i][0] = Math.min(homes[i - 1][1], homes[i - 1][2]) + homes[i][0];
			homes[i][1] = Math.min(homes[i - 1][0], homes[i - 1][2]) + homes[i][1];
			homes[i][2] = Math.min(homes[i - 1][0], homes[i - 1][1]) + homes[i][2];
		}

		int result = Math.min(homes[N-1][0], homes[N-1][1]);
		result = Math.min(result, homes[N-1][2]);
		System.out.println(result);
		br.close();
	}
}
