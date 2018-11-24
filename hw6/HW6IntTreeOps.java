// CS 201 Homework 6
//
// Name: Benjamin Allan-Rahill
import java.util.*;

public class HW6IntTreeOps extends IntTreeOps {

    public static IntTree weightedTree(IntTree t) {
        // returns a copy of t where the values at each level are
        // multiplied by their level number (starting to count
        // at the root with 1 (NOT 0!)
        return weightedTreeRecursive(t,0);
    }

    // recursively computes the product of the level and the corresponding node
    public static IntTree weightedTreeRecursive(IntTree t, int level) {
        // used by weightedTree (above)
        int product;
        if (isEmpty(t)) {
            return empty();
        } else {
            level++;
            product = level * value(t);
            return node(product, weightedTreeRecursive(left(t), level),
                                 weightedTreeRecursive(right(t), level));
        }
    }

    public static boolean compareTrees(IntTree t1, IntTree t2){
      // two inputs that are each of type IntTree
      //returns a boolean value
      // return true if the two trees have the same number of nodes and the
      // same geometetric arrangement of the nodes
      if(isEmpty(t1) && isEmpty(t2))
        return true;
      else if (countNodes(t1) == countNodes(t2)) {
        return(compareTrees(left(t1), left(t2))
                && compareTrees(right(t1), right(t2)));
      } else return false;

    }

    public static boolean testFullTree(IntTree t){
      // retruns a boolean if the tree has the maximun number of nodes at each
      // level of the tree.
      // Except for the last level, no node should any empty children.

      // calls recursive func w/ height as input level.
      return testFullTreeRec(t, height(t));
    }

    // recursive helper function to test if the tree is full
    public static boolean testFullTreeRec(IntTree t, int level){
      //used by testFullTree (above)
      if (isEmpty(t)){
        return false;
      } else {
        if(isLeaf(t) && level == 1)
          return true;
        else {
          return (testFullTreeRec(left(t), level-1)
                  && testFullTreeRec(right(t), level-1));
        }
      }
    }

    public static boolean testOrderedTree(IntTree t){
      // returns true if, for every node of the tree,
      // all values stored in the entire left subtree of this node
      // are less or equal than the value stored in this node, and all values
      // stored in the right subtree are greater or equal than the value
      // stored in this root node.
      if(isEmpty(t) || isEmpty(left(t)) || isEmpty(right(t)) || isLeaf(t)){
        return true;
      } else{
        if(value(t)>=maxInt(left(t)) && value(t)<=minInt(right(t))) {
          return(testOrderedTree(left(t)) && testOrderedTree(right(t)));
        }else return false;
      }
    }

    // helper function used by testOrderedTree (above)
    public static int minInt(IntTree t) {
        // returns the minimum integer stored in the tree t
        if (isEmpty(t)) {
            return Integer.MAX_VALUE; // very large negative number
        } else {
            return Math.min(value(t), Math.min(minInt(left(t)),
                                               minInt(right(t))));
        }
    }

    public static void levelOrderWrite(IntTree t) {
    // prints out the contents of the tree t in level order
    Stack<IntTree> q = new Stack<IntTree>();
    q.push(t);
    while (!q.empty()) {
        IntTree node = q.pop();
        if (!isEmpty(node)) {
            System.out.print("  " + value(node));
            q.push(left(node));
            q.push(right(node));
        }
    }
    System.out.println();
}

    // Auxilary function to print the usage error message
    public static void printErr(){
      System.err.printf("%s\n%s\n\n%s\n%s%s\n%s%s\n%s",
                              "usage: java HW6IntTreeOps <t1>",
                              "or java HW6IntTreeOps <t1> <t2>",
                              "Tests certain operations on selected tree(s).",
                              "If one tree is specified, runs 'weightedTree(),'",
	                            " 'testFullTree()', and 'testOrderedTree()'. ",
                              "If two trees are specified,",
                              "runs 'compareTrees()'.",
                              "Valid tree numbers are 1 through 7.");
    }

    public static void main(String[] args){
      IntTree[] intTrees = new IntTree[8];
      //create the 7 arrays
      intTrees[0] = empty();
      intTrees[1] = node(3, empty(), empty());
      intTrees[2] = node(1,
                        leaf(2),
                        leaf(3));
      intTrees[3] = node(2,
                        leaf(1),
                        leaf(3));
      intTrees[4] = node(3,
                          node(1, empty(), leaf(2)),
                          node(4, empty(), leaf(5)));
      intTrees[5] = node(3,
                          leaf(1),
                          node(4, leaf(2), leaf(5)));
      intTrees[6] = node(1,
                        node(2, leaf(4), leaf(5)),
                        node(3, leaf(6), leaf(7)));
        intTrees[7] = node(5,
                          node(3,
                            node(1, empty(), leaf(2)),
                            leaf(4)),
                          node(8, node(7, leaf(6), empty()), leaf(9)));

        // check usage of args
        if (args.length != 2 && args.length !=1)
            printErr();
        // test if arguments are valid
        else if (Integer.parseInt(args[0])<1 || Integer.parseInt(args[0]) > 8) {
          System.err.println(
          "Arguments must be a valid int in the range 1-7"
          );
        }
        else {
          if (args.length == 1) {
            int arg1 = Integer.parseInt(args[0]);
            IntTree tree1 = intTrees[arg1 - 1];
            System.out.printf("Tree %d:\n", arg1);
            printTree(tree1);
            System.out.println("weightedTree:");
            printTree(weightedTree(tree1));
            System.out.println("testFullTree:" + testFullTree(tree1));
            System.out.println("testOrderedTree:" + testOrderedTree(tree1));
            levelOrderWrite(tree1);
          } else {
            int arg1 = Integer.parseInt(args[0]);
            int arg2 = Integer.parseInt(args[1]);
            IntTree tree1 = intTrees[arg1 - 1];
            IntTree tree2 = intTrees[arg2 - 1];

            // print trees
            System.out.printf("Tree %d:\n", arg1);
            printTree(tree1);
            System.out.printf("Tree %d:\n", arg2);
            printTree(tree2);

            //run compareTrees
            System.out.println("compareTrees: " + compareTrees(tree1, tree2));
            }

        }
      }

}
