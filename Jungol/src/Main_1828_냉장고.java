import java.io.*;
import java.util.*;

public class Main_1828_냉장고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] chemical = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			chemical[i][0] = Integer.parseInt(st.nextToken());
			chemical[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(chemical, new Comparator<int[]>() { // 최고 기온 비교한 다음 최저 기온으로 오름차순 정렬 -> 최저 기온 따질 필요 x
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] != o2[1])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
					
			}
		});
		
		int max = chemical[0][1]; // 첫 번째 원소의 최고 기온을 맥스로 저장
		int res = 1; // 냉장고의 수
		for (int i = 1; i < N; i++) {	
			if(chemical[i][0] > max) {	// 다음 원소의 최저 기온이 맥스보다 크면 같은 냉장고 못 씀
				res++;
				max = chemical[i][1];
			}
		}
		
		System.out.println(res);
	}
	
}
