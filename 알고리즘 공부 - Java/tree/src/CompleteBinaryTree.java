import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree {

	private char[] nodes;
	private int lastIndex;	// 마지막 노드의 인덱스
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new char[size + 1]; // 1인덱스부터 사용
	}

	public boolean add(char e) {	// 완전이진트리에 맞게 추가
		if(lastIndex == SIZE) {
			return false;
		}
		nodes[++lastIndex] = e;
		return true;
	}
	
	public void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트노드 인덱스 부터

		while(!queue.isEmpty()) {	// 방문 대상이 있을 때까지 반복
			int current = queue.poll();	// 방문 차레인 대상 정보 꺼내기
			System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
			
			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if(current*2 <= lastIndex) queue.offer(current * 2);	// 왼쪽 자식
			if(current * 2  + 1 <= lastIndex) queue.offer(current * 2 + 1); // 오른쪽 자식
		}
		System.out.println();
	}

	public void bfs2() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1); // 루트노드 인덱스 부터
		
		while(!queue.isEmpty()) {	// 방문 대상이 있을 때까지 반복
			int size = queue.size();	// 큐 크기 확인 = 동일 너비 대상의 개수
			
			while(--size >= 0) {	// 반복 진입 전 구한 큐 크기 만큼만 반복
				int current = queue.poll();	// 방문 차레인 대상 정보 꺼내기
				System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
				
				// 현재 방문노드의 자식노드들을 대기열에 넣기
				if(current*2 <= lastIndex) queue.offer(current * 2);	// 왼쪽 자식
				if(current * 2  + 1 <= lastIndex) queue.offer(current * 2 + 1); // 오른쪽 자식
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void dfs() {
		Stack<Integer> queue = new Stack<Integer>();
		queue.push(1); // 루트노드 인덱스 부터

		while(!queue.isEmpty()) {	// 방문 대상이 있을 때까지 반복
			int current = queue.pop();	// 방문 차레인 대상 정보 꺼내기
			System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
			
			// 현재 방문노드의 자식노드들을 대기열에 넣기
			if(current*2 <= lastIndex) queue.push(current * 2);	// 왼쪽 자식
			if(current * 2  + 1 <= lastIndex) queue.push(current * 2 + 1); // 오른쪽 자식
		}
		System.out.println();
	}
	
	public void dfsByPreOrder(int current) {
		System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리

		if(current*2 <= lastIndex) dfsByPreOrder(current * 2);
		if(current * 2  + 1 <= lastIndex) dfsByPreOrder(current * 2 + 1);
	}

	public void dfsByInOrder(int current) {
		if(current > lastIndex) return;
		
		dfsByInOrder(current * 2);
		System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
		dfsByInOrder(current * 2 + 1);
	}

	public void dfsByPostOrder(int current) {
		if(current > lastIndex) return;
		
		dfsByPostOrder(current * 2);
		dfsByPostOrder(current * 2 + 1);
		System.out.print(nodes[current] + " "); // 방문해서 해야할 일 처리
	}
}
