package baekjoon;

import java.io.*;
import java.util.*;

public class Main_3055_탈출 {

	static char[][] map;
	static int R, C;
	static int[] dr = { -1, 1, 0, 0 }; // 위 아래 오른쪽 왼쪽
	static int[] dc = { 0, 0, 1, -1 };
	static int[] dochi; // 고슴도치 시작 위치
	static boolean isArrive; // 고슴도치가 도착했는지 판별
	static int res = Integer.MAX_VALUE; // 고슴도치 도착했을 때 최소로 이동하는 값 출력
	static Queue<int[]> dochiQ; // 고슴도치의 bfs를 위한 큐
	static Queue<int[]> waterQ; // 물 위치 저장을 위한 큐

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		dochi = new int[2];
		dochiQ = new ArrayDeque<>();
		waterQ = new ArrayDeque<>();

		String input;
		for (int i = 0; i < R; i++) { // 맵 초기화
			input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'S') { // 입력값이 S라면 고슴도치 시작 위치와 시작 시간 초기화
					dochiQ.offer(new int[] { i, j, 0 });
				}

				if (map[i][j] == '*') { // 입력값이 D라면 고슴도치 시작 위치 초기화
					waterQ.offer(new int[] { i, j });
				}
			}
		}

		escape();
		
		if (isArrive)
			System.out.println(res);
		else
			System.out.println("KAKTUS");

		br.close();
	}

	private static void escape() {
		while (!dochiQ.isEmpty()) {
			water(); // 우선 물 확장

			int[] cur = new int[3]; // 큐에서 현재 도치 위치 받을 배열
			int nr, nc, ntime;

			int len = dochiQ.size();
			for (int i = 0; i < len; i++) {
				cur = dochiQ.poll();
				ntime = cur[2] + 1;

				for (int j = 0; j < 4; j++) {
					nr = cur[0] + dr[j]; // 다음 도치 위치
					nc = cur[1] + dc[j];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C) // 영역 벗어나면 무시
						continue;

					if (map[nr][nc] == 'D') {	// 비버의 굴에 도착하면 종료
						isArrive = true;
						res = Math.min(res, ntime);
						return;
					}

					if (map[nr][nc] == '.') {
						map[nr][nc] = 'S';
						dochiQ.offer(new int[] { nr, nc, ntime });
					}
				}

			}
		}
	}

	private static void water() { // 물 확장하는 함수
		int[] cur = new int[2];
		int nr, nc;
		int len = waterQ.size();
		for (int i = 0; i < len; i++) {
			cur = waterQ.poll();
			for (int k = 0; k < 4; k++) {
				nr = cur[0] + dr[k];
				nc = cur[1] + dc[k];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C) // 범위 밖이면 무시
					continue;

				if (map[nr][nc] == '.') { // 비어있는 곳만 물 확장 가능
					map[nr][nc] = '*';
					waterQ.offer(new int[] { nr, nc });
				}
			}
		}
	}
}
