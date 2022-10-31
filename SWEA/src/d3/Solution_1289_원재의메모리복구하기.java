package d3;

import java.io.*;
import java.util.*;

public class Solution_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			String s = br.readLine();
			int len = s.length();
			int[] origin = new int[len];
			for (int i = 0; i < len; i++) {
				origin[i] = Character.getNumericValue(s.charAt(i));
			}
			int num = 0;
			int cnt = 0;
			for (int i = 0; i < len; i++) {
				if(num != origin[i]) {
					num = origin[i];
					cnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
