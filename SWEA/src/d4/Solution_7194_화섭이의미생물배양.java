package d4;

import java.io.*;
import java.util.*;

public class Solution_7194_화섭이의미생물배양 {

	static int s, t, a, b, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()); // 초기 미생물
			t = Integer.parseInt(st.nextToken()); // 만들어야 하는 미생물 수
			a = Integer.parseInt(st.nextToken()); // 먹이: 먹이만큼 늘어남
			b = Integer.parseInt(st.nextToken()); // 배양액 : 배양액의 배만큼 늘어남

			ans = Integer.MAX_VALUE;
			if (s == t)
				ans = 0;
			else if (t < s)
				ans = -1;
			else
				go(s, 0);

			if (ans == Integer.MAX_VALUE)
				ans = -1;

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void go(int m, int day) {
		if (m > t)
			return;

		if (m == t) {
			ans = day < ans ? day : ans;
			return;
		}

		if (b != 1)
			go(m * b, day + 1);
		go(m + a, day + 1);

	}
}
