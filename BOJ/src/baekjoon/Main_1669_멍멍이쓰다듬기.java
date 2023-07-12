package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1669_멍멍이쓰다듬기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int gap = Y - X;

		int res = 0;
		
		if (gap <= 2)
			res = gap;
		else {
			int sqrt = (int) Math.sqrt(gap);
			if (sqrt * sqrt == gap) { // 원숭이와 멍멍이의 키 차이가 제곱수일 때
				res = (2 * sqrt) - 1; // 제곱수일때마다 (2 * N) + 1의 형태로 날짜가 늘어남 여기서 N은 gap의 제곱근
			} else {
				int small = (sqrt * sqrt); // 가장 가까운 제곱수 중 작은 수
				int large = ((sqrt + 1) * (sqrt + 1)); // 가장 가까운 제곲수 중 큰 수
				int cntHalf = (large - small) / 2; // 두 제곱 수 사이의 숫자 개수 절반을 기준으로 답이 나뉨
				if(gap <= small + cntHalf) {
					res = 2 * sqrt;
				}else {
					res = (2 * sqrt) + 1;
				}
			}
		}
		System.out.println(res);
	}
}
