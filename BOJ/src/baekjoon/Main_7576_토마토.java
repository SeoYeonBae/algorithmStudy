package baekjoon;

import java.io.*;
import java.util.*;

public class Main_7576_토마토 {

	static int[][] map;
	static Queue<int[]> q; // 익은 토마토 담을 큐
	static int M, N, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 열의 수
		N = Integer.parseInt(st.nextToken()); // 행의 수
		map = new int[N][M];
		q = new ArrayDeque<>();
		int empty = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					q.offer(new int[] { i, j, 0 });
				else if (map[i][j] == -1)
					empty++;
			}
		}

		if (q.size() == M * N - empty) // 익은 토마토의 수가 배열 칸 수 - 비어있는 칸 수와 동일하다면 이미 다 익은 경우
			System.out.println(0);
		else if (q.size() == 0) // 애초에 익은 토마토가 없다면 토마토는 스스로 익을 수 없기 때문에 -1 출력
			System.out.println(-1);
		else {
			tomato(); // 익은 토마토와 안 익은 토마토가 섞여 있다면 탐색 시작

		}
	}

	private static void tomato() {
		int[] dr = { 0, 0, -1, 1 }; // 왼 오 앞 뒤
		int[] dc = { -1, 1, 0, 0 };
		int[] cur = new int[3];
		int nr, nc, ntime;

		while (!q.isEmpty()) {
			cur = q.poll();
			nr = cur[0];
			nc = cur[1];
			ntime = cur[2] + 1;

			for (int i = 0; i < 4; i++) {
				nr = cur[0] + dr[i];
				nc = cur[1] + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) // 범위 벗어나면 무시
					continue;

				if (map[nr][nc] == 0) { // 인접한 곳이 안 익은 토마토가 있을 경우에만
					map[nr][nc] = 1; // 토마토를 익히고
					q.offer(new int[] { nr, nc, ntime }); // 큐에 넣어줌
					res = Math.max(res, ntime);
				}
			}

		}

		// 토마토 익히기가 다 끝나면 다 익었는지 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) { // 안 익은 토마토가 있으면 -1 출력
					System.out.println(-1);
					return;
				}
			}
		}

		// 위에서 안 걸렸으면 다 익은 경우이기 때문에 초 출력
		System.out.println(res);
	}
}
