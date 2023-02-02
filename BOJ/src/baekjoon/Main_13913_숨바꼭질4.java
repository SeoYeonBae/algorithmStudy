package baekjoon;

import java.io.*;
import java.util.*;

public class Main_13913_숨바꼭질4 {

    static int N, K;
    static int[] history;
    static int[] visit;
    static int INF = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            sb.append(0).append("\n").append(N);
        } else if (K < N) {
            sb.append(N - K).append("\n");
            for (int i = N; i >= K; i--) {
                sb.append(i).append(" ");
            }
        } else {
            history = new int[INF];    // 현재 위치 오기 직전 숫자
            visit = new int[INF];    // 방문 여부 = 해당 숫자까지 걸린 스텝 수 
            Arrays.fill(visit, -1);
            
            bfs();
            
            int num = K;
            while(num != N) {
            	sb.insert(0, num + " ");
            	num = history[num];
            }
            sb.insert(0, num + " ");
            sb.insert(0, visit[K] + "\n");
        }
        bw.append(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        visit[N] = 0;
        history[N] = N;
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K)
                return;

            if (cur * 2 < INF && visit[cur * 2] == -1) {
                visit[cur * 2] = visit[cur] + 1;
                history[cur * 2] = cur;
                q.offer(cur * 2);
            }
            if (cur + 1 < INF && visit[cur + 1] == -1) {
                visit[cur + 1] = visit[cur] + 1;
                history[cur + 1] = cur;
                q.offer(cur + 1);
            }
            if (cur - 1 > 0 && visit[cur - 1] == -1) {
                visit[cur - 1] = visit[cur] + 1;
                history[cur - 1] = cur;
                q.offer(cur - 1);
            }
        }

    }
}
