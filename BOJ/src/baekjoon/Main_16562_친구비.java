package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16562_친구비 {

	static int[] parents, money;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		money = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int total = 0;
		boolean[] visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			int root = find(i);
			if(!visit[root]) {
				visit[root] = true;
				total += money[root];
			}
		}
		
		if(total <= K)
			System.out.println(total);
		else
			System.out.println("Oh no");
	}
	private static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);

		if(parentA == parentB)
			return;
		
		if(money[parentA] <= money[parentB])
			parents[parentB] = parentA;
		else
			parents[parentA] = parentB;
		
	}
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
}
