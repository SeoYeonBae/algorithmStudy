package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {

	static int[][] map;
	static int N, M;
	static Queue<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 4:
				method4();
				break;
			case 5:
				method5();
				break;
			case 6:
				method6();
				break;
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static void method1() { // 상하 반전
		int tmp;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				tmp = map[i][j];
				map[i][j] = map[N - 1 - i][j];
				map[N - 1 - i][j] = tmp;
			}
		}
	}

	private static void method2() { // 좌우 반전
		int tmp;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				tmp = map[i][j];
				map[i][j] = map[i][M - 1 - j];
				map[i][M - 1 - j] = tmp;
			}
		}
	}

	private static void method3() { // 오른쪽 90도 회전
		int[][] newMap = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				newMap[j][N - 1 - i] = map[i][j];
		}

		map = newMap;

		int tmp = N;
		N = M;
		M = tmp;
	}

	private static void method4() { // 왼쪽 90도 회전
		int[][] newMap = new int[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				newMap[M - 1 - j][i] = map[i][j];
		}

		map = newMap;

		int tmp = N;
		N = M;
		M = tmp;

	}

	private static void method5() {
		int[][] newMap = new int[N][M];
		
		// 4 -> 1
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++)
				newMap[i - N/2][j] = map[i][j];
		}
		// 3- > 4
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++)
				newMap[i][j - M/2] = map[i][j];
		}
		// 1 -> 2
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++)
				newMap[i][j + M/2] = map[i][j];
		}
		// 2 -> 3
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++)
				newMap[i + N/2][j] = map[i][j];
		}
		
		map = newMap;
	}

	private static void method6() {
		int[][] newMap = new int[N][M];
		// 배열 정보 큐에 담기 2 -> 1 -> 3 -> 4
		// 2 -> 1
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++)
				newMap[i][j - M/2] = map[i][j];
		}
		// 1 -> 4
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++)
				newMap[i + N/2][j] = map[i][j];
		}
		// 3 -> 2
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++)
				newMap[i - N/2][j] = map[i][j];
		}
		// 4 -> 3
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++)
				newMap[i][j + M/2] = map[i][j];
		}
		
		map = newMap;
	}

}
