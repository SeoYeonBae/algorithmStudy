package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_11559_PuyoPuyo {

	static char[][] map;
	static boolean[][] visited;
	static boolean isPossible;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String input = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		isPossible = true; // 터질 뿌요가 있는지 확인
		int thisPop; // 이번 판에 터진 수
		int resCnt = 0; // 연쇄로 터지는 수 = 출력 값

		while (isPossible) {
			thisPop = 0;
			visited = new boolean[12][6];
			for (int i = 0; i < 6; i++) {
				for (int j = 11; j >= 0; j--) {
					if (!visited[j][i] && map[j][i] != '.') {
						if (puyo(map[j][i], j, i)) {
							thisPop++;
						}
					}
				}
			}
			if (thisPop == 0)
				isPossible = false;
			else
				resCnt += 1;

			down();
		}

		System.out.println(resCnt);
	}

	private static boolean puyo(char color, int r, int c) {
		Queue<int[]> lookQ = new ArrayDeque<>(); // 터지는지 확인할 목록
		Queue<int[]> popQ = new ArrayDeque<>(); // 터질 목록
		lookQ.offer(new int[] { r, c });
		popQ.offer(new int[] { r, c });

		while (!lookQ.isEmpty()) {
			int[] cur = lookQ.poll();

			visited[cur[0]][cur[1]] = true;

			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];

				if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6)
					continue;

				if (map[nr][nc] == color && !visited[nr][nc]) {
					lookQ.offer(new int[] { nr, nc });
					popQ.offer(new int[] { nr, nc });
				}
			}
		}

		if (popQ.size() >= 4) { // 터질 뿌요가 4개 이상
			while (!popQ.isEmpty()) {
				int[] cur = popQ.poll();
				map[cur[0]][cur[1]] = '.';
			}
			return true;
		}

		return false;
	}

	private static void down() {
		Queue<Character> q = new ArrayDeque<Character>();
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j >= 0; j--) {
				if (map[j][i] != '.') {	// .이 아닌 문자를 아래에서부터 하나씩 큐에 담음 
					q.offer(map[j][i]);
					map[j][i] = '.';
				}
			}
			int idx = 11;
			while (!q.isEmpty()) {	// 아래부터 다시 차곡차곡 집어넣음
				map[idx--][i] = q.poll();
			}
		}
	}
}
