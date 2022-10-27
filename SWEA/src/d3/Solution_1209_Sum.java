package d3;

import java.io.*;
import java.util.*;

public class Solution_1209_Sum {

	static int res; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			res = 0;
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int sum;
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += map[i][j];
				}
				res = Math.max(sum, res);
			}
			
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += map[j][i];
				}
				res = Math.max(sum, res);
			}
			
			sum = 0;
			for (int i = 0; i < 100; i++) {
				sum += map[i][i];
			}
			res = Math.max(sum, res);

			sum = 0;
			for (int i = 99; i >= 0; i--) {
				sum += map[i][i];
			}
			res = Math.max(sum, res);
			
			sb.append("#").append(n).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
