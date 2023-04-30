package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_8911_거북이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		for (int tc = 0; tc < T; tc++) {
			char[] orderList = br.readLine().toCharArray();
			
			int r = 250;
			int c = 250;
			int d = 0;
			
			int maxR = 250;
			int minR = 250;
			int maxC = 250;
			int minC = 250;
			
			for (char order : orderList) {
				switch (order) {
				case 'F':
					r += dr[d];
					c += dc[d];	
					break;
				case 'B':
					r -= dr[d];
					c -= dc[d];	
					break;
				case 'L':
					d--;
					if(d < 0)
						d = 3;
					break;
				case 'R':
					d = (d + 1) % 4;
					break;
				}

				maxR = Math.max(maxR, r);
				minR = Math.min(minR, r);
				maxC = Math.max(maxC, c);
				minC = Math.min(minC, c);
			}
			sb.append((maxR - minR) * (maxC - minC)).append("\n");
			
		}
		
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}
