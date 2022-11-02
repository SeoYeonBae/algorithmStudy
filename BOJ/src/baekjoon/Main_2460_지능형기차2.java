package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2460_지능형기차2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int res = Integer.MIN_VALUE;
		int sum = 0;
		for (int tc = 0; tc < 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			sum -= out;
			sum += in;
			
			res = Math.max(res, sum);
		}
		System.out.println(res);
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
