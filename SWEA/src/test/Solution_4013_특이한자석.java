package test;

import java.io.*;
import java.util.*;

public class Solution_4013_특이한자석 {
	static int[][] magnet;
	static int[] dir;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int K;
		
		magnet = new int[4][8];
		
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int magnetNum, rotateDir;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				magnetNum = Integer.parseInt(st.nextToken()) - 1;
				rotateDir = Integer.parseInt(st.nextToken());
				
				dir = new int[4];
				dir[magnetNum] = rotateDir;
				findDir(dir, magnetNum);
				rotate();
				
			}
			int res = 0, cnt = 1;
			
			for (int i = 0; i < 4; i++) {
				if(magnet[i][0] == 1)
					res += cnt;
				cnt *= 2;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void rotate() {
		for (int d = 0; d < 4; d++) {
			if(dir[d] == 0) continue;
			
			if(dir[d] == 1) {
				int tmp = magnet[d][7];
				for(int i = 6; i >= 0; i--) magnet[d][i + 1] = magnet[d][i];
				magnet[d][0] = tmp;
			}else {
				int tmp = magnet[d][0];
				for(int i = 1; i < 8; i++) magnet[d][i - 1] = magnet[d][i];
				magnet[d][7] = tmp;
			}
		}
		
	}

	private static void findDir(int[] dir, int magnetNum) {
		for(int i = magnetNum; i < 3; i++) {
			if(magnet[i][2] == magnet[i + 1][6])
				break;
			dir[i + 1] = dir[i] * -1;
		}
		for(int i = magnetNum; i > 0; i--) {
			if(magnet[i][6] == magnet[i - 1][2])
				break;
			dir[i - 1] = dir[i] * -1;
		}
	}


}
