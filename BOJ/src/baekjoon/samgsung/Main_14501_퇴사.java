package baekjoon.samgsung;

import java.io.*;
import java.util.*;

public class Main_14501_퇴사 {
	static int N, res;
	static List<int[]> input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		input = new ArrayList<int[]>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		go(0, 0);
		System.out.println(res);
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void go(int day, int money) {
		if (day > N)	// 퇴사일보다 더 많이 일했으면 그냥 리턴
			return;

		if (day == N) {	// 퇴사일에 정확히 끝나면
			res = money > res ? money : res;	// 더 큰 걸 답으로
			return;
		}

		int t = input.get(day)[0];
		int p = input.get(day)[1];
		
		go(day + t, money + p);	// 선택 했을 때
		go(day + 1, money);	// 선택하지 않았을 때
	}

}
