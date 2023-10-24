package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2251_물통 {
	
	static class Bottle{
		int a, b, c;

		public Bottle(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	static int capacityA, capacityB, capacityC;
	static ArrayList<Integer> result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		capacityA = Integer.parseInt(st.nextToken());
		capacityB = Integer.parseInt(st.nextToken());
		capacityC = Integer.parseInt(st.nextToken());
		
		result = new ArrayList<>();
		bfs();
		Collections.sort(result);
		for(int res : result) {
			sb.append(res).append(" ");
		}
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
	private static void bfs() {
		Queue<Bottle> q = new LinkedList<>();
		boolean[][][] visit = new boolean[capacityA + 1][capacityB + 1][capacityC + 1];
		q.add(new Bottle(0, 0, capacityC));
		while(!q.isEmpty()) {
			Bottle cur = q.poll();
			
			if(visit[cur.a][cur.b][cur.c])
				continue;
			
			if(cur.a == 0)
				result.add(cur.c);
			
			visit[cur.a][cur.b][cur.c] = true;
			
			// C -> B
			if(cur.c + cur.b <= capacityB) {
				q.add(new Bottle(cur.a, cur.c + cur.b, 0));
			}else {
				q.add(new Bottle(cur.a, capacityB, cur.c + cur.b - capacityB));
			}
			// C -> A
			if(cur.c + cur.a <= capacityA) {
				q.add(new Bottle(cur.c + cur.a, cur.b, 0));
			}else {
				q.add(new Bottle(capacityA, cur.b, cur.c + cur.a - capacityA));
			}
			// B -> C
			if(cur.b + cur.c <= capacityC) {
				q.add(new Bottle(cur.a, 0, cur.b + cur.c));
			}else {
				q.add(new Bottle(cur.a, cur.b + cur.c - capacityC, capacityC));
			}
			// B -> A
			if(cur.b + cur.a <= capacityA) {
				q.add(new Bottle(cur.b + cur.a, 0, cur.c));
			}else {
				q.add(new Bottle(capacityA, cur.b + cur.a - capacityA, cur.c));
			}
			// A -> C
			if(cur.a + cur.c <= capacityC) {
				q.add(new Bottle(0, cur.b, cur.a + cur.c));
			}else {
				q.add(new Bottle(cur.a + cur.c - capacityC, cur.b, capacityC));
			}
			// A -> B
			if(cur.a + cur.b <= capacityB) {
				q.add(new Bottle(0, cur.a + cur.b, cur.c));
			}else {
				q.add(new Bottle(cur.a + cur.b - capacityB, capacityB, cur.c));
			}
		}
	}
}
