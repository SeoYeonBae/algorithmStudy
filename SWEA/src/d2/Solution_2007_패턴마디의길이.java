package d2;

import java.io.*;

public class Solution_2007_패턴마디의길이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			int len = 1;
			boolean flag = true;
			while(flag) {
				char[] word = new char[len];
				input.getChars(0, len, word, 0);
				int cnt = 0;
				for (int i = 0; i < len; i++) {
					if(word[i] != input.charAt(len + i)) {
						break;
					}else {
						cnt++;
					}
				}
				if(cnt == len) {
					flag = false;
					break;
				}
				else
					len++;
			}
			sb.append("#").append(tc).append(" ").append(len).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
