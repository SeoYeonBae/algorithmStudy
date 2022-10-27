package d3;

import java.io.*;
import java.util.*;

public class Solution_1206_View {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] apart = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				apart[i] = Integer.parseInt(st.nextToken());
			}
			int view = 0;
			for (int i = 2; i < N - 2; i++) {
				int res = Integer.MAX_VALUE;
				if(apart[i - 1] < apart[i]) {
					res = Math.min(res, apart[i] - apart[i - 1]);
					if(apart[i - 2] < apart[i]) {
						res = Math.min(res, apart[i] - apart[i - 2]);
						if(apart[i + 1] < apart[i]) {
							res = Math.min(res, apart[i] - apart[i + 1]);
							if(apart[i + 2] < apart[i]) {
								res = Math.min(res, apart[i] - apart[i + 2]);
								view += res;
							}
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(view).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
