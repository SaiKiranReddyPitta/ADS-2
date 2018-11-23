/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;
/**graph implementation.**/
/**
 * @param <Item> value
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     *number of elements in bag.
     */
    private int n;
    /**
     *beginning of bag.
     */
    private Node first;
    /**
     *helper linked list class.
    */
    private class Node {
        /**
         *the variable to store.
         *item value
         */
        private Item item;
        /**
         *the element to reference the.
         *next item.
         */
        private Node next;
    }
    /**
      * Create an empty stack.
      */
    public Bag() {
        first = null;
        n = 0;
    }
   /**
     * Is the BAG empty?
     * @return value
     * The Time complexity is O(1)
     */
    public boolean isEmpty() {
        return first == null;
    }
   /**
     * Return the number of items in the bag.
     * The Time complexity is O(1)
     * @return value
     */
    public int size() {
        return n;
    }
   /**
     * Add the item to the bag.
     * The Time complexity is O(1)
     * @param item value
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
   /**
     * Return an iterator that iterates over the items in the bag.
     * The Time complexity is O(N)
     * @return value
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**
     * an iterator, doesn't implement remove().
     * since it's optional.
    */
    private class ListIterator implements Iterator<Item> {
        /**
         *the temporory node.
         */
        private Node current = first;
        /**
         * @brief [brief description]
         * @details [long description]
         * The Time complexity is O(1)
         * @return value
         */
        public boolean hasNext()  {
            return current != null;
        }
        /**
         * @brief [brief description]
         * @details [long description]
         * The Time complexity is O(1)
         */
        public void remove() {
            throw new UnsupportedOperationException();
         }
        /**
          *@brief [brief description]
          * @details [long description]
          * The Time complexity is O(1)
          * @return value
          */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}




