package baekjoon;

import java.io.*;
import java.util.*;

public class Main_19236_청소년상어 {

	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1 };
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 일단 물고기 정보는 물고기 번호를 hashmap에 저장
		// 입력은 물고기 번호, 방향 순
		// dr, dc는 물고기 1-8과 동일한 순서로 (반시계방향 회전)
		// 물고기 이동 함수, 상어 이동하고 먹는 함수, hashmap과 물고기 map 복사하는 함수
		// 번호 합의 최댓값 출력
		int[][] map = new int[4][4];
		HashMap<Integer, int[]> fishInfo = new HashMap<>();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int key = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken()) - 1;
				map[i][j] = key;
				fishInfo.put(key, new int[] { i, j, value });
			}
		}
		int[] shark = {0, 0, 0};
		go(shark, fishInfo, map, 0);
		System.out.println(res);
		br.close();
	}

	private static void go(int[] shark, HashMap<Integer, int[]> fishInfo, int[][] map, int eatCnt) {
		int[][] newMap = copyMap(map);
		HashMap<Integer, int[]> newFishInfo =  new HashMap<Integer, int[]>();
		newFishInfo.putAll(fishInfo);
		// 1. 물고기 먹기
		int sharkR = shark[0];
		int sharkC = shark[1];
		int fishNum = newMap[sharkR][sharkC];
		int sharkD = newFishInfo.get(fishNum)[2];	// 자리에 있던 물고기 방향 흡수하기
		System.out.println("먹었어요 : " + fishNum + " 상어 방향은 : " +  sharkD);
		eatCnt += fishNum;	// 자리에 있던 물고기 크기 더하기
		newFishInfo.remove(fishNum);		// map에 있는 거 묵기
		newMap[sharkR][sharkC] = -1;	// 먹은 자리에 상어 넣기
		if(res < eatCnt)
			res = eatCnt;
		
		// 2. 물고기 이동하기
		for (int i = 1; i <= 16; i++) {
			if (!newFishInfo.containsKey(i))
				continue;
			int[] cur = newFishInfo.get(i);
			int r = cur[0];
			int c = cur[1];
			int d = cur[2];
			int cnt = 0;
			while (cnt < 8) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) { // 물고기가 못 움직이는 경우 1 : 공간의 경계를 넘어간 경우
					d = (d + 1) % 8;
					cnt++;
					continue;
				}

				if (newMap[nr][nc] == -1) { // 물고기 못 움직이는 경우 2 : 상어가 있는 칸
					d = (d + 1) % 8;
					cnt++;
					continue;
				}

				System.out.println("i : " + i + " d : "+ d);
				if (newMap[nr][nc] == 0) { // 이동 할 수 있는 칸 1 : 빈 칸
					newMap[nr][nc] = newMap[r][c];
					newMap[r][c] = 0;
					newFishInfo.replace(i, new int[] {nr, nc, d});
					
				} else { // 이동할 수 있는 칸 2 : 물고기 있는 칸
					int tmp = newMap[nr][nc];
					
					newFishInfo.replace(tmp, new int[] {r, c, fishInfo.get(tmp)[2]});
					newFishInfo.replace(i, new int[] {nr, nc, d});
					
					int tmp2 = newMap[nr][nc];
					newMap[nr][nc] = newMap[r][c];
					newMap[r][c] = tmp2;
				}
				
				break;
			}
			System.out.println("-------------------------------");
			for (int k = 0; k < 4; k++) {
				System.out.println(Arrays.toString(newMap[k]));
			}
		}
	
		// 3. 상어 이동하기
		for (int i = 1; i <= 3; i++) {
			int nr = sharkR + (dr[sharkD] * i);
			int nc = sharkC + (dc[sharkD] * i);
			if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4)	// 상어가 못 가는 곳 1 : 범위 벗어난 곳
				break;
			
			if(newMap[nr][nc] == 0)	// 상어가 못 가는 곳 2 : 물고기 없는 곳
				continue;
			
			newMap[sharkR][sharkC] = 0;
			int[] newShark = {nr, nc, sharkD};
			go(newShark, newFishInfo, newMap, eatCnt);
		}
	}

	private static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[4][4];
		for (int i = 0; i < 4; i++) {
			System.arraycopy(map[i], 0, newMap[i], 0, 4);
		}
		return newMap;
	}


}
