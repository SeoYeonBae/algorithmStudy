package d2;

import java.io.*;
import java.util.*;

public class Solution_1983_조교의성적매기기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			double K = Double.parseDouble(st.nextToken());
			
			PriorityQueue<double[]> pq = new PriorityQueue<double[]>(new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return (int) (o2[1] - o1[1]);
				}
			});
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				double middleExam = Double.parseDouble(st.nextToken()) * 0.35;
				double finalExam = Double.parseDouble(st.nextToken()) * 0.45;
				double hw = Double.parseDouble(st.nextToken()) * 0.2;
				
				double score = middleExam + finalExam + hw;
				
				pq.add(new double[] {i, score});
			}
			
//			Collections.sort(pq, new Comparator<int[]>() {
//				@Override
//				public int compare(int[] o1, int[] o2) {
//					return o2[1] - o1[1];
//				}
//			});
			
			int limit = N / 10;
			int grade = 10;
			boolean isStop = false;
			for (int i = 0; i < N / limit; i++) {
				for (int j = 0; j < limit; j++) {
					double[] cur = pq.poll();
					if(cur[0] == K) {
						isStop = true;
						break;
					}
				}
				if(isStop)
					break;
				else
					grade--;
			}
			
			switch (grade) {
			case 10:
				sb.append("A+").append("\n");
				break;
			case 9:
				sb.append("A0").append("\n");
				break;
			case 8:
				sb.append("A-").append("\n");
				break;
			case 7:
				sb.append("B+").append("\n");
				break;
			case 6:
				sb.append("B0").append("\n");
				break;
			case 5:
				sb.append("B-").append("\n");
				break;
			case 4:
				sb.append("C+").append("\n");
				break;
			case 3:
				sb.append("C0").append("\n");
				break;
			case 2:
				sb.append("C-").append("\n");
				break;
			case 1:
				sb.append("D0").append("\n");
				break;
			}
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
