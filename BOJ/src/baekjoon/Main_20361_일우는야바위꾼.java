package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20361_일우는야바위꾼 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력하기 위한 writer
		StringBuilder sb = new StringBuilder(); // 출력문을 더해 줄 StringBuilder
		StringTokenizer st; // 공백을 기준으로 입력을 구분해줌

		int N, X, K; // 함수 결과, 종이컵의 수, 종이컵의 위치, 컵 바꾸는 횟수
		int A, B; // 바꾸려는 두 위치

		st = new StringTokenizer(br.readLine(), " "); // 종이컵의 수, 종이컵의 위치, 컵 바꾸는 횟수 입력 받을 준비
		N = Integer.parseInt(st.nextToken()); // 종이컵의 수
		X = Integer.parseInt(st.nextToken()); // 종이컵의 위치
		K = Integer.parseInt(st.nextToken()); // 컵 바꾸는 횟수

		for (int i = 0; i < K; i++) { // 컵 바꾸는 횟수만큼 반복
			st = new StringTokenizer(br.readLine(), " "); // 컵 바꾸는 위치 받기 위한 준비
			A = Integer.parseInt(st.nextToken()); // 바꾸는 위치 입력 받기
			B = Integer.parseInt(st.nextToken()); // 바꾸는 위치 입력 받기

			if (A == X) { // 바꾸려는 A 위치가 간식이 위치한 종이컵이라면
				X = B; // 간식은 B에 존재하게 됨
			} else if (B == X) { // 바꾸려는 B 위치가 간식이 위치한 종이컵이라면
				X = A; // 간식은 A에 존재하게 됨
			}
		}

		System.out.println(X);
		br.close(); // writer 다 써서 닫아줌

	}
}
