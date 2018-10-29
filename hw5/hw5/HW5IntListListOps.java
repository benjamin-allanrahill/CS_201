// CS 201 HW 5 Problem 2
// Name: Benjamin Allan-Rahill

public class HW5IntListListOps extends IntListListOps {

    // Tackle one at a time!!!   Test using
    // "java HW5IntListOpsTest"

    public static IntListList filterSorted (IntListList L) {
        // Returns a list of all of the lists of L that are sorted.
        // To use a method from HW5IntListOps.java, use the prefix
        // "HW5IntListOps."

        if (isEmpty(L)){
          return empty();
        } else {
          if (HW5IntListOps.isSorted(head(L))) {
            return prepend(head(L), filterSorted(tail(L)));
          } else return filterSorted(tail(L));
        }
    }

    public static IntListList mapPrepend (int i, IntListList L) {
        // Returns a new list that contains list elements in which i is
        // prepended to every corresponding element of the input list.
        // Note that this method uses both IntList and IntListList
        // methods. In the body, IntList methods must contain an explicit
        // "IntList." prefix, but no prefix is necessary for IntListList
        // methods.
        if (isEmpty(L)) {
          return empty();
        } else {
          return prepend(head(L).prepend(i, head(L)), mapPrepend(i, tail(L)));
        }
    }

    public static IntListList subsequences (IntList L) {
        // Given an integer list L, return a list of all the subsequences
        // of L.  Think carefully about the base case!  Note that this
        // method uses both IntList and IntListList methods. In the body,
        // IntList methods must contain an explicit "IntList." prefix, but
        // no prefix is necessary for IntListList methods.
        if(IntList.isEmpty(L)){
          int[] a1 = {};
          IntList L1 = IntList.arrayToIntList(a1);
          return IntListList.prepend(L1, IntListList.empty());
        } else {
          return append(subsequences(IntList.tail(L)),
                  mapPrepend(IntList.head(L), subsequences(IntList.tail(L))));
        }
    }


    // optional (extra credit):
    // please don't remove this method even if you don't tackle it so our test
    //code runs

    public static IntListList longest (IntListList L) {

        // Returns a list of all of the lists of L that have the longest length.
        // If L is empty, returns the empty list.
        // Think carefully about base cases here!

        return empty();  // just a placeholder
    }
}
