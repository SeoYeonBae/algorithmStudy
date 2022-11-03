package d3;

import java.io.*;
import java.util.*;

public class Solution_1225_암호생성기_re {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Queue<Integer> dq = new ArrayDeque<>();
			for (int i = 0; i < 8; i++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			
			loop:
			while(true) {
				for (int i = 1; i <= 5; i++) {
					int num = dq.poll();
					num -= i;
					if(num <= 0) {
						dq.add(0);
						break loop;
					}
					dq.add(num);
				}
			}
			sb.append("#").append(tc).append(" ");
			for(int q : dq)
				sb.append(q).append(" ");
			sb.append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
