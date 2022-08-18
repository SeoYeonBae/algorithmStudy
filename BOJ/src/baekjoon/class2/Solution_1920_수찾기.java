package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1920_수찾기 {

	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		int num;
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		for (int j = 0; j < M; j++) {
			num = Integer.parseInt(st.nextToken());
			if (binarySearch(A, num, 0, A.length - 1))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

	private static boolean binarySearch(int[] A, int num, int start, int end) {
		if (start > end)
			return false;
		int mid = (start + end) / 2;
		if (A[mid] < num)
			return binarySearch(A, num, mid + 1, end);
		else if (A[mid] > num)
			return binarySearch(A, num, 0, mid - 1);
		else
			return true;
	}
}
