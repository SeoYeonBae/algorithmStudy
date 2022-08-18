package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_암호생성기 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			int cnt = 1;
			int num;
			
			int N = Integer.parseInt(in.readLine());
			sb.append("#").append(N).append(" ");

			Queue<Integer> queue = new ArrayDeque<>();
			st = new StringTokenizer(in.readLine());			
			for(int i = 0; i < 8; i++)
				queue.offer(Integer.parseInt(st.nextToken()));
			while(true) {
				num = queue.poll();
				if(num - cnt <= 0) {
					num = 0;
					queue.offer(num);
					break;
				}else {
					num -= cnt;
					queue.offer(num);
					cnt++;
				}
				
				if(cnt == 6)
					cnt = 1;
			}
			
			for(int q : queue)
				sb.append(q).append(" ");
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
}
