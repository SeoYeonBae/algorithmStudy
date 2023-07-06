package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1263_시간관리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] timeTable = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			timeTable[i][0] = Integer.parseInt(st.nextToken()); // 걸리는 시간
			timeTable[i][1] = Integer.parseInt(st.nextToken()); // 끝나는 시간
			timeTable[i][2] = timeTable[i][1] - timeTable[i][0]; // 일을 시작해야 하는 시간

		}

		Arrays.sort(timeTable, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] != o2[1] ? o1[1] - o2[1] : o1[2] - o2[2];
			}
		});	// 일을 끝내야 하는 시간 순으로 정렬하고 끝내야 하는 시간이 같다면 시작해야 하는 시간 순으로 정렬

		int res = 0;
		boolean isPossible = true;
		loop: while (res <= timeTable[0][2]) {	// 0시부터 최대한 늦게 시작할 수 있는 시간까지 반복
			int nextTime = res;
			for (int i = 0; i < N; i++) {	// 시작 시간부터 일을 했을 때 완료할 수 있는지 확인
				nextTime += timeTable[i][0];
				if (nextTime > timeTable[i][1]) {	// 일을 했을 때 마감 기간을 넘긴다면 반복문 멈춤
					isPossible = false;
					break loop;
				}
			}
			res++;
		}

		if(isPossible && res == 0)	// 0시에서 시작해도 성공할 수 없는 경우
			System.out.println(-1);
		else
			System.out.println(res - 1);
	}
}
