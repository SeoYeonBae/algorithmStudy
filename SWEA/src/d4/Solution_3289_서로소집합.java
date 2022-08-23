package d4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	static int[] parents;
	static int N, M;

	static void make() {
		parents = new int[N];

		for (int i = 1; i < N; i++) {
			parents[i] = i;
		}
	}

	static int find(int num) {
		if (parents[num] == num)
			return num;
		return parents[num] = find(parents[num]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()) + 1;
			M = Integer.parseInt(st.nextToken());

			make();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				if (Integer.parseInt(st.nextToken()) == 1) { // 두 원소가 같은 합집합인지 확인하는 1 a b 연산
					if (find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())))
						sb.append(1);
					else
						sb.append(0);
				} else { // 두 원소를 합치는 0 a b 연산
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
			}
			sb.append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
