// Complete heap of integers, implemented using Vector
//
// based on Bailey's "VectorHeap"
//
// CS 201 HW 7
//
// Name: Benjamin Allan-Rahill

import java.util.*;     // uses Java's Vectors so that browser can find them

public class IntVectorHeap implements IntHeap {

    // the values in the heap, stored in level-order
    protected Vector<Integer> data;

    // index of "current" root, so that left() and right() can be implemented
    protected int root;

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

    // adds value to heap using percolateUp
    public void add(int value) {
        data.add(value);
        percolateUp(data.size()-1);
    }

    // removes and returns the minimum int at the root of the heap
    // pre: !isEmpty()
    public int remove() {

        int minVal = root;
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    //takes value that will be added and shifts it up by comparing it to the
    // parent value. This shifts the new leaf to its correct location
    protected void percolateUp(int leaf)
        // pre: 0 <= leaf < size
        // post: moves node at index leaf up to appropriate position
        {
        int parent = parent(leaf);
        int value = data.get(leaf);
        while (leaf > 0 && (value < data.get(parent))){
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     * Moves node downward, into appropriate position within subheap.
     * @param root Index of the root of the subheap.
     * @pre 0 <= root < size
     * @post moves node at index root down
     *   to appropriate position in subtree
     */
    protected void pushDownRoot(int root){
       int heapSize = data.size();
       int value = data.get(root);
       while (root < heapSize) {
           int childpos = left(root);
           if (childpos < heapSize)
           {
               if ((right(root) < heapSize) &&
                 ((data.get(childpos+1)).compareTo
                  (data.get(childpos)) < 0))
               {
                   childpos++;
               }
               // Assert: childpos indexes smaller of two children
               if ((data.get(childpos)).compareTo
                   (value) < 0)
               {
                   data.set(root,data.get(childpos));
                   root = childpos; // keep moving down
               } else { // found right location
                   data.set(root,value);
                   return;
               }
           } else { // at a leaf! insert and halt
               data.set(root,value);
               return;
           }
       }
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
