// CS 201 HW 5 Problem 1
// Name: Benjamin Allan-Rahill

public class HW5IntListOps extends IntListOps {

    // Tackle one at a time!!!   Test using
    // "java HW5IntListOpsTest"

	// recursive function to find if and IntList is sorted.
	// Input: IL
	// Return: True/False
    public static boolean isSorted(IntList L) {

    	if(isEmpty(L) || isEmpty(tail(L))) {
    		return true;
    	} else {
    		if(head(L)<= head(tail(L))) {
    			return isSorted(tail(L));
    		}else return false;

    	}
    }

    // Returns a new list that contains all of the elements of L in the same
    // order except for occurrences of i, which are removed.
    public static IntList remove(int i, IntList L) {
    	if(isEmpty(L)) {
    		return empty();
    	}else {
    		if(head(L) == i) {
    			return remove(i, tail(L));
    		} else return prepend(head(L), remove(i, tail(L)));
    	}

    }

    // Returns a new list that contains only one occurrence of each integer
    // that occurs in L. The order of the integers in the resulting list does not matter.
    public static IntList removeDuplicates(IntList L) {
    	if(isEmpty(L)) {
    		return empty();
    	} else return prepend(head(L), removeDuplicates(remove(head(L), L)));

    }


}
