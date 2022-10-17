package d1;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_2058_자릿수더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String N = br.readLine();
		int sum = 0;
		for (int i = 0; i < N.length(); i++) {
			sum += Character.getNumericValue(N.charAt(i));
		}
		
		sb.append(sum);
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
