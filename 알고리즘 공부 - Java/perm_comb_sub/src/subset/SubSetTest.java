package subset;
import java.util.Scanner;

public class SubSetTest {

	static int N, totalCnt;
	static int[] input;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		totalCnt = 0;
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		subset(0);
		System.out.println("총 경우의 수 : " + totalCnt);
 	}
	
	private static void subset(int index) {	// cnt: 직전까지 고려한 원소 수
		
		if(index == N) { // 더이상 고려할 원소가 없다면 부분집합의 구성이 완성
			totalCnt++;
			for(int i = 0; i < N; i++) {
				System.out.print(isSelected[i]?input[i]:"x");
				System.out.print("\t");
			}
			System.out.println();
			return;
		}
		
		// 원소 선택
		isSelected[index] = true;
		subset(index + 1);
		// 원소 미선택
		isSelected[index] = false;
		subset(index + 1);
		
	}
}
