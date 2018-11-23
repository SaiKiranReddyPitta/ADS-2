/*************************************************************************
 *  Compilation:  javac Bag.java
 *  Execution:    java Bag < input.txt
 *
 *  A generic bag or multiset, implemented using a linked list.
 *
 *************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>Bag</tt> class represents a bag (or multiset) of 
 *  generic items. It supports insertion and iterating over the 
 *  items in arbitrary order.
 *  <p>
 *  The <em>add</em>, <em>isEmpty</em>, and <em>size</em>  operation 
 *  take constant time. Iteration takes time proportional to the number of items.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class Bag<Item> implements Iterable<Item> {
    /**.
     * { var_description }
     */
    private int N;         // number of elements in bag
    /**.
     * { var_description }
     */
    private Node first;    // beginning of bag
    // helper linked list class
    /**.
     * Class for node.
     */
    private class Node {
    /**.
     * Class for node.
     */
        private Item item;
        /**.
         * Class for node.
         */
        private Node next;
        /**.
         * Class for node.
         */
    }
   /**
     * Create an empty stack.
     */
    public Bag() {
        first = null;
        N = 0;
    }
/**.
 * Determines if empty.
 * @return     True if empty, False otherwise.
 * The Time complexity is O(1)
 */
    public boolean isEmpty() {
        return first == null;
    }
/**.
 * { function_description }
 * @return     { description_of_the_return_value }
 * The Time complexity is O(1)
 */
    public int size() {
        return N;
    }
/**.
 * { function_description }
 * @param      item  The item
 * The Time complexity is O(1)
 */
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
/**.
 * { function_description }
 * @return     { description_of_the_return_value }
 * The Time complexity is O(N)
 */
    public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        /**.
         * { var_description }
         */
        private Node current = first;
        /**.
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         * The Time complexity is O(1)
         */
        public boolean hasNext()  { return current != null;                     }
        /**.
         * { function_description }
         * The Time complexity is O(1)
         */
        public void remove()      { throw new UnsupportedOperationException();  }
        /**.
         * { function_description }
         * @return     { description_of_the_return_value }
         * The Time complexity is O(1)
         */
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

}
