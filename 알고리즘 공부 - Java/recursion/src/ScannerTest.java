import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("우리는 몇 기?");
		int no = sc.nextInt();
		System.out.println("==> 우리는 SSAFY " + no + "기!!!");
	
		System.out.println("우리를 대표하는 한 마디?");
//		String msg = sc.next(); // 칠전팔기 o 칠전 팔기 x
		sc.nextLine(); // int no에 입력을 받을 때 개행 문자를 받기 위함
		String msg = sc.nextLine(); // 칠전팔기 o 칠전 팔기 o
		System.out.println("==> 우리를 태표하는 한마디는 " + msg);
		// 공백에 따라 next() 와 nextLine() 구분해서 사용
		// method의 종류에 따라 구분자의 잔재를 항상 신경 써야 함
		
	}
}
