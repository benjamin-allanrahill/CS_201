// Skew heap of integers, implemented using IntTree
//
// based on Bailey's "SkewHeap"
//
// CS 201 HW 7
//
// Name: Benjamin Allan-Rahill

public class IntSkewHeap implements IntHeap {

    protected IntTree t;        // the heap

    // constructor
    public IntSkewHeap() {
        t = empty();
    }

    // private constructor (used by left() and right())
    protected IntSkewHeap(IntTree tree) {
        t = tree;
    }


    // returns true iff heap has no values
    public boolean isEmpty() {
        return isEmpty(t);
    }

    // returns the minimum int at the root of the heap ( = Bailey's getFirst())
    // pre: !isEmpty()
    public int value() {
        return t.value();
    }

    // removes all elements from the heap
    public void clear() {
        t = empty();
    }

    // returns left "sub-heap" of heap
    // pre: !isEmpty()
    public IntHeap left() {
        return new IntSkewHeap(t.left());
    }

    // returns right "sub-heap" of heap
    // pre: !isEmpty()
    public IntHeap right() {
        return new IntSkewHeap(t.right());
    }

    // removes value at the top of the tree and then merges the left and right
    public int remove(){
        int result = t.value();
        t = merge(t.left(),t.right());
        return result;
    }

    /**
     * Add a value to the priority queue.
     *
     * @pre value is non-null comparable
     * @post value is added to priority queue
     *
     * @param value The value to be added.
     */
    public void add(int value){
        IntTree smallTree =
            new IntTree(value,empty(),empty());
        t = merge(smallTree,t);
    }

        /**
     * Merge this heap with another
     *
     * @param otherHeap Heap to be merged with this heap, otherHeap
     * is destroyed by this operation;
     * @post the two heaps are merged and otherHeap is destroyed
     */
     protected static IntTree merge(IntTree left, IntTree right){
       if (isEmpty(left)) return right;
       if (isEmpty(right)) return left;
       Integer leftVal = left.value();
       Integer rightVal = right.value();
       IntTree result;
       if (rightVal < leftVal)
       {
           result = merge(right,left);
       } else {
           result = left;
           // assertion left side is smaller than right
           // left is new t
           if (isEmpty(result.left()))
           {
               result.setLeft(right);
           } else {
               IntTree temp = result.right();
               result.setRight(result.left());
               result.setLeft(merge(temp,right));
           }
       }
       return result;
   }




    // Local abbreviations for static IntList methods

    public static IntTree empty() {
        return IntTree.empty();
    }

    public static boolean isEmpty(IntTree T) {
        return IntTree.isEmpty(T);
    }

    public static IntTree leaf(int val) {
        return IntTree.leaf(val);
    }

    public static int value(IntTree T) {
        return IntTree.value(T);
    }

    public static IntTree left(IntTree T) {
        return IntTree.left(T);
    }

    public static IntTree right(IntTree T) {
        return IntTree.right(T);
    }

    public static void setValue(IntTree T, int newValue) {
        IntTree.setValue(T, newValue);
    }

    public static void setLeft(IntTree T, IntTree newLeft) {
        IntTree.setLeft(T, newLeft);
    }

    public static void setRight(IntTree T, IntTree newRight) {
        IntTree.setRight(T, newRight);
    }
}
