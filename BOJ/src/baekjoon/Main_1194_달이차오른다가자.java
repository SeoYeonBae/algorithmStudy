package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1194_달이차오른다가자 {

	static int N, M, min;
	static int[][] map;
	static HashSet<Integer> keys;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {

//		System.out.println((int)'.'); //46
//        System.out.println((int)'#'); //35
//        System.out.println((int)'a'); //97
//        System.out.println((int)'A'); //65
//        System.out.println((int)'0'); //48
//        System.out.println((int)'1'); //49
//		f : 102 , F : 70
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][1 << 6];
		keys = new HashSet<>();
		String input;
		int r = 0, c = 0;
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 48) {
					r = i;
					c = j;
				}
			}
		}
		min = Integer.MAX_VALUE;
		moon(r, c);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		br.close();
	}

	private static void moon(int a, int b) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] { a, b, 0, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int cnt = cur[2];
			int key = cur[3];

			if (cnt > min) // 이미 도착한 경로의 cnt값 보다 크면 볼 필요 없음
				continue;

			if (map[r][c] == 49) { // 1에 도착했을 때
				min = cnt < min ? cnt : min;
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				int newKey = key;
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) // 범위 밖
					continue;

				if (visited[nr][nc][key])
					continue;

				if (map[nr][nc] == 35) // 벽 만나면
					continue;

				if (map[nr][nc] >= 97) { // 열쇠 만나면
					newKey = 1 << (map[nr][nc] - 97) | key;
				}
				
				if (map[nr][nc] >= 65 && map[nr][nc] <= 70) // 문 만나면
					if ((key & (1 << (map[nr][nc] - 65))) == 0) {
						continue;
					}
				

				visited[nr][nc][newKey] = true;
				q.offer(new int[] { nr, nc, cnt + 1, newKey });
			}
		}
	}

}
