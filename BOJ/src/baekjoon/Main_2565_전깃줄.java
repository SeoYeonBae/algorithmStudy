package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_2565_전깃줄 {

	static int[] lis;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] wire = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// A 전봇대 기준 오름차순 정렬
		Arrays.sort(wire, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// B 전봇대의 LIS 구함
		lis = new int[N];
		int i = 1;
		int j = 0;
		lis[0] = wire[0][1];
		while(i < N) {
			if(lis[j] < wire[i][1]) {
				lis[j + 1] = wire[i][1];
				j++;
			}else {
				int idx = binarySearch(0, j, wire[i][1]);
				lis[idx] = wire[i][1];
			}
			i++;
		}
		
		// 전깃줄 수 - 최대로 연결할 수 있는 전깃줄 수 - 1
		System.out.println(N - j - 1);
	}

	private static int binarySearch(int left, int right, int target) {
		int mid = 0;
		
		while(left < right) {
			mid = (left + right) / 2;
			
			if(lis[mid] < target) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		return right;
	}
}
