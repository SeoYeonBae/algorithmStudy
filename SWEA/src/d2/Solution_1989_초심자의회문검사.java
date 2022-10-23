package d2;

import java.io.*;
import java.util.*;

public class Solution_1989_초심자의회문검사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			int len = input.length();
			int res = 1;
			for (int i = 0; i < len / 2; i++) {
				if(input.charAt(i) != input.charAt(len - i - 1)) {
					res = 0;
					break;
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
