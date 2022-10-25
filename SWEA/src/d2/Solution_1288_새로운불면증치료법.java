package d2;

import java.io.*;
import java.util.*;

public class Solution_1288_새로운불면증치료법 {

	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String N = br.readLine();
			int origin = Integer.parseInt(N);
			visited = new boolean[10];
			boolean flag = true;
			int cnt = 1;
			while (flag) {
				for (int i = 0; i < N.length(); i++) {
					visited[Character.getNumericValue(N.charAt(i))] = true;
				}

				for (int i = 0; i < 10; i++) {
					if (!visited[i]) {
						cnt++;
						N = Integer.toString(origin * cnt);
						break;
					}
					if (i == 9)
						flag = false;
				}
			}
			sb.append("#").append(tc).append(" ").append(N).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
