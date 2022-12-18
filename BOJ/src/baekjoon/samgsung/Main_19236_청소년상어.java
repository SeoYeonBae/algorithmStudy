package baekjoon.samgsung;

import java.io.*;
import java.util.*;

public class Main_19236_청소년상어 {

	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1 };
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

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
		int[] shark = {0, 0};
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
		eatCnt += fishNum;	// 자리에 있던 물고기 크기 더하기
		newFishInfo.remove(fishNum);		// map에 있는 거 묵기
		newMap[sharkR][sharkC] = 0;	// 먹은 자리에 상어 넣기
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
				
				 // 물고기가 못 움직이는 경우
				if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || (nr == sharkR && nc == sharkC)) {
					d = (d + 1) % 8;
					cnt++;
					continue;
				}

				if (newMap[nr][nc] == 0) { // 이동 할 수 있는 칸 1 : 빈 칸
					newMap[nr][nc] = newMap[r][c];
					newMap[r][c] = 0;
					newFishInfo.replace(i, new int[] {nr, nc, d});
					
				} else { // 이동할 수 있는 칸 2 : 물고기 있는 칸
					int tmp = newMap[nr][nc];
					
					newFishInfo.replace(tmp, new int[] {r, c, newFishInfo.get(tmp)[2]});
					newFishInfo.replace(i, new int[] {nr, nc, d});
					
					newMap[nr][nc] = newMap[r][c];
					newMap[r][c] = tmp;
				}
				
				break;
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
			int[] newShark = {nr, nc};
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