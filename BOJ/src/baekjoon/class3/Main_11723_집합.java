package baekjoon.class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11723_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();

		String order;
		int num;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			order = st.nextToken();
			if (order.equals("all")) {
				list.clear();
				for (int j = 1; j <= 20; j++) {
					list.add(j);
				}
			} else if (order.equals("empty")) {
				list.clear();
			} else {
				num = Integer.parseInt(st.nextToken());

				switch (order) {
				case "add":
					if (!list.contains(num))
						list.add(num);
					break;

				case "remove":
					if (list.contains(num))
						list.remove(Integer.valueOf(num));
					break;

				case "check":
					if (list.contains(num))
						sb.append(1).append("\n");
					else
						sb.append(0).append("\n");
					break;

				case "toggle":
					if (list.contains(num))
						list.remove(Integer.valueOf(num));
					else
						list.add(num);
					break;

				default:
					break;
				}
			}

		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
