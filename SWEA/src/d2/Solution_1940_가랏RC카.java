package d2;

import java.io.*;
import java.util.*;

public class Solution_1940_가랏RC카 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int dist = 0;
			int power = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int command = Integer.parseInt(st.nextToken());
				if(command == 1)
					power += Integer.parseInt(st.nextToken());
				else if(command == 2) {
					int num = Integer.parseInt(st.nextToken());
					if(power - num < 0)
						power = 0;
					else
						power -= num;
				}
				
				dist += power;
			}
			sb.append("#").append(tc).append(" ").append(dist).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
