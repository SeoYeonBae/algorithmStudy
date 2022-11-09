package d3;

import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Solution_1220_Magnetic {

	static int[][] map;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
//		map = new int[7][7];
//		for (int i = 0; i < 7; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < 7; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		for (int i = 0; i < 7; i++) {
//			magneticN(i);
//			magneticS(6 - i);
//		}
//		for (int i = 0; i < 7; i++) {
//			System.out.println(Arrays.toString(map[i]));
//			
//		}
//		for (int i = 0; i < 7; i++) {
//			countN(i);
//		}
//		System.out.println(res);
		for (int tc = 1; tc <= 10; tc++) {
			String num = br.readLine();
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			res = 0;
			for (int i = 0; i < 100; i++) {
				magneticN(i);
				magneticS(99 - i);
			}
			for (int i = 0; i < 100; i++) {
				countN(i);
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void countN(int i) {
		if(map[0][i] == 1)
			res++;
		
		for (int j = 1; j < 100; j++) {
			if(map[j][i] == 0)
				continue;
			if(map[j][i] == 1) {
				if(map[j - 1][i] == 0) {
					res++;
				}
			}else if(map[j][i] == 2)
				map[j][i] = 0;
		}
		
	}

	private static void magneticS(int i) {
		for (int j = 0; j < 100; j++) {
			if (map[i][j] == 1) {
				if (i == 99) {
					map[i][j] = 0;
				} else {
					int row = i;
					while (row + 1 <= 99) {
						if(map[row + 1][j] != 0)
							break;
						map[row][j] = 0;
						map[++row][j] = 1;
					}
					if(row == 99)
						map[row][j] = 0;
				}
			}
		}
	}

	private static void magneticN(int i) {
		for (int j = 0; j < 100; j++) {
			if (map[i][j] == 2) {
				if (i == 0) {
					map[i][j] = 0;
				} else {
					int row = i;
					while (row - 1 >= 0) {
						if(map[row - 1][j] != 0)
							break;
						map[row][j] = 0;
						map[--row][j] = 2;
					}
					if(row == 0)
						map[row][j] = 0;
				}
			}
		}

	}

}
