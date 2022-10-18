package d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_1926_간단한369게임 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			String num = String.valueOf(i);
			int cnt = 0;
			boolean is369 = false;
			for (int j = 0; j < num.length(); j++) {
				char tmp = num.charAt(j);
				if (tmp == '3' || tmp == '6' || tmp == '9') {
					is369 = true;
					cnt++;
				}
			}
			if (is369) {
				for (int j = 0; j < cnt; j++) {
					sb.append("-");
				}
			} else
				sb.append(i);
			sb.append(" ");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
