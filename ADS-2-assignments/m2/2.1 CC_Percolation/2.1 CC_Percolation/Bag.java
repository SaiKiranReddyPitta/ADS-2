/**.
 * { importing Iterator }
 */
import java.util.Iterator;
/**.
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**.
     * number of elements in bag.
     */
    private int n;
    /**.
     * beginning of bag.
     */
    private Node first;
    /**.
     * Class for Node.
     */
    private class Node {
        /**.
         * Item
         */
        private Item item;
        /**.
         * next of type Node.
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
      * The Complexity is O(1).
      * @return bool.
      */
    public boolean isEmpty() {
        return first == null;
    }
    /**
      * Return the number of items in the bag.
      * The Complexity is O(1).
      * @return size.
      */
    public int size() {
        return n;
    }
    /**
      * Add the item to the bag.
      * The Complexity is O(1).
      * @param item item.
      */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    /**
      * Return an iterator that
      * iterates over the items in the bag.
      * The Complexity is O(N).
      * @return iterator.
      */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**.
     * Class for list iterator.
     * An iterator, doesn't implement remove()
     * since it's optional
     */
    private class ListIterator implements Iterator<Item> {
        /**
         * current node points to first.
         */
        private Node current = first;
        /**
         * returns true/false.
         * The Complexity is O(1).
         * @return bool value[description]
         */
        public boolean hasNext() {
            return current != null;
        }
        /**
         * removes.
         * The Complexity is O(1).
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
        /**
         * next item.
         * The Complexity is O(1).
         * @return description
         */
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
