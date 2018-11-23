/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;
/**graphimplementation.**/
/**
 * @param <Item> value
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * variable.
     */
    private int size;
    /**
     * variable.
     */
    private Node first;
    /**graphimplementation.**/
    private class Node {
    /**
     * variable.
     */
        private Item item;
    /**
     * variable.
     */
        private Node next;
    }
   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        size = 0;
    }

   /**
     * The Time complexity is O(1)
     * Is the BAG empty?
     * @return value
     */
    public boolean isEmpty() {
        return first == null;
    }

   /**
     * The Time complexity is O(1)
     * Return the number of items in the bag.
     * @return value
     */
    public int size() {
        return size;
    }

   /**
     * The Time complexity is O(1)
     * Add the item to the bag.
     * @param item value
     */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }


   /**
     * The Time complexity is O(N)
     * Return an iterator that iterates over the items in the bag.
     * @return value
     */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    /**graphimplementation.**/
    private class ListIterator implements Iterator<Item> {
    /**
     * variable.
     */
        private Node current = first;
        /**
         * The Time complexity is O(1)
         * @brief [brief description]
         * @details [long description]
         * @return value
         */
        public boolean hasNext()  {
            return current != null;
        }
        /**
         * The Time complexity is O(1)
         * @brief [brief description]
         * @details [long description]
         */
        public void remove()      {
            throw new UnsupportedOperationException();
         }
         /**
          * The ime complexity is O(1)
          * @brief [brief description]
          * @details [long description]
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
