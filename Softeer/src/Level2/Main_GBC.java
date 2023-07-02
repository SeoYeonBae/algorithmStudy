package Level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_GBC {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] limitSpeed = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			limitSpeed[i][0] = limitSpeed[i - 1][0] + Integer.parseInt(st.nextToken());
			limitSpeed[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] testSpeed = new int[M + 1][2];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			testSpeed[i][0] = testSpeed[i - 1][0] + Integer.parseInt(st.nextToken());
			testSpeed[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int res = 0;
		int limitIdx = 1;
		int testIdx = 1;
		
		for (int i = 1; i <= 100; i++) {
			if(i > limitSpeed[limitIdx][0])
				limitIdx++;
			if(i > testSpeed[testIdx][0])
				testIdx++;
			if(testSpeed[testIdx][1] > limitSpeed[limitIdx][1])
				res = Math.max(res, testSpeed[testIdx][1] - limitSpeed[limitIdx][1]);
		}
		
		System.out.println(res);
	}
}
