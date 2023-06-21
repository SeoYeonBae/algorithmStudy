package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1717_집합의표현 {

	static int[] parents;
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n + 1];
		make();
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			if(order == 0) {
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}else {
				if(find(Integer.parseInt(st.nextToken())) == find(Integer.parseInt(st.nextToken())))
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
			}
		}
		
		bw.append(sb);
		bw.flush();
		br.close();
		bw.close();
	}
	
	private static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if(A != B) {
			if(A <= B) {
				parents[B] = A;
			}else {
				parents[A] = B;
			}			
		}		

	}

	private static int find(int a) {
		if(parents[a] == a)
			return a;
		
		return parents[a] = find(parents[a]);
	}

	public static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
}
