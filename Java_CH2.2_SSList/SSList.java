/**
 * date 2021/12/19
 * @author Daivd Hsieh
 * */

public class SSList{

	private static class IntList{
		private int value;
		private IntList next;

		public IntList(int v, IntList n) {
			this.value = v;
			this.next = n;
		}
	}
	/** A cleaner, though less obvious solution, is to make it so that all SLLists are the "same", 
	  * even if they are empty. We can do this by creating a special node that is always there, 
	  * which we will call a sentinel node. The sentinel node will hold a value, which we won't care about.
	  * */
	private IntList sentinal;
	private int size;

	public SSList() {
		sentinal = new IntList(77, null);
		size = 0;
	}

	public void addFirst(int x) {
		sentinal.next = new IntList(x, sentinal.next);
		size += 1;
	}

	public int getFirst() {
		return sentinal.next.value;
	}

	/** In this function, we using iterative to add node in the last of the list. 
	  * Although, used recursion also work well. */
	public void addLast(int x) {
		size += 1;
		IntList tmp = sentinal;
		
		while(tmp.next != null){
			tmp = tmp.next;
		}
		tmp.next = new IntList(x, null);
	}

	/** Using recursion to calculate the size of the list. */
	private static int sizeRecursion(IntList p) {
		if(p.next == null)
			return 1;
		else
			return 1 + sizeRecursion(p.next);
	}
	public int size() {
		return sizeRecursion(sentinal.next);
	}

	/** Method of "Square" does this non-mutatively with recursion by creating new IntLists. 
	 * 
	 * List will be 20-->10-->5, then:
	 * Terminate reason = L == null,
	 * since it will return the L list.
	 * 
	 * 1.It will run into else and do recursion three times in this case.
	 * 2.Each time will save the next pointer to next then iterativly go through the list. 
	 * 3.When meet the terminate reason it will return L which is the first node.
	 * 4.Since recursion, the code remain below recursion will now execute from the last layer begin.
	 * 5.Thus, the value will change in each layer 5*5----> 10*10----> 20*20, 
	 * 	 that is this function go down to the end and backward from end to start point.
	 * 6.Finally, return new list M. 
	 * 
	 * (Using this link to post the code to be more specific:
	 *  https://cscircles.cemc.uwaterloo.ca//java_visualize/#mode=display
	 *  */
	private static IntList squareRecursion(IntList L) {
		if(L == null)
			return L;
		else {
			IntList next = squareRecursion(L.next);
			IntList M = new IntList(L.value * L.value, next);
			return M;
		}
	}

	/** SquareMutative uses a recursive approach to change the instance variables of the input IntList L. */
	private static IntList squareRecurMutative(IntList L) {
		if(L == null) 
			return L;
		else {
			squareRecurMutative(L.next);
			L.value = L.value * L.value;
			return L;
		}
	}


	/** Method of "Square" does this non-mutatively with iteration by creating new IntLists. 
	  * 1.First line is init M point to the same object of L.
	  * 2.Second line is making M to an object and assign first square value to it.
	  * 3.Third line is the T is used to condition of while loop and the first value is assigned,
	  *   so T is start at the second value of L.
	  * 4.Forth line is the MOrigin is the final return list in this function, because MOrigin is 
	  *   point to the M object so that M is equal to MOrigin and M will move toward when square values,
	  *   so we need MOrigin to point to the first node and return.
	  * 5.While loop will square each value and assigned to the end of the list L.
	  * 6.First line of while loop is that we want to add square value in the end of the M list and 
	  *   M.next is null, so we new an object in that IntList.
	  * 7.Second and Third lines are go the the next node of M and T to continue no.6 method.
	  * */
	private static IntList squareIteration(IntList L) {
		IntList M = L;
		M = new IntList(L.value * L.value, null);
		IntList T = L.next;
		IntList MOrigin = M;

		while(T != null) {
			M.next = new IntList(T.value * T.value, null);
			M = M.next;
			T = T.next;
		}
		return MOrigin;
	}
	
	/** Method of "Square" does this non-mutatively with iteration to change the instance variables of the input IntList L. */
	private static IntList squareIterMutative(IntList L) {
		IntList M = L;
		while(M != null) {
			M.value *= M.value;
			M = M.next;
		}
		return L;
	}

	public IntList square() {
		//return squareRecursion(sentinal.next);
		return squareIteration(sentinal.next);
	}
	public IntList squareMutate() {
		//return squareRecurMutative(sentinal.next);
		return squareIterMutative(sentinal.next);
	}


	public static void main(String[] args) {
		SSList list = new SSList();
		list.addFirst(5);
		list.addFirst(10);
		list.addFirst(20);


		list.squareMutate();
		System.out.println(list.getFirst());


		/*
		IntList listSquare = list.square();
		System.out.println(listSquare.value);
		System.out.println(listSquare.next.value);
		System.out.println(listSquare.next.next.value);
		*/
		
	}

}