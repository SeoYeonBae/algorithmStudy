package test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_낚시터자리잡기 {

	static int N;
	static int[][] entrance;
	static int[] fishing;
	static int res;
	static boolean[] visited;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		entrance = new int[3][2]; // 낚시터 입구와 낚시꾼 수 배열
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 낚시터 자리 수

			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				entrance[i][0] = Integer.parseInt(st.nextToken());
				entrance[i][1] = Integer.parseInt(st.nextToken());
			}
			res = Integer.MAX_VALUE;
			visited = new boolean[3];
			numbers = new int[3];
			perm(0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void perm(int cnt) {
		if (cnt == 3) {
			System.out.println("--------------------------");
			System.out.println(Arrays.toString(numbers));
			fishing = new int[N + 1];
			seating(0, fishing);
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			numbers[cnt] = i;
			perm(cnt + 1);
			visited[i] = false;
		}
	}

	private static void seating(int cnt, int[] fishing) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 1; i <= N; i++)
				sum += fishing[i];
			res = sum < res ? sum : res;
			System.out.println(Arrays.toString(fishing));
			System.out.println(sum);
			return;
		}

		int num = entrance[numbers[cnt]][0];
		int fisher = entrance[numbers[cnt]][1];

		if (fishing[num] == 0) {
			fishing[num] = 1;
			fisher--;
		}
		
		if(fisher == 0) seating(cnt + 1, fishing);
		int left = num - 1, right = num + 1;

		while (fisher > 1) { // 마지막 애 빼고 나머지 처리
			while (left > 1 && fishing[left] != 0)
				left--;
			while (right <= N && fishing[right] != 0)
				right++;

			if (left < 1) { // left가 범위 벗어나면 right에 담음
				fishing[right] = right - num + 1;
			} else if (right >= N) { // right가 범위 벗어나면 left에 담음
				fishing[left] = num - left + 1;
			} else if (num - left < right - num) { // left가 더 가까우면 left에 넣음
				fishing[left] = num - left + 1;
			} else if (right - num < num - left) { // right가 더 가까우면 right에 넣음
				fishing[right] = right - num + 1;
			} else { // 둘이 같으면 left에 넣음
				fishing[left] = num - left + 1;
			}

			fisher--;
		}

		if(fisher == 1) {
			while (left > 0 && fishing[left] != 0)
				left--;
			while (right <= N && fishing[right] != 0)
				right++;
			if (num - left == right - num && left > 1 && right <= N) { // 마지막 하나를 넣어야 하는데 거리가 같다면
				int[] tmp = fishing.clone();
				fishing[left] = num - left + 1;
				seating(cnt + 1, fishing);
				tmp[right] = right - num + 1;
				seating(cnt + 1, tmp);
			} else { // 마지막 하나를 넣어야 하는데 거리가 다른 상황
				if (left < 1) // left가 범위 벗어나면 right에 담음
					fishing[right] = right - num + 1;
				else if (right > N) // right가 범위 벗어나면 left에 담음
					fishing[left] = num - left + 1;

				else if (num - left < right - num) // left가 더 가까우면 left에 넣음
					fishing[left] = num - left + 1;

				else if (right - num < num - left) // right가 더 가까우면 right에 넣음
					fishing[right] = right - num + 1;

				seating(cnt + 1, fishing);
			}
		}
		
	}
}
