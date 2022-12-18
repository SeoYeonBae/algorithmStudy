package baekjoon.samgsung;

import java.io.*;
import java.util.*;

public class Main_16234_인구이동 {

	static int N, L, R, res, idx, cnt;
	static int[][] map, line;
	static boolean[][] visit;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] avg;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[N][N];

		go();
		System.out.println(res);
	}

	private static void go() {

		while (true) {
			idx = 1;	// 연합 번호
			avg = new int[N * N + 1];	// 연합의 평균 인구수
			line = new int[N][N];	// 각 칸이 몇 번 연합인지 표시
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (line[i][j] == 0) {
						cnt = 1;	// 엽합 인구의 평균값을 구하기 위해 몇 개의 칸을 합쳤는지 세어줌
						avg[idx] = map[i][j];	// 현재 있는 칸의 인구수 더해줌
						line[i][j] = idx;	// 현재 칸을 하나의 영역으로 초기화 하고 국경선 열러 감
						divide(i, j);
						avg[idx] /= cnt;	// 평균 값으로 바꿔줌
						idx++;	// 다음 연합 구하러 감
					}
				}
			}
			 
			if (idx == N * N + 1)	// 다 개별연합이라면 국경선을 열 수 없는 상황이라 함수 종료
				return;
			
			res++;	// 인구 이동 발생일 수++
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = avg[line[i][j]];	// 인구 수 평균으로 바꿔줌
				}
			}
		}
	}

	private static void divide(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;

			if (line[nr][nc] != 0)	// 이미 다른 연합이라면 패스
				continue;

			int minus = Math.abs(map[r][c] - map[nr][nc]);
			if (minus < L || minus > R)	// 국경선을 열 수 있는지 조건 확인
				continue;

			cnt++;	// 연합을 이루는 칸의 개수++
			avg[idx] += map[nr][nc];	// 현재 칸의 인구수 더해줌
			line[nr][nc] = idx;	// 연합 번호 표시
			divide(nr, nc);
		}

	}
}
