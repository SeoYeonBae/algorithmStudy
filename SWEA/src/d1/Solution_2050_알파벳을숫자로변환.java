package d1;

import java.io.*;

public class Solution_2050_알파벳을숫자로변환 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
			int num = input.charAt(i) - 64;
			sb.append(num).append(" ");
		}
		
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
