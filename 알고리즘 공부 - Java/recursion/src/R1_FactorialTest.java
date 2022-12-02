
public class R1_FactorialTest {

	// loop
	static int factorial1(int n) {
		int res = 1;
		
		for(int i = n; i >=  1; i--)
			res *= i;
		
		return res;
	}
	
	// n값을 기존 누적값에 곱하는 방식으로 계승을 구한다.
	static int res = 1;
	static void factorial2(int n) {
		if( n < 1)
			return;
		res *= n;
		factorial2(n - 1);;
	}
	
	// 자기 자신을 매개변수로 사용하는 방법
	static int factorial3(int n) {
		if( n == 1)
			return 1;
		else
			return n * factorial3(n - 1);
	}
	public static void main(String[] args) {
		System.out.println(factorial1(5));
		
		factorial2(5);
		System.out.println(res);
		
		System.out.println(factorial3(5));
	}
	
}
