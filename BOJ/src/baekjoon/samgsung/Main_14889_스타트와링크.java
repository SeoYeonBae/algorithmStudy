package baekjoon.samgsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_14889_스타트와링크 {
	
	static int N, combCnt, sumA, sumB, min;
	static long M;
	static int[][] adjMap;
	static List<Integer> A, B;
	static int[] a, b;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		adjMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adjMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		A = new ArrayList<Integer>();	// 스타트팀
		B = new ArrayList<Integer>();	// 링크팀
		
		min = Integer.MAX_VALUE;
		M = 1;	// 만들어질 수 있는 조합 계산
		for (int i = 2; i <= N; i++)
			M *= i;
		for (int i = 2; i <= N / 2; i++)
			M /= i;
		for (int i = 2; i <= N - (N / 2); i++)
			M /= i;
		M /= 2;
		
		combCnt = 0;
		comb(0, 0);
	}
	private static void comb(int start, int cnt) {
		if(cnt == N / 2) {
			// 반씩 뽑아서 스타트와 링크팀으로 나눔
			B.clear();
			for (int i = 0; i < N; i++) {
				if(!A.contains(i))
					B.add(i);
			}
			if(combCnt == M) {	// 만들어질 수 있는 조합의 반만 계산하면 됨,	둘의 차만 구하면 되기 때문
				System.out.println(min);
				System.exit(0);
			}
			combCnt++;
			calc();
			return;
		}
		
		for (int i = start; i < N; i++) {
			A.add(i);
			comb(i + 1, cnt + 1);
			A.remove(cnt);
		}
	}
	private static void calc() {
		// 스타트 팀에 있는 모든 구성원의 능력치 합을 구함
		sumA = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				sumA += adjMap[A.get(i)][A.get(j)];
			}
		}
		// 링크 팀에 있는 모든 구성원의 능력치 합을 구함
		sumB = 0;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				sumB += adjMap[B.get(i)][B.get(j)];
			}
		}
		
		min = Math.min(min, Math.abs(sumA - sumB));
		
		if(min == 0) {	// 능력치의 최소는 0, 결과가 0이 되면 더이상 함수 진행하지 않아도 됨
			System.out.println(0);
			System.exit(0);
		}
	}
}
