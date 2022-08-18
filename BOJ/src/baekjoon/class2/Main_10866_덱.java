package baekjoon.class2;

import java.io.*;
import java.util.*;

public class Main_10866_덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Integer> q = new ArrayDeque<Integer>();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push_front":
				q.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				q.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.pollFirst()).append("\n");
				break;
			case "pop_back":
				if(q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.pollLast()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				if(q.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "front":
				if(q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.peekFirst()).append("\n");
				break;
			case "back":
				if(q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.peekLast()).append("\n");
				break;

			default:
				break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
	
}
