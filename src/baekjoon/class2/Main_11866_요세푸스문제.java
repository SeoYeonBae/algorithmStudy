package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11866_요세푸스문제 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());			//	사람 수 
		int K = Integer.parseInt(st.nextToken());			//	제거할 순서
		
		List<Integer> people = new ArrayList(); 	//	리스트 초기화
		for (int i = 1; i <= N; i++)
			people.add(i);

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		for(int i = 0; i < N; i++) {
			
		}
		while (!people.isEmpty()) {				//	리스트 빌 때까지 반복
			for (int i = 0; i < K; i++) {
				if (i == K - 1) {				// 제거할 순서일 때는 제거
					sb.append(people.remove(i));
					if (people.size() != 0)		//	마지막은 컴마 없이 출력
						sb.append(", ");
				}
				else 							//	제거할 순서가 아닐 때는 리스트 마지막으로 보냄
					people.add(people.remove(i));
			}
		}
		
		sb.append(">");
		System.out.println(sb);
	}

}
