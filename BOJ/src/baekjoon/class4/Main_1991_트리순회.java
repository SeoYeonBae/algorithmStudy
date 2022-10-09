package baekjoon.class4;

import java.io.*;
import java.util.*;

public class Main_1991_트리순회 {

	static int N;
	static char[][] adjMap;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		adjMap = new char[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			adjMap[i][0] = st.nextToken().charAt(0);
			adjMap[i][1] = st.nextToken().charAt(0);
			adjMap[i][2] = st.nextToken().charAt(0);
		}
		// 어레이 리스트는 collections.sort 배열은 arrays.sort
		Arrays.sort(adjMap, new Comparator<char[]>() {

			@Override
			public int compare(char[] o1, char[] o2) {
				return o1[0] - o2[0];
			}
		});

		inorder(0);
		sb.append("\n");
		preorder(0);
		sb.append("\n");
		postorder(0);
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void postorder(int idx) {
		char root = adjMap[idx][0];
		char left = adjMap[idx][1];
		char right = adjMap[idx][2];


		if (left != '.')
			postorder(left - 65);
		

		if (right != '.')
			postorder(right - 65);

		sb.append(root);
		return;
	}

	private static void preorder(int idx) {
		char root = adjMap[idx][0];
		char left = adjMap[idx][1];
		char right = adjMap[idx][2];


		if (left != '.')
			preorder(left - 65);
		
		sb.append(root);

		if (right != '.')
			preorder(right - 65);

		return;
	}

	private static void inorder(int idx) {
		char root = adjMap[idx][0];
		char left = adjMap[idx][1];
		char right = adjMap[idx][2];

		sb.append(root);

		if (left != '.')
			inorder(left - 65);
		
		if (right != '.')
			inorder(right - 65);

		return;
	}
}
