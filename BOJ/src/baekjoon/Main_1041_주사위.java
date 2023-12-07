package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1041_주사위 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] dice = new int[6];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		long res = 0;
		
		if(N == 1) {
			Arrays.sort(dice);
			for (int i = 0; i < 5; i++) {
				res += dice[i];
			}
		}else {
			// 3면이 보이는 경우
			// 마주 보지 않는 두 주사위의 면 중 작은 면을 선택해서 3면을 만듦
			long min = 0;
			for (int i = 0; i < 3; i++) {
				min += Math.min(dice[i], dice[5 - i]);
			}
			res += min * 4;
			
			// 2면이 보이는 경우
			// 마주 보는 면의 합 중 최솟값
			min = 987654321;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					if(i + j == 5)
						continue;
					
					if(i == j)
						continue;
					
					min = Math.min(min, dice[i] + dice[j]);
				}
			}
			res += min * (8L * (N - 2) + 4);
			
			// 1면이 보이는 경우
			min = dice[0];
			for (int i = 1; i < 6; i++) {
				min = Math.min(min, dice[i]);
			}
			res += min * (5L * (N - 2) * (N - 2) + 4L * (N - 2));
		}
		System.out.println(res);
	}
}
