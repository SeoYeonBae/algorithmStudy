package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891_DNA비밀번호 {

	static int correct, result;
	static int cntA, cntC, cntG, cntT;
	static int[] min;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		// S : 문자열의 길이 , P : 부분 문자열 길이
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		// minho : 민호가 입력한 문자열
		char[] minho = in.readLine().toCharArray();

		st = new StringTokenizer(in.readLine(), " ");
		// min: 비밀번호 사용 조건
		min = new int[4];
		int minNum;
		for(int i = 0; i < 4; i++) {
			minNum = Integer.parseInt(st.nextToken());
			if(minNum == 0)
				correct++;
			min[i] = minNum;
		}
		
		// 첫 입력에서 부분 문자열만큼만 초기화
		for(int i = 0; i < P; i++)
			add(minho[i]);
		
		checkPwd();
		
		// 한칸씩 이동하면서 앞에꺼 더하고 뒤에꺼 빼주기
		for (int i = P; i < S; i++) {
			int j = i - P;
			add(minho[i]);
			remove(minho[j]);
			checkPwd();
		}
		
		System.out.println(result);
		in.close();

	}

	private static void add(char m) {
		// 조건과 같을 때 한 번만 맞았다고 해줘야 함
		switch (m) {
		case 'A':
			cntA++;
			if(cntA == min[0])
				correct++;
			break;
		case 'C':
			cntC++;
			if(cntC == min[1])
				correct++;
			break;
		case 'G':
			cntG++;
			if(cntG == min[2])
				correct++;
			break;
		case 'T':
			cntT++;
			if(cntT == min[3])
				correct++;
			break;
		}
	}
	
	private static void remove(char m) {
		// 최소 개수 조건과 현재 부분 문자열에 들어있는 dna의 수가 같을 때는 빼주기 작업을 하면 조건 충족이 안 됨
		switch (m) {
		case 'A':
			if(cntA == min[0])
				correct--;
			cntA--;
			break;
		case 'C':
			if(cntC == min[1])
				correct--;
			cntC--;
			break;
		case 'G':
			if(cntG == min[2])
				correct--;
			cntG--;
			break;
		case 'T':
			if(cntT == min[3])
				correct--;
			cntT--;
			break;
		}
	}
	
	private static void checkPwd() {
		if(correct == 4)
			result++;
	}

}
