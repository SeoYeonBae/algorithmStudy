package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1697_숨바꼭질 {

	static boolean[] isVisited;
	static int[] soobin;
	static Queue<Integer> q;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		isVisited = new boolean[100001];
		soobin = new int[100001];
		q = new ArrayDeque<Integer>();

		if (N == K)
			System.out.println(0);
		else
			bfs(N);
	}

	private static void bfs(int v) {
		q.offer(v);
		isVisited[v] = true;
		int num, nc;
		
		while (!q.isEmpty()) {
			num = q.poll();
			int[] dir = { -1, 1, num };

			for (int d : dir) {
				nc = num + d;


				if (nc < 0 || nc >= isVisited.length)
					continue;
				
				if(!isVisited[nc]) {
					isVisited[nc] = true;
					soobin[nc] = soobin[num] + 1;
					q.offer(nc);					
				}

				if (nc == K) {
					System.out.println(soobin[nc]);
					return;
				}

			}
		}

	}
}
