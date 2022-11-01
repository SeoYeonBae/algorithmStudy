package d3;

import java.io.*;
import java.util.*;

public class Solution_1217_거듭제곱 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 0; tc < 10; tc++) {
			int t = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			double N = Integer.parseInt(st.nextToken());
			double M = Integer.parseInt(st.nextToken());
			int ans = (int)Math.pow(N, M);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
