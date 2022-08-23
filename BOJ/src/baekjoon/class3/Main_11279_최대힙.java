package baekjoon.class3;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11279_최대힙 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		int x;
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(minHeap.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(minHeap.poll()).append("\n");
			}
			else
				minHeap.offer(x);
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
