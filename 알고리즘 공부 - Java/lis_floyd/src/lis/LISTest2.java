package lis;
import java.util.Arrays;
import java.util.Scanner;

public class LISTest2 {	 // DP 이용

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // 수열의 수들
		int[] C = new int[N];	// 동적테이블 C[k] : 해당(K) 길이를 만족하는 자리 (K자리)에 오는 수의 최소값
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int size = 0;
		
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(C, 0, size, arr[i]);
			if(pos >= 0)	// 대상을 찾음 = 즉, 이미 들어가 있는 값 -> 지나가야 됨
				continue;
			int insertPos = Math.abs(pos) - 1;	// 맨뒤가 될 수도 기존 원소 대체 자리가 될 수도
			C[insertPos] = arr[i];
			
			if(insertPos == size) size++;
		}
		
		System.out.println(size);
	}
}
