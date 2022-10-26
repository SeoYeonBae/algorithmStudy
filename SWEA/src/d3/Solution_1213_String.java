package d3;

import java.io.*;

public class Solution_1213_String {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
				
		for (int tc = 1; tc <= 10; tc++) {
			String i = br.readLine();
			String word = br.readLine();
			String input = br.readLine();
			int res = input.split(word).length - 1;
			int len = input.length();
			String last = "";
			for (int j = len - word.length(); j < len; j++) {
				last += input.charAt(j);
			}
			if(last.equals(word))
				res++;
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
