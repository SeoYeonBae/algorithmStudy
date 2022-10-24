package d2;

import java.io.*;
import java.util.*;

public class Solution_1946_간단한압축풀기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(br.readLine());
			int cnt = 0;
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				int len = Integer.parseInt(st.nextToken());
				String res = "";
				for (int i = 0; i < len; i++) {
					sb.append(c);
					if (++cnt == 10) {
						cnt = 0;
						sb.append("\n");
					}
				}
			}
			sb.append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
