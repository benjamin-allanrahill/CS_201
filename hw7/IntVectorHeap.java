// Complete heap of integers, implemented using Vector
//
// based on Bailey's "VectorHeap"
//
// CS 201 HW 7
//
// Name:

import java.util.*;     // uses Java's Vectors so that browser can find them

public class IntVectorHeap implements IntHeap {

    // the values in the heap, stored in level-order
    protected Vector<Integer> data;
    
    // index of "current" root, so that left() and right() can be implemented
    protected int root;

    // NOTE: add() and remove() will only work on the original heap
    // (i.e., if root==0).  Their behavior on the "subtrees" return by
    // left() or right() is unspecified.

    // constructor
    public IntVectorHeap() {
        data = new Vector<Integer>();
        root = 0;
    }

    // private constructor (used by left() and right())
    protected IntVectorHeap(Vector<Integer> d, int r) {
        data = d;
        root = r;
    }


    // returns true iff heap has no values
    public boolean isEmpty() {
        return root >= data.size();
    }

    // returns the minimum int at the root of the heap ( = Bailey's getFirst())
    // pre: !isEmpty()
    public int value() {
        return data.get(root);
    }

    /************************************************************/

    /* You'll have to write the add and remove methods.
     *
     * Start by pasting in the appropriate code from
     * Bailey's "VectorHeap.java"
     */
    
    // adds value to heap
    public void add(int value) {

        // FILL IN

    }

    // removes and returns the minimum int at the root of the heap
    // pre: !isEmpty()
    public int remove() {

        // FILL IN

        return -1; // just a stub
    }
    
    /************************************************************/

    // removes all elements from the heap
    public void clear() {
        data = new Vector<Integer>();
        root = 0;
    } 

    // returns left "subtree" of "current" root of heap
    public IntHeap left() {
        return new IntVectorHeap(data, left(root));
    }

    // returns right "subtree" of "current" root of heap
    public IntHeap right() {
        return new IntVectorHeap(data, right(root));
    }


    // code adapted from Bailey's "VectorHeap" below ---------------
    // (assumes root is at index 0!)
    
    // returns index of parent of value at i
    protected static int parent(int i) {
        return (i-1)/2;
    }

    // returns index of left child of value at i
    protected static int left(int i) {
        return 2*i+1;
    }

    // returns index of right child of value at i
    protected static int right(int i) {
        return 2*(i+1);
    }
    
}
