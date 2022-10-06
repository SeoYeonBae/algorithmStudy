package d3;

import java.io.*;
import java.util.*;

public class Solution_3307_최장증가부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] C = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int size = 0;
			for (int i = 0; i < N; i++) {
				int pos = Arrays.binarySearch(C, 0, size, arr[i]);
				
				if(pos >= 0) continue;
				
				int insertPos = Math.abs(pos) - 1;
				
				C[insertPos] = arr[i];
				
				if(insertPos == size) size++;
			}
			sb.append("#").append(tc).append(" ").append(size).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
