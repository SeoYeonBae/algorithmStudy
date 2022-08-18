package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());		// 과자 봉지 개수
			int M = Integer.parseInt(st.nextToken());		// 과자 무게 맥시멈
			
			int[] snack = new int[N];						// 과자 리스트 초기화
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++)
				snack[i] = Integer.parseInt(st.nextToken());
			
			int max = -1, tmp;
			for(int i = 0; i < N; i++) {
				for(int j =  i + 1; j < N; j++) {
					tmp = snack[i] + snack[j];
					if(max < tmp && tmp <= M)
						max = tmp;
				}
			}
			sb.append(max).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
