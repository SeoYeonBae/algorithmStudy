package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		int N, cnt, r, c, d;
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			int[][] A = new int[N][N];
			cnt = 1;
			d = 0;
			r = 0;
			c = 0;
			while(cnt <= N*N) {
				A[r][c] = cnt++;
				
				r += dr[d];
				c += dc[d];
				
				if(r < 0 || r >= N || c < 0 || c >= N || A[r][c] != 0) {
					r -= dr[d];
					c -= dc[d];
					d = (d + 1) % 4;
					r += dr[d];
					c += dc[d];
				}
				
			}
			System.out.println("#" + tc);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++)
					System.out.print(A[i][j] + " ");
				System.out.println();
			}
		}
	}

}
