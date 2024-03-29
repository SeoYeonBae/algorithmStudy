package d5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	
	static int[] home, company, idx;
	static int[][] customer;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		home = new int[2];
		company = new int[2];
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			
			customer = new int[N][2];
			idx = new int[N];	// 고객 순서 넥퍼로 순열 만들기 위한 배열
			for(int i = 0; i < N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
				idx[i] = i;
			}
			
			res = Integer.MAX_VALUE;
			do {
				dist(idx);
			}while(np(idx));
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void dist(int[] numbers) {
		int sum = 0;
		int len = numbers.length;
		sum += Math.abs(home[0] - customer[numbers[0]][0]) + Math.abs(home[1] - customer[numbers[0]][1]);
		for(int i = 1; i < len; i++)
			sum += Math.abs(customer[numbers[i - 1]][0] - customer[numbers[i]][0]) + 
			Math.abs(customer[numbers[i - 1]][1] - customer[numbers[i]][1]);
		sum += Math.abs(customer[numbers[len - 1]][0] - company[0]) + Math.abs(customer[numbers[len - 1]][1] - company[1]);
		
		if(sum < res)
			res = sum;

	}
	private static boolean np(int[] numbers) {
		int N = numbers.length;
		
		int i = N - 1;
		while(i > 0 && numbers[i - 1] >= numbers[i]) --i;
		
		if(i == 0) return false;
		
		int j = N - 1;
		while(numbers[i - 1] >= numbers[j]) --j;
		
		swap(numbers, i - 1, j);
		
		int k = N - 1;
		while(i < k) swap(numbers, i++, k--);
		
		return true;
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
}
