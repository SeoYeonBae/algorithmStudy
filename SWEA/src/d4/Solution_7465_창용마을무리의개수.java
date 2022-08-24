package d4;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수 {

	static int[] parents;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int res;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()) + 1;
			M = Integer.parseInt(st.nextToken());

			parents = new int[N];
			for (int i = 1; i < N; i++)
				parents[i] = i;
			
			res = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			for(int i = 1; i < N; i++) {	
				if(find(i) == i)	// union으로 합쳐줬기 때문에 부모와 자기 자신이 같은 경우가 마을의 수
					res++;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");

		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return;

		parents[bRoot] = aRoot;
	}

}
