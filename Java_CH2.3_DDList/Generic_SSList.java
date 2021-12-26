/**
 * date 2021/12/25
 * @author Daivd Hsieh
 * */

public class Generic_SSList<TYPE> {

	private class StuffList{
		private TYPE value;
		private StuffList next;

		public StuffList(TYPE v, StuffList n) {
			this.value = v;
			this.next = n;
		}
	}

	/** A cleaner, though less obvious solution, is to make it so that all SLLists are the "same", 
	  * even if they are empty. We can do this by creating a special node that is always there, 
	  * which we will call a sentinel node. The sentinel node will hold a value, which we won't care about.
	  * */
	private StuffList first;
	private int size;

	public Generic_SSList(TYPE x) {
		first = new StuffList(x, null);
		size = 1;
	}

	public void addFirst(TYPE x) {
		first = new StuffList(x, first);
		size += 1;
	}

	public TYPE getFirst() {
		return first.value;
	}

	/** In this function, we using iterative to add node in the last of the list. 
	  * Although, used recursion also work well. */
	public void addLast(TYPE x) {
		StuffList tmp = first;
		
		while(tmp.next != null){
			tmp = tmp.next;
		}
		tmp.next = new StuffList(x, null);
		size += 1;
	}

	
	public int size() {
		return size;
	}


	public static void main(String[] args) {
		Generic_SSList<Integer> list = new Generic_SSList<>(5);
		list.addFirst(10);
		list.addFirst(15);
		list.addFirst(20);

		System.out.println(list.size);


		Generic_SSList<String> strlist = new Generic_SSList<>("I ");
		strlist.addFirst("am ");
		strlist.addFirst("fine.");

		System.out.println(strlist.size);


	}

}