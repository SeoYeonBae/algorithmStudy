package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_16953_AB {

	static long A, B;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		res = Integer.MAX_VALUE;
		dfs(A, 1);
		
		if(res == Integer.MAX_VALUE)	// 못 만든 경우
			System.out.println(-1);
		else
			System.out.println(res);
	}
	
	private static void dfs(long num, int cnt) {
		if(num > B)		// 연산한 숫자가 만들어야 되는 숫자보다 커지면 연산할 필요없음, 왜냐 연산 과정에서 수가 줄어드는 과정이 없기 때문
			return;

		if(cnt > res)	// 연산 횟수가 최솟값을 넘어가면 더이상 연산할 필요 없음
			return;		
		
		if(num == B) {	// B를 만들었다면 최솟값 갱신하고 종료
			res = Math.min(res, cnt);
			return;
		}
		
		dfs(num * 2, cnt + 1);	// 2를 곱한다
		dfs(num * 10 + 1, cnt + 1);	// 1을 수의 가장 오른쪽에 추가한다
		
	}
}
