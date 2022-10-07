package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17471_게리맨더링 {

	static class Node {
		int vertax;
		Node next;

		public Node(int vertax, Node next) {
			super();
			this.vertax = vertax;
			this.next = next;
		}
	}

	static Node[] adjList;
	static int R, N, min;
	static int[] ingu, input;
	static ArrayList<Integer> A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		ingu = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ingu[i] = Integer.parseInt(st.nextToken());
		}

		adjList = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken());
				adjList[i] = new Node(to, adjList[i]);
				adjList[to] = new Node(i, adjList[to]);
			}
		}

		R = 1;
		min = Integer.MAX_VALUE;
		do {
			input = new int[R];
			comb(1, 0);
			R++;
		} while (R <= N / 2);
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
		br.close();
	}

	public static void comb(int start, int cnt) {
		if (cnt == R) {
			A = new ArrayList<>();
			B = new ArrayList<>();
			ArrayList<Integer> tmp = new ArrayList<>();
			for(int x : input)
			 tmp.add(x);
			for (int i = 1; i <= N; i++) {
				if (tmp.contains(i))
					A.add(i);
				else
					B.add(i);
			}

			if (isConnected(A) && isConnected(B)) {
				int res = subtraction(A, B);
				min = Math.min(min, res);
			}

			return;
		}

		for (int i = start; i <= N; i++) {
			input[cnt] = i;
			comb(i + 1, cnt + 1);
		}
	}

	private static int subtraction(ArrayList<Integer> A, ArrayList<Integer> B) {
		int sumA = 0;
		int sumB = 0;

		for (int i = 0; i < A.size(); i++) {
			sumA += ingu[A.get(i)];
		}
		for (int i = 0; i < B.size(); i++) {
			sumB += ingu[B.get(i)];
		}
		return Math.abs(sumA - sumB);
	}

	private static boolean isConnected(ArrayList<Integer> combList) {

		if (combList.size() == 1)
			return true;
		if(adjList[combList.get(0)] == null)
			return false;
		boolean[] visited = new boolean[N + 1];
		Queue<Node> q = new ArrayDeque<>();
		q.offer(adjList[combList.get(0)]);
		while (!q.isEmpty()) {
			for (Node cur = q.poll(); cur != null; cur = cur.next) {
				if (!combList.contains(cur.vertax))
					continue;
				if (visited[cur.vertax])
					continue;
				visited[cur.vertax] = true;
				q.offer(adjList[cur.vertax]);
				
			}
		}
		for (int i = 0; i < combList.size(); i++) {
			if (!visited[combList.get(i)])
				return false;
		}
		return true;
	}

}
