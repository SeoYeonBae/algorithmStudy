package d1;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_2070_큰놈작은놈같은놈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A < B)
				sb.append("#").append(tc).append(" <\n");
			else if( A == B)
				sb.append("#").append(tc).append(" =\n");
			else
				sb.append("#").append(tc).append(" >\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
