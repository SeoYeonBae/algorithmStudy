package baekjoon.class4;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1715_카드정렬하기 {

	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		int result = 0;
		int num;
		while(pq.size() != 1) {
			num = pq.poll() + pq.poll();
			result += num;
			pq.offer(num);
		}
		
		System.out.println(result);
		br.close();
	}
}
