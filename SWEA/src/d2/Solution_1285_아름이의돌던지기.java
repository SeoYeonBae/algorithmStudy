package d2;

import java.io.*;
import java.util.*;

public class Solution_1285_아름이의돌던지기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> dist = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				dist.add(Math.abs(Integer.parseInt(st.nextToken())));
			}
			Collections.sort(dist);
			int cnt = 1;
			int min = dist.get(0);
			for (int i = 1; i < N; i++) {
				if(dist.get(i) == min)
					cnt++;
				else
					break;
			}
			
			sb.append("#").append(tc).append(" ").append(min).append(" ").append(cnt).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
