package baekjoon;

import java.io.*;
import java.util.*;

public class Main_3460_이진수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			while(n != 1) {
				if(n % 2 == 1) {
					sb.append(cnt).append(" ");
				}
				cnt++;
				n = n/2;
			}
			sb.append(cnt).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
