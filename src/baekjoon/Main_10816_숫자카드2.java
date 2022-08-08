package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {

	static int[] dog, card;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		// 상근이 카드
		int N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		dog = new int[N];
		for(int i = 0; i < N; i++)
			dog[i] = Integer.parseInt(st.nextToken());
		
		// 몇 개 가지고 있는 숫자 카드인지 구해야 할 정수와 카드
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		card = new int[M];
		for(int i = 0; i < M; i++)
			card[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(dog);
		System.out.println(Arrays.toString(dog));
		// 오른쪽 인덱스 - 왼쪽인덱스 = 중복된 개수
		int leftIdx;
		int rightIdx;
		
		for(int i = 0; i < M; i++) {
			leftIdx = left(card[i], 0, N - 1);
			rightIdx = right(card[i], 0, N - 1);
			System.out.println("l : " + leftIdx);
			System.out.println("r : " + rightIdx);
		}
	}

	private static int left(int target, int start, int end) {
		int mid = (start + end) / 2;
		if(start > end)
			return 0;
		if(target <= dog[mid])
			left(target, start, mid - 1);
		return start;
		
	}
	
	private static int right(int target, int start, int end) {
		int mid = (start + end) / 2;
		if(start > end)
			return 0;
		if(target >= dog[mid])
			right(target, mid + 1, end);
		return start;
	}
}
