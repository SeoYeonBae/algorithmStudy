package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1461_도서관 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> negative = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		PriorityQueue<Integer> positive = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num < 0)
				negative.offer(num);
			else
				positive.offer(num);
		}

		int maxStep = 0;	// 제일 먼 곳을 마지막으로 간다면 다시 돌아오지 않아도 돼서 이득
		if(negative.isEmpty())
			maxStep = positive.peek();
		else if(positive.isEmpty())
			maxStep = negative.peek() * -1;
		else
			maxStep = Math.max(Math.abs(negative.peek()), Math.abs(positive.peek()));
	
		int res = 0;
		
		// 먼 곳까지 갔다가 책 다시 두고 오면서 0으로 돌아오기 때문에 움직이는 거리는 (먼 곳 * 2)
		while (!negative.isEmpty()) {
			int step = (negative.peek() * -1) * 2;
			res += step;
			for (int i = 0; i < M; i++) {
				negative.poll();
			}
		}
		
		while(!positive.isEmpty()) {
			int step = positive.peek() * 2;
			res += step;
			for (int i = 0; i < M; i++) {	
				positive.poll();
			}
		}
		
		sb.append(res - maxStep);
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}
