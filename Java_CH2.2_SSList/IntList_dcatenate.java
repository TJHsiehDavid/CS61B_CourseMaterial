
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
	 * 
	 * [Flow]:
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
	 * 
	 * [Flow]:
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


	/**
     * Returns a list consisting of the elements of A followed by the
     * *  elements of B.  May modify items of A. Don't use 'new'.
     * 
     * [Flow]:
     * This function "dcatenateRecur" have same function as the function "dcatenate".
     * [Addition infomation]:
     * "Main":IntList A = "dcatenate":IntList A that is they are two pointer point to the same address.
     * Thus, we can do "A = A.next" in the "dcatenate" then it will not change "main":A point to the first node 
     * since they are different pointer. By that, if we finished function "dcatenate" and return to main process,
     * then A list's content was modified but the A is still point to the first node whatever the function "dcatenate"
     * used "A = A.next" to run the function.
     * 
     */
    public static IntList dcatenate(IntList A, IntList B) {
        //TODO:  fill in method
        IntList Q = A;
        while(A.next != null) {
            A = A.next;
        }
        A.next = B;

        return Q;
    }
    public static IntList dcatenateRecur(IntList A, IntList B) {
        //TODO:  fill in method
        if(A.next == null) {
        	A.next = B;
        	return A;
        }
        dcatenateRecur(A.next, B);

        return A;
    }

    /**
     * Returns a list consisting of the elements of A followed by the
     * * elements of B.  May NOT modify items of A.  Use 'new'.
     * 
     * [Flow]:
     * 1.First line is creating an object as the first node in Q list which we will implemented this new list.
     * 2.Second line is using P as the iterater to run though each node in A list.
     * 3.Third line is using returnList as the return list which because returnList is point to the Q list which we 
     * 	 created to implemented.
     * 4.While loop for assign the A list to Q.
     * 5.Last second line is to connect B list to the end of the Q end point.
     */
    public static IntList catenate(IntList A, IntList B) {
        //TODO:  fill in method
        IntList Q = new IntList(A.value, null);
        IntList P = A.next;
        IntList returnList = Q;

        while(P != null) {
        	Q.next = new IntList(P.value, P.next);
        	P = P.next;
        	Q = Q.next;
        }

        Q.next = B;
        
        return returnList;
    }
    public static IntList catenateRecur(IntList A, IntList B) {
        //TODO:  fill in method
        if(A == null) 
        	return B;
      	else {
      		IntList next = catenateRecur(A.next, B);
      		IntList returnList = new IntList(A.value, next);
      		return returnList;

      	}
        
    }



	public static void main(String[] args) {
		IntList A = new IntList(4, null);
		A = new IntList(3, A);
		A = new IntList(2, A);
		A = new IntList(1, A);

		IntList B = new IntList(7, null);
		B = new IntList(7, B);
		B = new IntList(6, B);
		B = new IntList(5, B);

		IntList Q = dcatenate(A, B);


		
	}
}