package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12893_적의적 {
	
	
	static int N, M;
	static boolean isBinary;
	static int[] visit;
	static List<List<Integer>> enemy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		enemy = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			enemy.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			enemy.get(a).add(b);
			enemy.get(b).add(a);
		}
		
		isBinary = true;
		visit = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if(visit[i] == 0)
				if(!bfs(i))
					break;
		}
		
		if(isBinary)
			System.out.println(1);
		else
			System.out.println(0);
	}
	private static boolean bfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		visit[num] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(Integer i : enemy.get(cur)) {
				if(visit[i] == 0) {
					visit[i] = visit[cur] * -1;
					q.add(i);
				}else if(visit[i] == visit[cur]) {
					isBinary = false;
					return false;
				}
			}
		}
		return true;
		
	}

}
