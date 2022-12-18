package baekjoon.samgsung;

import java.io.*;
import java.util.*;

public class Main_16236_아기상어_re {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int sharkR, sharkC, sharkSize, time, eatCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) { // 아기 상어 정보 저장
					sharkR = i;
					sharkC = j;
					map[i][j] = 0;
				} else if (map[i][j] != 0)
					flag = true;
			}
		}
		if (flag){
			sharkSize = 2;
			go();
		}
		System.out.println(time);
		br.close();
	}

	private static void go() {
		PriorityQueue<int[]> eatList = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] != o2[2]) // 거리가 다르다면 거리순으로 오름차순
					return o1[2] - o2[2];
				else { // 거리가 같다면
					if (o1[0] != o2[0])
						return o1[0] - o2[0]; // 가장 위쪽
					else
						return o1[1] - o2[1]; // 가장 왼쪽
				}
			}
		});

		Queue<int[]> move = new ArrayDeque<int[]>();
		int[] dr = { -1, 0, 0, 1 };
		int[] dc = { 0, -1, 1, 0 };
		while (true) {
			visited = new boolean[N][N];
			move.offer(new int[] { sharkR, sharkC, 0 });
			visited[sharkR][sharkC] = true;
			int curDist = -1;
			
			while (!move.isEmpty()) {
				int[] cur = move.poll();
				int r = cur[0];
				int c = cur[1];
				int moveCnt = cur[2];
				
				if(moveCnt == curDist) // 이미 찾은 물고기의 거리와 같은 곳에서 시작한다면 아래에서 상어가 이동하면서 거리가 더 걸릴테니 탐색하지 않음
					continue;
				
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;

					if (visited[nr][nc])
						continue;

					if (map[nr][nc] > sharkSize)
						continue;

					visited[nr][nc] = true;
					move.offer(new int[] { nr, nc, moveCnt + 1 });
					
					if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
						eatList.offer(new int[] { nr, nc, moveCnt + 1 });
						curDist = moveCnt + 1;
					}

				}
			}
			if (eatList.size() == 0)
				return;

			int[] curEat = eatList.poll();
			sharkR = curEat[0];
			sharkC = curEat[1];
			time += curEat[2];
			eatCnt += 1;
			map[sharkR][sharkC] = 0;
			eatList.clear();

			if (eatCnt == sharkSize) {
				sharkSize++;
				eatCnt = 0;
			}
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println(time + "초, 상어 사이즈 : " + sharkSize + ", 먹은 물고기 : " + eatCnt);
		}
	}
}
