package test;

import java.io.*;
import java.util.*;

public class Solution_4014_활주로건설 {

	static int N, X, map[][], map2[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			map2 = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map2[j][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("#").append(tc).append(" ").append(process()).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static int process() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(makeRoad(map[i])) count++;	// 수평 활주로 건설 체크
			if(makeRoad(map2[i])) count++;	// 수직 활주로 건설 체크
		}
		return count;
	}
	// 해당 지형 정보로 활주로 건설이 가능하면 true, 불가능하면 false 리턴
	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0], size = 0;
		int j = 0;
		
		while(j < N) {
			if(beforeHeight == road[j]) {	// 동일 높이
				size++;
				j++;
			}else if(beforeHeight+1 == road[j]) { // 이전 높이보다 1높음 : 오르막 경사로 설치 체크
				if(size < X) return false; // X길이 미만이면 활주로 건설 불가
				
				beforeHeight++;
				size = 1;
				j++;
			}else if(beforeHeight - 1 == road[j]) { // 이전 높이보다 1 작음
				int count = 0;
				for (int k = j; k < N; k++) {
					if(road[k] != beforeHeight-1)
						return false;
					if(++count == X)
						break;
				}
				
				if(count < X)
					return false;
				
				beforeHeight--;
				j += X;
				size = 0;
				
			}else { // 높이가 2이상 차이
				return false;
			}
		}
		return true;
	}
}
