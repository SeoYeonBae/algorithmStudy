package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2096_내려가기 {

	static int[][] map, maxMap, minMap;
	static int[] dc = { -1, 0, 1 };
	static int N, max, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		maxMap = new int[2][3];
		minMap = new int[2][3];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if(j == 0) {
					maxMap[1][0] = Math.max(maxMap[0][0], maxMap[0][1]) + map[i][0];
					minMap[1][0] = Math.min(minMap[0][0], minMap[0][1]) + map[i][0];
				}else if(j == 1) {
					maxMap[1][1] = Math.max(maxMap[0][0], Math.max(maxMap[0][1], maxMap[0][2])) + map[i][1];
					minMap[1][1] = Math.min(minMap[0][0], Math.min(minMap[0][1], minMap[0][2])) + map[i][1];
				}else {
					maxMap[1][2] = Math.max(maxMap[0][1], maxMap[0][2]) + map[i][2];
					minMap[1][2] = Math.min(minMap[0][1], minMap[0][2]) + map[i][2];
				}
			}
			maxMap[0] = maxMap[1].clone();
			minMap[0] = minMap[1].clone();
			Arrays.fill(maxMap[1], 0);
			Arrays.fill(minMap[1], 0);
		}
		
		max = Math.max(maxMap[0][0], Math.max(maxMap[0][1], maxMap[0][2]));
		min = Math.min(minMap[0][0], Math.min(minMap[0][1], minMap[0][2]));
		
		sb.append(max).append(" ").append(min);
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}
