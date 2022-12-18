package baekjoon.samgsung;

import java.io.*;
import java.util.*;

public class Main_13458_시험감독 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());	// 시험장의 개수
		int[] A = new int[N];	// 각 시험장의 응시자 수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());	// 총감독관
		int C = Integer.parseInt(st.nextToken());	// 부감독관
		
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = A[i];
			
			num -= B;	// 총감독관
			cnt++;
			
			if(num <= 0)	// 총감독관 혼자 감당 가능한 시험장이면 패스
				continue;
			
			if(num % C == 0)	// 남은 응시자 수가 부감독관의 배수이면
				cnt += (num / C);
			else	// 배수가 아니면
				cnt += (num / C) + 1;
			
		}
		System.out.println(cnt);
		br.close();
	}
}
