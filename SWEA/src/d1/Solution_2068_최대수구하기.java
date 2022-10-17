package d1;

import java.io.*;
import java.util.*;

public class Solution_2068_최대수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int max = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 9; i++) {
				max = Math.max(max, Integer.parseInt(st.nextToken()));
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
