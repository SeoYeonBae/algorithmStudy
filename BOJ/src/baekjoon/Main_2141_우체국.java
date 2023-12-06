package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2141_우체국 {

	static class Home implements Comparable<Home>{
		long x, a;
		
		public Home(long x, long a){
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Home o) {
			return (int) (this.x - o.x);
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long sumPeople = 0;	// 총 인구수
		List<Home> homeList = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			homeList.add(new Home(x, a));
			sumPeople += a;
		}
		sumPeople = sumPeople % 2 == 0 ? sumPeople : sumPeople + 1;
		long mid = sumPeople / 2;		// 인구수의 절반
		
		Collections.sort(homeList);
		
		long res = 0;
		for (Home h : homeList) {
			res += h.a;
			if(res >= mid) {	// 사람들의 수를 최대한 균등하게 나눴을 때가 거리 합의 최소
				System.out.println(h.x);
				break;
			}
		}
	}
}
