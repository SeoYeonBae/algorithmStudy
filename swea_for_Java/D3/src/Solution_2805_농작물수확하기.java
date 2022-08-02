import java.io.*;

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		int res;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			res = 0;
			int N = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Character.getNumericValue(s.charAt(j));
				}
			}
			
			for(int i = 0; i <= N / 2; i++)
				for(int j = N/2 - i; j <= N/2 + i ;j++)
					res += map[i][j];
			
			for(int i = N/2; i > 0; i--)
				for(int j = N - N/2 -i; j < N/2 + i; j++)
					res += map[N - i][j];
					

			
			sb.setLength(0);
			sb.append("#").append(tc).append(" ").append(res);
			System.out.println(sb);
		}
	}

}
