package lis;
import java.util.Arrays;
import java.util.Scanner;

public class LISTest1 {	 // DP 이용

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1)
					LIS[i] = LIS[j] + 1;
			}
			max = Math.max(max, LIS[i]);
		}
		
		System.out.println(Arrays.toString(LIS));
		System.out.println(max);
		
	}
}
