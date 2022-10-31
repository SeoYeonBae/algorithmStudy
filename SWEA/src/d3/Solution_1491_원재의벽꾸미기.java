package d3;

import java.io.*;
import java.util.*;

public class Solution_1491_원재의벽꾸미기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			long ans = Long.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			for (int c = 1; c <= N; c++) {
				for (int r = 1; r <= N; r++) {
					if(r * c > N)
						break;
					long res = A * Math.abs(r - c) + B * (N - r * c);
					ans = Math.min(res, ans);
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
