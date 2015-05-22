public class SingleLinkedDropOutStack<T> implements StackADT<T> {
	private Node<T> top;
	private int size;
	private int maxSize;
	
	private static final int DEFAUL_MAX_SIZE = 5;

	public SingleLinkedDropOutStack() {
		this(DEFAUL_MAX_SIZE);
	}

	public SingleLinkedDropOutStack(int maxSize) {
		this.top = null;
		this.maxSize = maxSize;
		size = 0;
	}

	private boolean isFull() {
		return maxSize == size;
	}

	private void popBottom() {
		Node<T> toRemove = getNodeAt(size() - 1);
		System.out.println("to remove " + toRemove.data);
		if (toRemove.equals(top)) {
			top = null;
		}
		toRemove = null;
		// System.out.println("top " + top.data);
		size--;
	}

	@Override
	public void push(T newEntry) {

		if (isFull()) {
			popBottom();
		}
		Node<T> toAdd = new Node<>(newEntry, top);
		top = toAdd;
		size++;
	}

	@Override
	public T pop() {
		if (isEmpty())
			return null;

		Node<T> popped = top;
		size--;
		if (size() == 0) {
			top = null;
		} else {
			top = top.next;
		}
		return popped.data;
	}

	@Override
	public T peek() {
		return isEmpty() ? null : top.data;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public void clear() {
		top = null;

	}

	@Override
	public int size() {
		return size;
	}

	private Node<T> getNodeAt(int index) {
		Node<T> temp = top;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		// System.out.println("Get node at index "+ temp.data);
		return temp;
	}

	private static class Node<T> {

		// all fields are visible to the outer class
		private T data; // entry in bag
		private Node<T> next; // link to next node

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

	} // end Node<T> class
}
