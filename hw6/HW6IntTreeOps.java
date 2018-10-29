// CS 201 Homework 6
//
// Name:

public class HW6IntTreeOps extends IntTreeOps {

    public static IntTree weightedTree(IntTree t) {
        // returns a copy of t where the values at each level are
        // multiplied by their level number (starting to count
        // at the root with 1 (NOT 0!)


        // FILL IN

        return empty();
    }



    // ADD THE REMAINING METHODS HERE

    // INCLUDING A MAIN METHOD TO TEST IT ALL

    public static void main(String[] args){
      IntTree[] intTrees = new IntTree[7];

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

      for (IntTree tree : intTrees){
        System.out.println("Printing a tree");
        printTree(tree);
      }
    }
}
