package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {

	static boolean[] isSelected, isGyu;
	static int[] gyuYoung, inYoung, result;
	static int gyuSum, inSum, gyuWin;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	

		for (int tc = 1; tc <= T; tc++) {
			gyuYoung = new int[9];	// 규영
			inYoung = new int[9];	// 인영
			result = new int[9];
			isSelected = new boolean[19];
			isGyu = new boolean[19];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 9; i++) {
				gyuYoung[i] = Integer.parseInt(st.nextToken());
				isGyu[gyuYoung[i]] = true;
			}
			
			int idx = 0;
			for(int i = 1; i < 19; i++) {
				if(!isGyu[i])
					inYoung[idx++] = i;
			}
			
			gyuWin = 0;
			perm(0);
			
			sb.append("#").append(tc).append(" ").append(gyuWin).append(" ").append(362880 - gyuWin).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	static void perm(int cnt) {
		if(cnt == 9) {
			gyuSum = 0;
			inSum = 0;
			for(int i = 0; i < 9; i++) {
				if(gyuYoung[i] > result[i])
					gyuSum += gyuYoung[i] + result[i];
				else
					inSum += gyuYoung[i] + result[i];
			}
			if(gyuSum > inSum)
				gyuWin++;
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(isSelected[inYoung[i]])
				continue;
			result[cnt] = inYoung[i];
			isSelected[inYoung[i]] = true;
			perm(cnt + 1);
			isSelected[inYoung[i]] = false;
		}
	}

}
