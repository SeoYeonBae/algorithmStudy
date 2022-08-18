package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_2164_카드2 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= N; i++)
			queue.offer(i);
		while(true){
			if(queue.size() == 1)
				break;
			queue.poll();
			int tmp = queue.poll();
			queue.offer(tmp);
		}
		System.out.println(queue.poll());
	}
	
}
