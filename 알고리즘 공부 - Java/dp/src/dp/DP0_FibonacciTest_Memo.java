package dp;

import java.util.Scanner;
/**
 * @author THKim
 */
public class DP0_FibonacciTest_Memo {

	static long[] call1,call2,memo;
	static long totalCnt1,totalCnt2;
	
	// 피보나치 n항을 계산하여 리턴 
	public static long fibo(int n) {
		++call1[n];
		++totalCnt1;
		if (n <= 1) return n;
		return fibo(n - 1) + fibo(n - 2); // 전체적으로 중복되는 호출이 많아져서 시간이 오래 걸리는 문제점.
	}
	// 메모버전 : 피보나치 n항을 계산하여 리턴 
	public static long fibo2(int n) {
		++call2[n];
		++totalCnt2;
		if (n>=2 && memo[n] == 0) {
			memo[n] = fibo2(n - 1) + fibo2(n - 2);
		}
		return memo[n];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 45  정도로 테스트
		call1 = new long[N+1];
		call2 = new long[N+1];
		memo = new long[N+1];
		memo[0]=0; memo[1]=1;
		
		System.out.println(fibo2(N)); // 메모버전 
		for(int i=0; i<=N;++i) {
			System.out.println("fibo2("+i+") : "+call2[i]);
		}
		System.out.println("call2 count : "+totalCnt2);
		
		System.out.println(fibo(N)); 
		for(int i=0; i<=N;++i) {
			System.out.println("fibo("+i+") : "+call1[i]);
		}
		System.out.println("call1 count : "+totalCnt1);
		
	}

}
