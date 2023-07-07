package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {

	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}
		
		boolean isPossible = true;
		st = new StringTokenizer(br.readLine());
		int root = find(Integer.parseInt(st.nextToken()) - 1);
		for (int i = 1; i < M; i++) {
			if(root != find(Integer.parseInt(st.nextToken()) - 1)) {
				isPossible = false;
				break;
			}
		}
		
		if(isPossible)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	private static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA == parentB)
			return;
		
		if(a <= b)
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
