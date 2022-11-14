package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1292_쉽게푸는문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int cnt = 1;	// 수열의 총 길이
		int limit = 2;	// 더하는 숫자
		while(true) {
			cnt += limit++;
			if(cnt >= B)
				break;
		}	// 수열을 만들 때 더해야하는 숫자의 최소값 계산
		// 수열의 총 길이가 B보다 같거나 커지면 종료
		
		List<Integer> list = new ArrayList<Integer>();
		cnt = 1;
		for (int i = 1; i < limit; i++) {
			for (int j = 0; j < i; j++) {
				list.add(cnt);
			}
			cnt++;
		}	// 구한 limit까지 문제에서 요구하는 수열을 만듦
		
		int res = 0;
		for(int i : list.subList(A - 1, B))	// 부분리스트를 구해서 최종 변수에 더하고 출력
			res +=  i;
		
		System.out.println(res);
		br.close();
	}
}
