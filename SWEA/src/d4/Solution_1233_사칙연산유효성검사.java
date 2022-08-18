package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int result = 1; 								// 연산이 가능하면 1 불가능하면 0
			int N = Integer.parseInt(br.readLine()); 		// 정점의 총 수

			for (int i = 0; i < N; i++) { 					// 정점의 정보
				String[] node = br.readLine().split(" ");

				if (node.length == 4) { 					// 자식 노드가 있을 때
					if (!"+-*/".contains(node[1])) { 		// 정점 노드는 반드시 연산자를 가져야 함
						result = 0;
						for(int j = i + 1; j < N; j++)
							br.readLine();
						break;
					}
				} else { 									// 단말 노드일 때
					if ("+-*/".contains(node[1])) {			// 숫자만 가져야 함
						result = 0;
						for(int j = i + 1; j < N; j++)
							br.readLine();
						break;
					}
				}
			}
		
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		br.close();
		System.out.println(sb);
	}

}
