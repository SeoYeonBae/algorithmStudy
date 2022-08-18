package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	
	static List<int[]> houses;		// 집 위치 저장
	static List<int[]> chickens;	// 치킨집 위치 저장
	static int[] numbers;		// 치킨집 인덱스로 조합 만들기 위한 배열
	static int M, res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int num;
		houses = new ArrayList<int[]>();
		chickens = new ArrayList<int[]>();
		numbers = new int[M];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				num = Integer.parseInt(st.nextToken());
				if(num == 1) {				
					houses.add(new int[] {i, j});
				}else if(num == 2) {			
					chickens.add(new int[] {i, j});
				}
			}
		}
		comb(0, 0);
		System.out.println(res);
		br.close();
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == M) {
			int min, idx;
			int dist, sum = 0;
			for(int i = 0; i < houses.size(); i++) {
				min = Integer.MAX_VALUE;
				for(int j = 0; j < numbers.length; j++) {
					idx = numbers[j];
					dist = Math.abs(houses.get(i)[0] - chickens.get(idx)[0]) + Math.abs(houses.get(i)[1] - chickens.get(idx)[1]);
					min = Math.min(dist, min);
				}
				sum += min;
			}
			res = Math.min(res, sum);
			return;
		}
		
		for(int i = start; i < chickens.size(); i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
}
