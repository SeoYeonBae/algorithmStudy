package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1931_회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] meetingTime = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			meetingTime[i][0] = Integer.parseInt(st.nextToken());
			meetingTime[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meetingTime, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] != o2[1])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		
		int res = 1;
		int end = meetingTime[0][1];
		for(int i = 1; i < N; i++) {
			if(end <= meetingTime[i][0]) {
				res++;
				end = meetingTime[i][1];
			}
		}
		
		System.out.println(res);
	}
}
