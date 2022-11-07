package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			Arrays.fill(map[i], 0);
		}
		for (int i = 0; i < W; i++) {
			int num = Integer.parseInt(st.nextToken());
			for (int j = H - 1; j >= H - num; j--) {
				map[j][i] = 1;
			}
		}
		
		int res = 0;
		for (int i = H - 1; i >= 0; i--) {
			int sum = 0;
			for (int j = 1; j < W; j++) {
				if(map[i][j] == 0) {
					if(map[i][j - 1] != 0) {
						map[i][j] = -1;
						sum++;
					}
				}else if(map[i][j] == 1) {
					res += sum;
					sum = 0;
				}
			}
		}
		System.out.println(res);
		br.close();
	}
}
