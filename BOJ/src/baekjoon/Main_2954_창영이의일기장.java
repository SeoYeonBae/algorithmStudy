package baekjoon;

import java.io.*;

public class Main_2954_창영이의일기장 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기 위한 reader
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력하기 위한 writer
		StringBuilder sb = new StringBuilder(); // 출력문을 더해 줄 StringBuilder

		String password = br.readLine(); // 입력값으로 주어지는 문장
		String[] pw = {"apa", "epe", "ipi", "opo", "upu"};
		String[] change = {"a", "e", "i", "o", "u"};

		for (int i = 0; i < 5; i++) {
			password = password.replace(pw[i], change[i]);
		}
		
		sb.append(password);
		br.close(); // 입력 받는 reader 다 써서 닫아줌
		bw.append(sb.toString()); // writer에 StringBuilder값 넣어줌
		bw.flush(); // 최종 결과 출력
		bw.close(); // writer 다 써서 닫아줌
	}
}
