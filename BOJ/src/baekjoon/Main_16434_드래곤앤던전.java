package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16434_드래곤앤던전 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Long atk = Long.parseLong(st.nextToken());
		
		Long curHp = 0L;
		Long maxHp = 0L;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			long h = Long.parseLong(st.nextToken());
			
			if(t == 1) {
				if(h % atk == 0) {	// 몬스터를 몇 번만에 죽일 수 있는지 확인
					curHp += a * ((h / atk) - 1);
				}else {
					curHp += a * ((h / atk) - 0);
				}
				maxHp = Math.max(maxHp, curHp);
			}else {
				atk += a;
				curHp = Math.max(curHp - h, 0);	// 0이상의 피를 갖게끔 하기
			}
		}
		
		System.out.println(++maxHp);
	}
}
