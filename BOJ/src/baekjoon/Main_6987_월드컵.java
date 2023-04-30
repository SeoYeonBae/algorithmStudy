package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {

	static int[][] result;
	// 아래 상황을 배열로 표현
	// A: {B, C, D, E, F}, B: {C, D, E, F}, C: {D, E, F}, D: {E, F}, E: {F}
	// : 앞에 있는 걸 teamA에 두고 괄호 안에 : 앞이랑 싸우게 될 팀을 teamB에 둠
	// ex)
	// 우선 A = 0으로 teamA에 두고
	// A랑 싸우게 될 팀인 {B = 1, C = 2, D = 3, E = 4, F = 5}를 teamB에 배치
	static int[] teamA = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int[] teamB = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(br.readLine());

			int totalMatch = 0;
			result = new int[6][3];

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					result[i][j] = Integer.parseInt(st.nextToken());
					totalMatch += result[i][j];
				}
			}

			if (totalMatch != 30) { // 총 경기 결과 합이 30이 아니라면 애초에 확인할 필요가 없음
				sb.append("0 ");
			} else { // 총 경기 결과 합이 30일 때만 게임 가능한지 판단
				if (go(0))
					sb.append("1 ");
				else
					sb.append("0 ");
			}

		}

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}

	private static boolean go(int cnt) {
		if (cnt == 15) { // 5팀이 토너먼트할 경우 진행될 총 게임의 수는 15경기
			return true;
		}

		int tA = teamA[cnt];
		int tB = teamB[cnt];

		// A가 이김 : A의 이긴 횟수가 0보다 크고 B의 진 횟수가 0보다 커야 함
		if (result[tA][0] > 0 && result[tB][2] > 0) {
			result[tA][0]--;
			result[tB][2]--;
			if (go(cnt + 1)) // 현재 상황에서 게임이 계속 진행됐을 때 가능성이 있는지 판단하러 감
				return true;
			result[tA][0]++; // 다시 돌려 놓음
			result[tB][2]++;
		}

		// A와 B가 비김 : A와 B의 무승부 수가 0보다 커야 함
		if (result[tA][1] > 0 && result[tB][1] > 0) {
			result[tA][1]--;
			result[tB][1]--;
			if (go(cnt + 1))
				return true;
			result[tA][1]++;
			result[tB][1]++;
		}

		// A가 짐
		if (result[tA][2] > 0 && result[tB][0] > 0) {
			result[tA][2]--;
			result[tB][0]--;
			if (go(cnt + 1))
				return true;
			result[tA][2]++;
			result[tB][0]++;
		}
		
		return false;

	}
}