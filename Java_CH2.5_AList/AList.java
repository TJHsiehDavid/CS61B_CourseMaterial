/** Array based list.
 *  @author David Hsieh
 */

public class AList {
    private int[] Alist;
    private int size;

    /** Creates an empty list. */
    public AList() {
        Alist = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    /* Dynamic added index of array when the size greater than 100, but the performance is
       not effective when the list is too large.
    */
    private void resizing(int capacity) {
        int[] temp = Alist;
        Alist = new int[capacity];
        System.arraycopy(temp, 0, Alist, 0 ,size );
    }
    public void addLast(int x) {
        if(size == Alist.length) {
            resizing(size * 2);  //this method work quite fast
        }

        Alist[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return Alist[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return Alist[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int last = getLast();
        Alist[size - 1] = 0;  //its unnecessary to do it since we used size to implement.
        size -= 1;
        return last;

        /* The other method which dynamic removed index of array but the performance is
           not effective when the list is too large.
         */
        /*
        size -= 1;
        int[] temp = Alist;
        System.arraycopy(temp, 0, Alist, 0, size - 1);
        return Alist[size - 1];
        */
    }
} 