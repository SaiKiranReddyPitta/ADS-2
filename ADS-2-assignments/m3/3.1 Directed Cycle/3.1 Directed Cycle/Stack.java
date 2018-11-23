import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * List of .
 *
 * @param      <Item>  The item
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * size of the stack.
     */
    private int no;
    /**
     * top of stack.
     */
    private Node first;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * item object.
         */
        private Item item;
        /**
         * node next.
         */
        private Node next;
    }

   /**
     * Create an empty stack.
     */
    public Stack() {
        first = null;
        no = 0;
    }
   /**
     * Is the stack empty?
     * The Time complexity is O(1)
     * @return value
     */
    public boolean isEmpty() {
        return first == null;
    }
   /**
     * Return the number of items in the stack.
     * The Time complexity is O(1)
     * @return value
     */
    public int size() {
        return no;
    }
   /**
     * Add the item to the stack.
     * The Time complexity is O(1)
     * @param item value
     */
    public void push(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        no++;
    }
   /**
     * @return value
     * The Time complexity is O(1)
     */
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        no--;
        return item;                   // return the saved item
    }
   /**
     * @return value
     * The Time complexity is O(1)
     */
    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return first.item;
    }
   /**
     * Return string representation.
     * The Time complexity is O(N)
     * @return value
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }
   /**
     * @return value
     * The Time complexity is O(N)
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    /**
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * { var_description }.
         */
        private Node current = first;
        /**
         * @return value
         * The Time complexity is O(1)
         */
        public boolean hasNext() {
            return current != null;
        }
            /**
             * @brief [brief description]
             * @details [long description]
             * Time complexity is O(1)
             */
        public void remove() {
            throw new UnsupportedOperationException();
        }
            /**
             * @return value
             * Time complexity is O(1)
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





