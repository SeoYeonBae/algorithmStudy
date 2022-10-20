package d2;

import java.io.*;
import java.util.*;

public class Solution_1976_시각덧셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int hour1 = Integer.parseInt(st.nextToken());
			int minute1 = Integer.parseInt(st.nextToken());
			int hour2 = Integer.parseInt(st.nextToken());
			int minute2 = Integer.parseInt(st.nextToken());

			int sumHour = 0;
			int sumMinute = minute1 + minute2;
			if (sumMinute >= 60) {
				sumMinute -= 60;
				sumHour++;
			}
			sumHour += hour1 + hour2;
			if(sumHour >= 12) {
				sumHour -= 12;
			}
			
			sb.append("#").append(tc).append(" ").append(sumHour).append(" ").append(sumMinute).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
