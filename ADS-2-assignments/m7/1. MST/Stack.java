/******************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt
 *
 *  A generic stack, implemented using a singly-linked list.
 *  Each stack element is of type Item.
 *
 *  This version uses a static nested class Node (to save 8 bytes per
 *  Node), whereas the version in the textbook uses a non-static nested
 *  class (for simplicity).
 *  
 *  % more tobe.txt 
 *  to be or not to - be - - that - - - is
 *
 *  % java Stack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *  The {@code Stack} class represents a last-in-first-out (LIFO) stack of generic items.
 *  It supports the usual <em>push</em> and <em>pop</em> operations, along with methods
 *  for peeking at the top item, testing if the stack is empty, and iterating through
 *  the items in LIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a static nested class for
 *  linked-list nodes. See {@link LinkedStack} for the version from the
 *  textbook that uses a non-static nested class.
 *  See {@link ResizingArrayStack} for a version that uses a resizing array.
 *  The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation,
 *  see <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <Item> the generic type of an item in this stack
 */
public class Stack<Item> implements Iterable<Item> {
    /**
     * variable.
     */
    private Node<Item> first;     // top of stack
    /**
     * variable.
     */
    private int n;                // size of the stack
    /**
     * variable.
     */
    // helper linked list class
    private static class Node<Item> {
    /**
     * variable.
     */
        private Item item;
        /**
         * variable.
         */
        private Node<Item> next;
        /**
         * variable.
         */
    }

    /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        n = 0;
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
        return n;
    }
   /**
     * Add the item to the stack.
     * The Time complexity is O(1)
     * @param item value
     */
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
   /**
     * @return value
     * The Time complexity is O(1)
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }
   /**
     * @return value
     * The Time complexity is O(1)
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
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
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
       

   /**
     * @return value
     * The Time complexity is O(N)
     */
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }
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
              * The Time complexity is O(1)
              */
        public void remove() {
            throw new UnsupportedOperationException();
        }
            /**
             * @return value
             * The Time complexity is O(1)
             */
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


    /**
     * Unit tests the {@code Stack} data type.
     *
     * @param args the command-line arguments
     */
   /* public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }*/
}

