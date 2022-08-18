package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringTokenizer st2;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			
//			원본 암호문의 길이
			int N = Integer.parseInt(br.readLine());

//			원본 암호문 초기화
			List<String> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				list.add(st.nextToken());
			
//			명령어의 개수
			int M = Integer.parseInt(br.readLine());
			
//			구분자로 한 줄 씩 끊기
			st = new StringTokenizer(br.readLine(), "I");
			
//			한 줄을 띄어쓰기 단위로 다시 잘라서 리스트에 추가
			for (int i = 0; i < M; i++) {
				st2 = new StringTokenizer(st.nextToken(), " ");
//				리스트에 추가할 인덱스 위치와 수량
				int idx = Integer.parseInt(st2.nextToken());
				if(idx >= 10)
					continue;
				int cnt = Integer.parseInt(st2.nextToken());
				for(int j = 0; j < cnt; j++) {
					list.add(idx, st2.nextToken());
					idx++;
				}
			}
			for(int i = 0; i < 10; i++)
				sb.append(list.get(i)).append(" ");
			sb.append("\n");					
		}
		System.out.println(sb);
	}
}
