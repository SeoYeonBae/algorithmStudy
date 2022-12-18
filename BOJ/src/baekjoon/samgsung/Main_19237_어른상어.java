package baekjoon.samgsung;

import java.io.*;
import java.util.*;

public class Main_19237_어른상어 {

	static int N, M, K;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int time;
	static int[][] map;
	static int[] dir;
	static int[][][] priorityDir, smell;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 맵의 크기
		M = Integer.parseInt(st.nextToken()); // 상어 개수
		K = Integer.parseInt(st.nextToken()); // 냄새 유지 횟수

		map = new int[N][N];
		smell = new int[2][N][N]; // 0에는 상어 번호 1에는 남은 시간
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 상어의 현재 위치 배열
				if (map[i][j] != 0) { // 상어가 있는 칸이라면
					smell[0][i][j] = map[i][j]; // 상어 번호
					smell[1][i][j] = K; // 냄새 유지 시간
				}
			}
		}

		dir = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			dir[i] = Integer.parseInt(st.nextToken()) - 1; // 상어의 현재 방향
		}

		priorityDir = new int[M + 1][4][4];
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					priorityDir[i][j][k] = Integer.parseInt(st.nextToken()) - 1; // 상어의 방향 우선순위
				}
			}
		}

		go();

		if (time == 1001)
			System.out.println(-1);
		else
			System.out.println(time);
		
		br.close();
	}

	private static void go() {
		int alive = M;
		while (alive > 1) { // 상어가 한 마리 남을 때까지 계속 반복
			alive = moveShark(alive); // 상어 움직이기
			deleteSmell(); // 기존 냄새 남은 시간 감소
			makeSmell(); // 냄새 뿌리기
			if (time > 1000)
				return;
		}

	}

	private static int moveShark(int alive) {
		int[][] newMap = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(newMap[i], 0);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) { // 상어 만나면 상어 움직이기
					int sharkNum = map[i][j];
					int sharkD = dir[sharkNum];
					int sharkR = i;
					int sharkC = j;
					int nr = i, nc = j;
					boolean isMove = true;
					for (int d = 0; d < 4; d++) { // 빈 곳 찾기
						nr = sharkR + dr[priorityDir[sharkNum][sharkD][d]];
						nc = sharkC + dc[priorityDir[sharkNum][sharkD][d]];

						if (nr < 0 || nr >= N || nc < 0 || nc >= N)
							continue;

						if (smell[0][nr][nc] != 0)
							continue;

						dir[sharkNum] = priorityDir[sharkNum][sharkD][d];	// 냄새 없는 곳 찾으면
						isMove = false;
						break;
					}
					if (isMove) { // 빈 곳을 못 찾았다면 내 냄새랑 같은 곳 찾기
						for (int d = 0; d < 4; d++) {
							nr = sharkR + dr[priorityDir[sharkNum][sharkD][d]];
							nc = sharkC + dc[priorityDir[sharkNum][sharkD][d]];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N)
								continue;

							if (smell[0][nr][nc] != sharkNum)
								continue;

							dir[sharkNum] = priorityDir[sharkNum][sharkD][d];	// 같은 냄새 있는 곳 찾으면
							break;
						}
					}
					if (newMap[nr][nc] == 0)
						newMap[nr][nc] = sharkNum;
					else if (newMap[nr][nc] > sharkNum) {// 칸에 있는 믈고기보다 내가 더 작을 때
						newMap[nr][nc] = sharkNum;
						alive--;
					} else { // 칸에 나보다 작은 물고기가 있을 때
						alive--;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.arraycopy(newMap, 0, map, 0, N);
		}
		time++;
		return alive;
	}

	private static void deleteSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (smell[0][i][j] != 0) { // 냄새가 있는 칸이라면
					smell[1][i][j]--; // 남은 시간 1 감소
					if (smell[1][i][j] == 0) // 남은 시간이 0이라면
						smell[0][i][j] = 0; // 냄새 흔적도 없애버림
				}
			}
		}
	}

	private static void makeSmell() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) { // 상어가 있는 칸이라면
					smell[0][i][j] = map[i][j]; // 냄새 남기고
					smell[1][i][j] = K; // 시간 초기화
				}
			}
		}

	}

}
