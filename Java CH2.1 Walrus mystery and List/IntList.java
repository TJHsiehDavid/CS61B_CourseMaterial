
public class IntList {
	public int value;
	public IntList next;



	public IntList(int value, IntList next) {
		this.value = value;
		this.next = next;
	}


	/**
	 * List recursion to calculate the size of the nodes in the List
	 * */
	public int size() {
		if(next == null)
			return 1;
		else 
			return 1 + this.next.size();
	}

	/**
	 * Non-recursion method to calculate the size of the nodes in the List
	 * */
	public int iterative_size() {
		IntList node = this;
		int size = 0;
		
		while(node != null) {
			size += 1;
			node = node.next;
		}
		return size;
	}

	/**
	 * To get n-th value from the List through recursion.
	 * */
	public int getRecursion(int th) {
		if(th == 0)
			return this.value;
		else
			return this.next.getRecursion(th - 1);
	}

	/**
	 * To get n-th value from the List by using iterative.
	 * */
	public int getIterative(int th) {
		IntList node = this;

		for(int i = 0; i < th; i++)
			node = node.next;

		return node.value;
	}
	/**
	 * 1.Returns an IntList identical to L, but with all values incremented by x.
	 * 2.Values in L cannot change!
	 * Flow:
	 * 1.Since we have to copy value by sequence, so using array to store the origin
	 *   value in order to assign value to new list easily.
	 * 2.Storing the array value by reverse the value index to assign to new List.
	*/
	public static IntList incrList(IntList L, int x) {
		IntList Q = null;
		int size = L.size();
		int[] originValue = new int[size];

		for(int i = 0; i < size; i++) {
			originValue[i] = L.value;
			L = L.next;
		}

		for(int j = 0; j < size; j++) {
			Q = new IntList(originValue[size-1-j] + 5, Q);
		}

		return Q;
	}

	/**
	 * 1.Returns an IntList identical to L, but with all values incremented by x.
	 * 2.Not allowed to use ‘new’ (to save memory).
	 * Flow:
	 * 1.Using the new list Q's address to point to the original list and increase the value
	 * 2.This list Q will also increase the original list L's value since Q is point to 
	 *   the L memory, so they both point to the same memory.
	 * */
	public static IntList dincrList(IntList L, int x) {
		IntList Q = L;
		int size = Q.size();

		for(int i = 0; i < size; i++) {
			Q.value += x;
			Q = Q.next;
		}
		return Q;
	}

	public static void main(String[] args) {
		IntList node = new IntList(5, null);
		node = new IntList(10, node);
		node = new IntList(15, node);
		node = new IntList(20, node);

		IntList incrNode = incrList(node, 5);
		IntList dincrNode = dincrList(node, 7);

		System.out.println(node.size());
		System.out.println(node.iterative_size());
		System.out.println(node.getIterative(0));
		System.out.println(node.getRecursion(0));

		System.out.println(incrNode.getIterative(0));
		System.out.println(incrNode.getRecursion(0));
	}
}