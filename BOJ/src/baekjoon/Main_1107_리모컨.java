package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1107_리모컨 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		if (N == 100) { // 초기 위치와 목표가 같다면 움직일 필요 없음
			System.out.println(0);
		} else {
			int M = Integer.parseInt(br.readLine());
			boolean[] btnsIsBroken = new boolean[10]; // 버튼의 고장 여부 배열
			if(M != 0) {
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < M; i++) {
					btnsIsBroken[Integer.parseInt(st.nextToken())] = true;
				}				
			}
			
			int res = Math.abs(N - 100); // 100에서 움직이는 횟수로 초기화
			for (int i = 0; i <= 999999; i++) { // 0~999999까지 숫자 만들고 +-로 움직임
				String chanel = String.valueOf(i);

				boolean broken = false;
				for (int j = 0; j < chanel.length(); j++) { // 고장난 버튼으로 만든 숫자인지 확인
					if (btnsIsBroken[chanel.charAt(j) - '0']) {
						broken = true;
						break;
					}
				}

				if (broken)
					continue;

				res = Math.min(res, Math.abs(N - i) + chanel.length());
			}
			System.out.println(res);
		}

	}
}
