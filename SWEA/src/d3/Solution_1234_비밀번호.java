package d3;

import java.io.*;
import java.util.*;

public class Solution_1234_비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			String input = st.nextToken();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(Character.getNumericValue(input.charAt(i)));
			}
			int pointer1 = 0;
			int pointer2 = 1;
			while (pointer2 != list.size()) {
				if (list.get(pointer1) != list.get(pointer2)) {
					pointer1 = pointer2;
					pointer2++;
				} else {
					list.remove(pointer2);
					list.remove(pointer1);
					if (pointer1 != 0) {
						pointer2 = pointer1;
						pointer1--;
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int i : list) {
				sb.append(i);
			}
			sb.append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
