package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1068_트리 {

	static class Node {
		int number;
		List<Node> child = new ArrayList<>();

		Node(int number) {
			this.number = number;
		}

		void insert(int number) {
			child.add(new Node(number));
		}
	}

	static int res;
	static Node[] nodeArray;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		// step1. number가 자기 자신이고 left,right가 null인 nodeArray 생성
		nodeArray = new Node[N];
		for (int i = 0; i < N; i++) {
			nodeArray[i] = new Node(i);
		}

		// step2. 입력받은 숫자의 자식으로 삽입 & 숫자의 부모 정보 기억 & root 기억
		int[] parents = new int[N];
		int root = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			parents[i] = number;
			if (number != -1) {
				nodeArray[number].insert(i);
			} else {
				root = i;
			}
		}

		// step3. 노드 삭제
		int deleteNumber = Integer.parseInt(br.readLine());
		int deleteParent = parents[deleteNumber];
		if (deleteParent == -1) { // root 노드를 지우는 상황
			nodeArray[deleteNumber].child.clear();
			System.out.println(0);
			return;
		} else {
			for (int i = 0; i < nodeArray[deleteParent].child.size(); i++) {
				if(nodeArray[deleteParent].child.get(i).number == deleteNumber) {
					nodeArray[deleteParent].child.remove(i);
					break;
				}
			}
		}

		// step4. 리프노드 찾기
		res = 0;
		if(nodeArray[root].child.size() == 0) {	// 루트노드가 단말노드인 상황
			System.out.println(1);
			return;
		}else {
			for (int i = 0; i < nodeArray[root].child.size(); i++) {
				findLeef(nodeArray[root].child.get(i).number);
			}
		}
		System.out.println(res);

	}

	private static void findLeef(int number) {
		if(nodeArray[number].child.size() == 0) {
			res++;
			return;
		}
		
		for (int i = 0; i < nodeArray[number].child.size(); i++) {
			findLeef(nodeArray[number].child.get(i).number);
		}
	}

}
