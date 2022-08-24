package baekjoon;

import java.io.*;
import java.util.*;

public class Main_16236_아기상어 {

	static int N;
	static int[][] map, dist;
	static Queue<int[]> q;
	static PriorityQueue<int[]> eatQ;
	static int size, eat; // 상어 사이즈, 먹은 물고기 수
	static int fishCnt, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		q = new ArrayDeque<int[]>();
		eatQ = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] != o2[2]) // 거리가 다르다면
					return o1[2] - o2[2]; // 거리로 오름차순
				else { // 거리가 같다면 행을 판별 -> 행이 다르다면 가장 위쪽, 행이 같다면 가장 왼쪽
					return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
				}
			}
		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) { // 애기라면 좌표 저장
					q.offer(new int[] { i, j, 0 });
					map[i][j] = 0;
				} else if (map[i][j] > 0) { // 물고기라면
					fishCnt++;
				}

			}
		}

		size = 2; // 초기 상어 사이즈는 2

		if (!q.isEmpty()) // 물고기가 있을 때만 탐색
			eating();

		System.out.println(res);

		br.close();
	}

	private static void eating() {
		int[] dr = { 0, 0, -1, 1 }; // 왼 오 앞 뒤
		int[] dc = { -1, 1, 0, 0 };
		int[] cur = new int[3];
		int nr, nc, ndist;
		while (true) {
			dist = new int[N][N];

			while (!q.isEmpty()) {
				cur = q.poll();
				nr = cur[0];
				nc = cur[1];
				ndist = cur[2] + 1;

				for (int i = 0; i < 4; i++) {
					nr = cur[0] + dr[i];
					nc = cur[1] + dc[i];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N) // 범위 벗어나면 무시
						continue;

					if (dist[nr][nc] != 0) // 방문한 곳 무시
						continue;

					if (map[nr][nc] > size) // 물고기가 상어보다 커서 못 가면 무시
						continue;

					// 물고기가 상어랑 같거나 작을 때는 갈 수 있음
					dist[nr][nc] = ndist;	// 걸린 시간으로 바꿔줌
					q.offer(new int[] { nr, nc, ndist });
					if (map[nr][nc] != 0 && map[nr][nc] < size) // 먹을 수 있는 물고기라면?
						eatQ.offer(new int[] { nr, nc, dist[nr][nc] });	// 먹을 수 있는 물고기 배열에 저장 -> 자동 정렬

				}
			}
			
			if (eatQ.size() == 0)  // 먹을 수 없는 물고기 없으면 return
				return;

			int[] curEat = eatQ.poll();

			map[curEat[0]][curEat[1]] = 0;
			res = curEat[2];
			eat++;
			q.offer(new int[] { curEat[0], curEat[1], curEat[2] });

			if (eat == size) {
				size++;
				eat = 0;
			}
			eatQ.clear();
		}

	}
}
