package d2;

import java.io.*;
import java.util.*;

public class Solution_1954_달팽이숫자_re {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int d = 0;
			int r = 0;
			int c = 0;
			
			for (int i = 1; i <= N*N; i++) {
				map[r][c] = i;
				r = r + dr[d]; 
				c = c + dc[d];
				
				if(r < 0 || r >= N || c < 0 || c >= N || map[r][c] != 0) {
					r = r - dr[d];
					c = c - dc[d];
					d = (d + 1) % 4;
					r = r + dr[d];
					c = c + dc[d];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
