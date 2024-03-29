package baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) == Math.abs(o2))
					return o1 - o2;
				if(Math.abs(o1) < Math.abs(o2))
					return -1;
				else
					return 1;
			}
		});
				
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(absHeap.size() == 0)
					sb.append(0).append("\n");
				else
					sb.append(absHeap.poll()).append("\n");
			}
			else {
				absHeap.add(num);
			}
		}
		
		bw.append(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
}
