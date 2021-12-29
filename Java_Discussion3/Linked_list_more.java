public class Linked_list_more <GenericType> {

	private class IntNode {
		public GenericType item;
		public IntNode next;
		public IntNode(GenericType i, IntNode n) {
			this.item = i;
			this.next = n;
		}
	}

	/** Constructor of Linked_List_more. */
	public Linked_list_more(GenericType x) {
		first = new IntNode(x, null);
	}

	private IntNode first;

	public void addFirst(GenericType x) {
		first = new IntNode(x, first);
	}

	/** [Flow]:
	  * 1.First is null them added first or added node in the front of the list.
	  * 2.Added node in the middle of the list so connected the node to origin list. 
	  * 3.Go through all node. */
	public void insert(GenericType item, int position) {
		int count = 0;
		IntNode prev = first;
		IntNode current = first;
		IntNode insertNode = new IntNode(item, null);

		while(current != null) {
			if(position == 0) {
				addFirst(item);
				return;
			}
			else if(count == position) {
				insertNode.next = current;
				prev.next = insertNode;
			}
			else {
				prev = current;
			}
			current = current.next;
			count += 1;
		}

		if(position >= count) {
			prev.next = insertNode;
		}
	}

	/** [Flow]:
	  * Prev pointer is always save the previous node.
	  * Next pointer is the head of the list named node.
	  * 
	  * For example if there are 4 nodes in this list:
	  * 1.Each recursion will save the previous node in prev.
	  * 2.When the terminate condition happened, the recursion will backward to the begin of the function call.
	  * 3.The last layer is the node pointer will point to third node since the node.next.next is null, 
	  *   so jump into the terminate condition. 
	  * 4.Now node is point to third node and the tail node(= fourth node) need to point to the third node, 
	  *   thus node.next.next is equal to prev. 
	  * 5.The origin node list we will give the last node the null pointer which the origin list length now
	  *   is 3.
	  * 6.Finished the third layer(= last layer) then went to second layer do the same steps form 1-5.*/
	public IntNode reverseRecur(IntNode node) {
		if(node.next == null) {
			return node;
		}else {
			IntNode prev = node;
			IntNode next = reverseRecur(node.next);
			node.next.next = prev;
         	node.next = null;
         	return next;
		}
	}
	/** [Flow]:
	  * Curr pointer is always point to next.next place.
	  * Prev pointer is point to the previous node which the next node will connect to it.
	  * Cprev pointer is point to the next node of the prev pointer(=previous node).
	  * First pointer always point to the first node since the last step is to connect to null.
	  * 
	  * In the while loop:
	  * 1.cprev point to the second node.
	  * 2.prev point to the first node.
	  * 3.curr point will move to next node which is third node.
	  * 4.Reverse them which is the "cprev's" next will point to "prev's" node since cprev is always the location
	  *   after prev node.
	  * 5.prev pointer move to the place of cprev and cprev move to the place of curr pointer. 
	  * 6.Those steps 1-6 will iteratively go through when the list is null.*/
	public void reverseIter() {
		IntNode prev = first;
		IntNode curr = first.next;
		
		while(curr != null) {
			IntNode cprev = curr;
			curr = curr.next;
			cprev.next = prev;
			prev = cprev;
			cprev = curr;

		}
		first.next = null;
		first = prev;

	}
	public void reverse() {
		first = reverseRecur(first);
		//reverseIter();
	}



	public static void main(String[] args) {
		Linked_list_more<Integer> list = new Linked_list_more<Integer>(2);
		list.addFirst(6);
		list.addFirst(5);

		list.insert(55, 0);

		list.reverse();
		
		
		System.out.println(list.first.item);
		System.out.println(list.first.next.item);
		System.out.println(list.first.next.next.item);
		System.out.println(list.first.next.next.next.item);
		

	}
}