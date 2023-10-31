package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {

	static int N, C;
	static List<Integer> house;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			house.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(house);
		
		int minGap = 1; // 집 사이의 간격
		int maxGap = house.get(N-1) - house.get(0) + 1;
		while(minGap < maxGap) {
			int midGap = (minGap + maxGap) / 2;
			
			int cnt = 1; // 설치한 공유기 수
			int beforeHouse = house.get(0);
			for (int i = 1; i < N; i++) {
				if(house.get(i) - beforeHouse >= midGap) {
					cnt++;
					beforeHouse = house.get(i);
				}
			}
			
			if(cnt < C)
				maxGap = midGap;
			else
				minGap = midGap + 1;
		}
		System.out.println(minGap - 1);
	}
}
