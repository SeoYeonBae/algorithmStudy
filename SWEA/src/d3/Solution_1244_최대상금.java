package d3;

import java.io.*;
import java.util.*;

public class Solution_1244_최대상금 {

	static int[] input;
	static HashSet<Integer> set;
	static int len, max, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			len = s.length();
			input = new int[len];
			for (int i = 0; i < len; i++) {
				input[i] = Character.getNumericValue(s.charAt(i));
			}

			c = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;
			set = new HashSet<>();
			dfs(0, 0);
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void dfs(int start, int cnt) {

		String tmp = "";
		for (int i : input)
			tmp += i;
		int sum = Integer.parseInt(tmp);

		if (cnt == c) {
			max = Math.max(max, sum);
			return;
		}

		if (set.contains(sum))
			return;

		set.add(sum);

		for (int i = start; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				swap(i, j);
				dfs(i, cnt + 1);
				swap(i, j);
			}
		}

	}

	private static void swap(int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;

	}
}
