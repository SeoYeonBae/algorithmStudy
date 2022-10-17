package d1;

import java.io.*;
import java.util.*;

public class Solution_2071_평균값구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			double sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				sum += Double.parseDouble(st.nextToken());
			}
			sum /= 10.0;
			sb.append("#").append(tc).append(" ").append(Math.round(sum)).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
