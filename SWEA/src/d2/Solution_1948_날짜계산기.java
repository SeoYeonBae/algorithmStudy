package d2;

import java.io.*;
import java.util.*;

public class Solution_1948_날짜계산기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int[] monthInfo = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int startM = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			int finishM = Integer.parseInt(st.nextToken());
			int finishD = Integer.parseInt(st.nextToken());
			
			int res = 0;
			if(startM == finishM)
				res = finishD - startD + 1;
			else {
				res += monthInfo[startM] - startD + 1;
				res += finishD;
				
				for (int i = 1; i < finishM - startM; i++) {
					res += monthInfo[startM + i];
				}
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
