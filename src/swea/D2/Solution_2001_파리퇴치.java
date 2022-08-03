package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        int N, M, max;
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            // 배열 초기화
            st = new StringTokenizer(in.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()) - 1;
            int[][] pSum = new int[N + 1][N + 1];
            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(in.readLine(), " ");
                for (int j = 1; j < N + 1; j++)
                    pSum[i][j] = pSum[i][j - 1] + Integer.parseInt(st.nextToken());
            }
 
            // 파리채 max 값 구하기
            max = 0;
            for (int i = 1; i <= N - M; i ++) {
                for (int j = 1; j <= N - M; j ++) {
                    max = Math.max(max, prefixSum(pSum, i, j, i + M, j + M));
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
 
    private static int prefixSum(int[][] pSum, int r1, int c1, int r2, int c2) {
        int res = 0;    
        for(int i = r1; i <= r2; i++)
            res += (pSum[i][c2] - pSum[i][c1 - 1]);
        return res;
    }
}