package baekjoon;

import java.io.*;
import java.util.*;

public class Main_12851_숨바꼭질2 {

	static int N, K, min, cnt;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K == N) { // 수빈이와 동생의 위치가 같을 때
			System.out.println(0);
			System.out.println(1);
		} else if (K < N) { // 동생이 수빈이보다 앞에 있을 땐 -1로만 이동 가능
			System.out.println(N - K);
			System.out.println(1);
		} else {
			min = Integer.MAX_VALUE; // 동생을 찾는 가장 빠른 시간
			cnt = 0; // 동생을 찾는 방법의 수
			visit = new boolean[100001];
            
            go();
            
            System.out.println(min);
			System.out.println(cnt);
		}
	}

	// 현재 수빈이의 위치와 움직인 횟수
	private static void go() {
		Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {N, 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int num = cur[0];
            int step = cur[1];
            
            visit[num] = true;
            
            if(num == K && step <= min){
                cnt++;
                min = Math.min(step, min);
                continue;
            }

            if(num - 1 > 0 && !visit[num - 1])
                q.offer(new int[] {num - 1, step + 1});
            
            if(num + 1 < 100001 && !visit[num + 1])
                q.offer(new int[] {num + 1, step + 1});
                
            if(num * 2 < 100001 && !visit[num * 2])
                q.offer(new int[] {num * 2, step + 1});
        }
        
	}
}
