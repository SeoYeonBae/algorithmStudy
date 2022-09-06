package baekjoon;

import java.io.*;
import java.util.*;

public class Main_13913_숨바꼭질4 {
	
	static int[] dp;
	static int[] path;
	static Queue<Integer> q;
	static int N, K;
	static StringBuilder sb;
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N == K) {			// 같을 때
			sb.append(0).append("\n").append(N);
		}else if(K < N) {		// 동생이 더 뒤에 있을 때
			sb.append(N - K).append("\n");
			for (int i = N; i >= K; i--)
				sb.append(i).append(" ");
		}else {
			dp = new int[100001];	// 해당 숫자까지 움직인 횟수
			path = new int[100001];	// 오기 직전 숫자
			q = new ArrayDeque<Integer>();
			
			Arrays.fill(dp, -1);
			dp[N] = 0;
			q.offer(N);
			bfs();
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int num = q.poll();
			if(num == K) {
				System.out.println(dp[num]);
				while(num != N) {	// 직전 숫자를 거꾸로 따라감
					sb.insert(0, num + " ");	// 제일 앞에 넣어줌
					num = path[num];
				}
				sb.insert(0,  num + " ");
				return;
			}
			int[] nums = {num - 1, num + 1, num * 2};
			for(int n : nums) {
				// 범위 내에 있고 한 번도 방문 안 한 곳 왜냐면 방문 했던 곳이면 과거에 걍 거기서 출발하는 게 베스트
				if(n < 0 || n > 100000 || dp[n] != -1) continue;	
				dp[n] = dp[num] + 1;
				path[n] = num;
				q.offer(n);
			}
		}
	}
}
