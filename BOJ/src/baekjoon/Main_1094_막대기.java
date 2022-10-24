package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1094_막대기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 객체 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위한 객체 생성
		StringBuilder sb = new StringBuilder(); // 출력을 위한 객체 생성

		int X = Integer.parseInt(br.readLine()); // 만들어야 하는 길이 X

		int res = 0; // 최종 출력값

		if (X == 64) // 자를 필요가 없는 막대라면
			res = 1; // 막대 하나가 답이므로 아래 과정을 해주지 않음
		else { // 자를 필요가 있을 때
			List<Integer> list = new ArrayList<>(); // 막대 담을 리스트

			list.add(64); // 첫 막대는 64로 고정이라 바로 담아줌

			while (true) { // 문제를 해결하기 위한 반복문
				int shortNum = list.get(0) / 2; // 가장 짧은 막대를 반으로 자름
				list.remove(0); // 꺼내서 자른 막대니까 리스트에서 없애줌
				list.add(shortNum); // 막대 중 하나는 리스트에 바로 넣어줌
				int sum = makeSum(list); // 리스트에 남아있는 막대들의 합을 구함
				if (sum == X) { // 합이 원하는 길이와 같다면
					res = list.size(); // 리스트의 사이즈가 필요한 막대의 수
					break; // 원하는 결과 얻어서 멈춰줌
				} else if (sum < X) // 막대의 합이 X보다 작다면
					list.add(shortNum); // 자르고 남은 막대도 리스트에 넣어줌

				Collections.sort(list); // 가장 짧은 막대를 꺼내기 위해 정렬
			}

		}
		System.out.println(res);

		br.close(); // 다 써서 닫아줌
		bw.append(sb.toString()); // 출력할 문구 더해줌
		bw.flush(); // 출력
		bw.close(); // 다 써서 닫아줌
	}

	private static int makeSum(List<Integer> list) { // 막대의 합을 구하는 함수
		int sum = 0; // 합계를 반환하기 위한 변수
		for (int i = 0; i < list.size(); i++) { // 리스트의 사이즈만큼 더해줌
			sum += list.get(i); // 리스트에서 하나씩 받아와 합해줌
		}
		return sum; // 막대의 합 반환
	}
}
