package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {

	static int rec, K;
	static int[][] map, originalMap;

	// 순열을 만들기 위한 변수
	static List<int[]> perms;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()) + 1;
		int M = Integer.parseInt(st.nextToken()) + 1;
		K = Integer.parseInt(st.nextToken());
		
		// 배열 초기화
		map = new int[N][M];
		originalMap = new int[N][M];
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				originalMap[i][j] = map[i][j];	// 초기화를 위한 오리지널 배열 저장
			}
		}
		
		isSelected = new boolean[K]; 	// 순열 만들 때 체크할 용도
		numbers = new int[K]; 			// 각 줄의 인덱스를 담을 배열
		perms = new ArrayList<>(); 		// 인덱스 순열 담을 리스트
		perm(0);						// 인덱스로 순열 만들기 
		
		// 회전 연산 입력받기
		int[][] operations = new int[K][3];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++)
				operations[i][j] = Integer.parseInt(st.nextToken());
		}
		
		// 순열 크기만큼  돌리고 min값 찾기
		int tmp;						// 행 더한 값
		int min = Integer.MAX_VALUE;	// 최종 출력값
		for(int i = 0; i < perms.size(); i++) {
			int[] p = perms.get(i); 			// 회전 연산 인덱스 한 줄 받아오기
			
			for(int j = 0; j < p.length; j++) {	// 인덱스 순서대로 회전하기
				int r = operations[p[j]][0];
				int c = operations[p[j]][1];
				int s = operations[p[j]][2];
				
				rec = (2 * s + 1) / 2;
				rotate(r - s, c - s, r + s, c + s, 0);
			}
			
			for(int y = 1; y < N; y++) {
				tmp = 0;
				for(int z = 1; z < M; z++) {
					tmp += map[y][z];
				}
				if(tmp < min)
					min = tmp;
			}
			
			// 배열 초기화
			for(int y = 0; y < N; y ++)
				for(int z = 0; z < M; z++)
					map[y][z] = originalMap[y][z];
		}
		System.out.println(min);
	}

	// 인덱스로 순열 만들기
	private static void perm(int cnt) {
		if(cnt == K) {
			int[] tmp = new int[K];
			for(int i = 0; i < K; i++)
				tmp[i] = numbers[i];
			perms.add(tmp);
			return;	
		}
		
		for(int i = 0; i < K; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static void rotate(int startR, int startC, int endR, int endC, int cnt) {		
		if(cnt == rec)
			return;
		
		int tmp = map[startR][startC];
		
		for(int i = startR; i < endR; i++)
			map[i][startC] = map[i + 1][startC];
		for(int i = startC; i < endC; i++)
			map[endR][i] = map[endR][i + 1];
		for(int i = endR; i > startR; i--)
			map[i][endC] = map[i - 1][endC];
		for(int i = endC; i > startC; i--)
			map[startR][i] = map[startR][i - 1];
		map[startR][startC + 1] = tmp;
		
		rotate(startR + 1, startC + 1, endR - 1, endC - 1, cnt + 1);
	}	
}
