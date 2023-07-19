package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {

	static int[] map, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[101];	// 뱀과 사다리 정보를 저장해둘 배열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		min = new int[101];	// 해당 숫자까지 오는 횟수의 최솟값을 저장할 배열
		Arrays.fill(min, Integer.MAX_VALUE);
		
		go(1, 0);
		
		System.out.println(min[100]);
	}

	private static void go(int cur, int cnt) {
		if (min[cur] <= cnt)	// 해당 숫자에 더 적은 횟수로 오는 방법이 있었다면 return
			return;

		if (cur == 100) {	// 마지막에 도달했다면 최솟값 갱신 후 return
			min[cur] = Math.min(min[cur], cnt);
			return;
		}

		min[cur] = cnt;

		for (int i = 1; i <= 6; i++) {
			int next = cur + i;

			if (next > 100)	// 100이 넘는 수는 갈 수 없음  
				continue;

			if (map[next] != 0)	// 뱀이나 사다리가 있다면 다음 칸은 이에 따라 달라짐
				next = map[next];
			
			go(next, cnt + 1);	// 다음 숫자로 이동
		}

	}
}
