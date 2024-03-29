package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1074_Z {

	static int N, r, c;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		divisionMap(0, 0, (int)Math.pow(2, N) / 2);
		System.out.println(res);
	}

	private static void divisionMap(int startR, int startC, int half) {	// 주어진 좌표가 어디에 해당하는지 알아내기
		if(half == 0)
			return;
		if(r < startR + half && c < startC + half) {	// 제 2사분면
			divisionMap(startR, startC, half/2);
		}
		else if(r < startR + half && c >= startC + half) {	// 제 1사분면
			res += half * half;
			divisionMap(startR, startC + half, half/2);
		}
		else if(r >= startR + half && c < startC + half) {	// 제 3사분면
			res += half * half * 2;
			divisionMap(startR + half, startC, half/2);
		}
		else {	// 제 4사분면
			res += half * half * 3;
			divisionMap(startR + half, startC + half, half/2);
		}
	}
}
