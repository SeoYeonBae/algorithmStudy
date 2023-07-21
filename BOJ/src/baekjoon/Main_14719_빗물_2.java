package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14719_빗물_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int limit = Integer.parseInt(st.nextToken());
			int height = H - 1;
			for (int j = 0; j < limit; j++) {
				map[height--][i] = 1;
			}
		}
		
		int res = 0;
		for (int i = H - 1; i >= 0; i--) {	// 제일 바닥부터 물 채우기 시작
			int sum = 0;
			for (int j = 1; j < W; j++) {
				if(map[i][j] == 0 && map[i][j - 1] != 0) {	// 현재 칸이 빈칸이고 이전 칸이 막혀있다면
					map[i][j] = 1;
					sum++;
				}else {	// 벽을 만남
					res += sum;	// 지금까지 채운 빗물 더해주고 초기화
					sum = 0;	
				}
			}
		}

		System.out.println(res);
	}
}
