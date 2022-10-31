package d3;

import java.io.*;
import java.util.*;

public class Solution_1240_단순2진암호코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[][] code = {
				{0, 0, 0, 1, 1, 0, 1},	
				{0, 0, 1, 1, 0, 0, 1},	
				{0, 0, 1, 0, 0, 1, 1},	
				{0, 1, 1, 1, 1, 0, 1},	
				{0, 1, 0, 0, 0, 1, 1},	
				{0, 1, 1, 0, 0, 0, 1},	
				{0, 1, 0, 1, 1, 1, 1},	
				{0, 1, 1, 1, 0, 1, 1},	
				{0, 1, 1, 0, 1, 1, 1},	
				{0, 0, 0, 1, 0, 1, 1},	
		};
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			int[][] pass = new int[8][7];
			loop:
			for (int i = 0; i < N; i++) {
				for (int j = M - 1; j >= 0; j--) {
					if(map[i][j] == 1) {
						for (int r = 7; r >= 0; r--) {
							for (int c = 6; c >= 0 ; c--) {
								pass[r][c] = map[i][j--];
							}
						}
						break loop;
					}
				}
			}
			
//			for (int i = 0; i < 8; i++) {
//				System.out.println(Arrays.toString(pass[i]));
//			}
			
			int cnt = 0;
			int[] resPass = new int[8]; 
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 10; j++) {
					cnt = 0;
					for (int k = 0; k < 7; k++) {
						if(pass[i][k] == code[j][k])
							cnt++;
					}
					if(cnt == 7)
						resPass[i] = j;
				}
			}
			
			int odd = 0;
			int even = 0;
			for (int i = 0; i < 8; i += 2) {
				odd += resPass[i];
			}
			for (int i = 1; i < 8; i += 2) {
				even += resPass[i];
			}
			
			int ans = 0;
			if((odd * 3 + even) % 10 == 0) {
				ans = odd + even;
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
