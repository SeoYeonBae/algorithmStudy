package d2;

import java.io.*;
import java.util.*;

public class Solution_1204_최빈수구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			int[] tmp = new int[101];
			Arrays.fill(tmp, 0);
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 1000; i++) {
				int idx = Integer.parseInt(st.nextToken());
				tmp[idx]++;
			}
			List<Integer> list = new ArrayList<Integer>();
			for (int t : tmp) {
				list.add(t);
			}
			int max = Collections.max(list);
			int res = list.indexOf(max);
			list.set(list.indexOf(max), 0);
			while (true) {
				int max2 = Collections.max(list);
				if (max == max2) {
					res = list.indexOf(max2);
					list.set(list.indexOf(max2), 0);
				}
				else
					break;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
