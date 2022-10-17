package d1;

import java.io.*;

public class Solution_2047_신문헤드라인 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		sb.append(input.toUpperCase());
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
