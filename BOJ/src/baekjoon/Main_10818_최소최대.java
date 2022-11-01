package baekjoon;

import java.io.*;
import java.util.*;

public class Main_10818_최소최대 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = Math.max(num, max);
			min = Math.min(num, min);
		}
		sb.append(min).append(" ").append(max);
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
