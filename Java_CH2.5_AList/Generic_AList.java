/** Array based list.
 *  @author David Hsieh
 */

public class Generic_AList<Item> {
    private Item[] Alist;
    private int size;

    /** Creates an empty list. */
    public Generic_AList() {
        Alist = (Item[]) new Object[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    /* Dynamic added index of array when the size greater than 100, but the performance is
       not effective when the list is too large.
    */
    private void resizing(int capacity) {
        Item[] temp = Alist;
        Alist = (Item[]) new Object[capacity];
        System.arraycopy(temp, 0, Alist, 0, size);
    }

    public void addLast(Item x) {
        if(size == Alist.length) {
            resizing(size * 2);  //this method work quite fast
        }

        Alist[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return Alist[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return Alist[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        Item last = getLast();
        Alist[size - 1] = null;  //since it be object so can assign null.
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