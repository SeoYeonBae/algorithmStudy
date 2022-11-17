package d4;

import java.io.*;
import java.util.*;

public class Solution_8382_방향전환_re {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int finishR = Integer.parseInt(st.nextToken());
			int finishC = Integer.parseInt(st.nextToken());

			int X = Math.abs(finishR - startR);
			int Y = Math.abs(finishC - startC);

			int res = 0;
			if (X > Y) {
				res = 2 * X - (X - Y) % 2;
			} else {
				res = 2 * Y - (Y - X) % 2;
			}
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
