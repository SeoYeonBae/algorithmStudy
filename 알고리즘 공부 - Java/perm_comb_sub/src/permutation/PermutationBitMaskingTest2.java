package permutation;
import java.util.Arrays;
import java.util.Scanner;

public class PermutationBitMaskingTest2 {
	
	static int N, R, totalCnt;
	static int[] numbers, input;
	
	// nPn : 1부터 n까지의 수 중 n개를 모두 뽑아 순서적으로 나열한 것 (입력 수 1 ~ 100000)
	// nPr : 1부터 n까지의 수 중 r개를 모두 뽑아 순서적으로 나열한 것 (1 <= r <= n)
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		
		input = new int[N];
		numbers = new int[R];
	
		for(int i = 0; i < N; i++)
			input[i] = sc.nextInt();
		
		perm(0, 1);
		System.out.println("총 경우의 수 : " + totalCnt);
	}
	// cnt: 직전까지 뽑은 순열에 포함된 수의 개수. cnt + 1번째 해당되는 순열에 포함된 수를 뽑기
	// flag : 선택된 수들의 상태를 비트로 표현하고 있는 비트열(정수)
	private static void perm(int cnt, int flag) { 
//		if(cnt == N) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수에 대해 시도 (input 배열의 모든 수 시도)
		for(int i = 0; i < N; i++) {	// 선택지
			// 시도하는 수가 선택되었는지 판단
			if((flag & 1 << i) != 0) continue;
			// 앞쪽에서 선택되지 않았다면 수를 사용
			numbers[cnt] = input[i];
			// 다음 수 뽑으러 가기
			perm(cnt + 1, flag | 1 << i);
		}
		
	}
}
