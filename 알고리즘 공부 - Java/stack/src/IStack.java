
public interface IStack<T> {
	void push(T t);
	T pop();
	T peek();
	boolean isEmpty();
	int size();
}
