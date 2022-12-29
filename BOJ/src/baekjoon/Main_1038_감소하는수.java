package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1038_감소하는수 {

	static List<Long> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N <= 10) {
			System.out.println(N);
		}else if(N > 1022){
			// 리스트 끝까지 만들고 사이즈 출력해보니 1023
			// 즉, 마지막 인덱스는 1022
			System.out.println(-1);
		}else {
			list = new ArrayList<>();
			// 감소하는 수 한자리짜리 init
			for (long i = 0; i < 10; i++) {
				list.add(i);
			}
			for (int i = 0; i < 10; i++) {
				make(i, 2);
			}
			Collections.sort(list); // N번째 수를 가져오기 위한 정렬
//			System.out.println(list);
//			System.out.println(list.size());
			System.out.println(list.get(N));
		}
		
		
		
	}
	// cnt : 자릿수
	private static void make(long num, int cnt) {
		// 10자리까지 만들 수 있음
		// 0~9로 만들 수 있는 가장 큰 감소 숫자가 9876543210이기 때문
		if(cnt > 10)	
			return;
				
		// ex)
		// num = 543일 때 i = 0 ~ 2
		// 만들어지는 수는 5430, 5431, 5432
		for (int i = 0; i < num % 10; i++) {
			long clacNum = (num * 10) + i;
			list.add(clacNum);
			make(clacNum, cnt + 1);
		}
	}
}
