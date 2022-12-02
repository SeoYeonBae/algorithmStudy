
public class SsafyStack<E> implements IStack<E> {

	private Node<E> top; // 더미노드 아님!!

	@Override
	public void push(E data) { // 첫 노드 삽입 알고리즘
		top = new Node<E>(data, top);

	}

	@Override
	public E pop() {
		if (isEmpty()) {
			System.out.println("공백 스택이어서 작업이 불가능합니다.");
			return null;
		}
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			System.out.println("공백 스택이어서 작업이 불가능합니다.");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public int size() {
		int cnt = 0;
		for (Node temp = top; temp != null; temp = temp.link) {
			++cnt;
			
		}
		return cnt;
	}

}
