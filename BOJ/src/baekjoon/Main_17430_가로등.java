package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17430_가로등 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());

			Map<Integer, List<Integer>> map = new HashMap<>();

			int x = 0;
			int y = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				List<Integer> list;
				if (map.containsKey(x)) {
					list = map.get(x);
				} else {
					list = new ArrayList<Integer>();
				}

				list.add(y);
				map.put(x, list);
			}

			List<Integer> standard = map.get(x);
			Collections.sort(standard);
			boolean isBalanced = true;
			for (Integer key : map.keySet()) {
				List<Integer> list = map.get(key);
				Collections.sort(list);
				if (!list.equals(standard)) {
					isBalanced = false;
					break;
				}
			}

			if (isBalanced)
				sb.append("BALANCED").append("\n");
			else
				sb.append("NOT BALANCED").append("\n");

		}

		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}
