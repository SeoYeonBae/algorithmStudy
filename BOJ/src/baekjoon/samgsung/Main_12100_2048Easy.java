package baekjoon.samgsung;

import java.io.*;
import java.util.*;

public class Main_12100_2048Easy {

	static int N, res;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go(map, 0);
		System.out.println(res);
		br.close();
	}

	private static void go(int[][] map, int depth) {
		if (depth == 5) {
			int ans = findMax(map);
			res = res < ans ? ans : res;
			return;
		}
		for (int i = 0; i < 4; i++) {
			int[][] copyMap = copyMap(map);
			int[][] moveMap = moveBricks(copyMap, i);
			go(moveMap, depth + 1);
		}
	}

	private static int[][] moveBricks(int[][] copyMap, int dir) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		switch (dir) {
		case 0:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copyMap[j][i] != 0) {
						q.offer(copyMap[j][i]);
						copyMap[j][i] = 0;
					}
				}

				int idx = 0;
				while (!q.isEmpty()) {
					int num = q.poll();
					if (copyMap[idx][i] == 0) {
						copyMap[idx][i] = num;
					} else {
						if (copyMap[idx][i] == num) {
							copyMap[idx][i] = num * 2;
							idx++;
						} else {
							idx++;
							copyMap[idx][i] = num;
						}
					}

				}
			}
			break;
		case 2:
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (copyMap[j][i] != 0) {
						q.offer(copyMap[j][i]);
						copyMap[j][i] = 0;
					}
				}
				
				int idx = N-1;
				while (!q.isEmpty()) {
					int num = q.poll();
					if (copyMap[idx][i] == 0) {
						copyMap[idx][i] = num;
					} else {
						if (copyMap[idx][i] == num) {
							copyMap[idx][i] = num * 2;
							idx--;
						} else {
							idx--;
							copyMap[idx][i] = num;
						}
					}
					
				}
			}
			break;
		case 1:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (copyMap[i][j] != 0) {
						q.offer(copyMap[i][j]);
						copyMap[i][j] = 0;
					}
				}
				
				int idx = 0;
				while (!q.isEmpty()) {
					int num = q.poll();
					if (copyMap[i][idx] == 0) {
						copyMap[i][idx] = num;
					} else {
						if (copyMap[i][idx] == num) {
							copyMap[i][idx] = num * 2;
							idx++;
						} else {
							idx++;
							copyMap[i][idx] = num;
						}
					}
					
				}
			}
			break;
		case 3:
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (copyMap[i][j] != 0) {
						q.offer(copyMap[i][j]);
						copyMap[i][j] = 0;
					}
				}
				
				int idx = N-1;
				while (!q.isEmpty()) {
					int num = q.poll();
					if (copyMap[i][idx] == 0) {
						copyMap[i][idx] = num;
					} else {
						if (copyMap[i][idx] == num) {
							copyMap[i][idx] = num * 2;
							idx--;
						} else {
							idx--;
							copyMap[i][idx] = num;
						}
					}
					
				}
			}
			break;
		}
		return copyMap;
	}

	private static int findMax(int[][] copyMap) {
		int max = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, copyMap[i][j]);
			}
		}

		return max;
	}

	private static int[][] copyMap(int[][] map) {
		int[][] copyMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, N);
		}
		return copyMap;
	}

}
