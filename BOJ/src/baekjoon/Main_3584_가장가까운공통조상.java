package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3584_가장가까운공통조상 {

	static int N;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			parents = new int[N + 1];
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parents[b] = a;
			}
			st = new StringTokenizer(br.readLine());
			sb.append(find(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
		}
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
	private static int find(int a, int b) {
		boolean[] visit = new boolean[N + 1];
		int res = 0;
		
		while(true) {
			visit[a] = true;
			a = parents[a];
			if(a == 0)
				break;
		}

		while(true) {
			if(visit[b]) {
				res = b;
				break;
			}
			visit[b] = true;
			b = parents[b];
		}
		
		return res;
	}
}
