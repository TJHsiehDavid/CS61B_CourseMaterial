public class IntList {
	private int first;
	private IntList rest;

	public IntList(int k, IntList n) {
		this.first = k;
		this.rest = n;
	}


	public static void printList(IntList l) {
		while(l.rest != null) {
			System.out.print(l.first + " --> ");
			l = l.rest;
		}
		System.out.println(l.first + " --> null.");
	}

	/**
	* IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10); 
	* IntList B = IntList.list(9, 8, 7, 6, 5, 4, 3, 2, 1); 
	* Fill in the method skippify such that the result of calling skippify on A and B are as below:
	* -After calling A.skippify(), A: (1, 3, 6, 10)
	* -After calling B.skippify(), B: (9, 7, 4)
	*/
	public void skippify() {
		IntList p = this; 
		int n = 1;

		while (p != null) {
			IntList next = p.rest;

			for(int i = 0; i < n; i++) {
				if(next == null) {
					break;
				}
				next = next.rest;			
			}
			n += 1;
			p.rest = next;
			p = p.rest;
			
		}
	}


	/** 
	* Given a sorted linked list of items -remove duplicates. 
	* For example given 1 -> 2 -> 2 -> 2 -> 3, 
	* Mutate it to become 1 -> 2 -> 3 (destructively) 
	*/
	public static void removeDuplicates(IntList p) {
		if (p == null) {
			return;
		}
		IntList current = p.rest;
		IntList previous = p;

		while(current != null) {
			if(current.first == previous.first) {
				previous.rest = current.rest;
			}else {
				previous = current;
			}
			current = current.rest;
		}
	}



	public static void main(String[] args) {
		IntList list1 = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		list1.skippify();
		printList(list1);

		IntList list2 = IntList.list(1, 2, 2, 2, 3, 3, 5, 7, 7, 10);
		removeDuplicates(list2);
		printList(list2);
	}




	/**
	 * [Helper Function]
     * Returns a new IntList containing the ints in ARGS. You are not
     * expected to read or understand this method.
     */
    public static IntList list(Integer... args) {
        IntList result, p;

        if (args.length > 0) {
            result = new IntList(args[0], null);
        } else {
            return null;
        }

        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.rest) {
            p.rest = new IntList(args[k], null);
        }
        return result;
    }

    /**
     * Returns true iff X is an IntList containing the same sequence of ints
     * as THIS. Cannot handle IntLists with cycles. You are not expected to
     * read or understand this method.
     */
    public boolean equals(Object x) {
        if (!(x instanceof IntList)) {
            return false;
        }
        IntList L = (IntList) x;
        IntList p;

        for (p = this; p != null && L != null; p = p.rest, L = L.rest) {
            if (p.first != L.first) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }

}