package d2;

import java.io.*;
import java.util.*;

public class Solution_1859_백만장자프로젝트 {

	static long res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			res = 0;
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] input = new int[N];
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			int max = input[N-1];
			for (int i = N-2; i >= 0; i--) {
				if(input[i] == max)
					continue;
				if(input[i] > max)
					max = input[i];
				else if(input[i] < max)
					res += (max - input[i]);
			}
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
