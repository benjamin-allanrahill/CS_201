// CS 201 HW 4 problem 2
// An implementation of the Vector class that provides 3 sorting mechanisms.
// Benjamin Allan-Rahill

import structure5.Vector;   // if this creates problems, use the following line instead:
//import java.util.Vector;
import java.util.Comparator;

public class MyVector<T> extends Vector<T> {

    // Constructs a new empty MyVector
    public MyVector() {
        super(); // call constructor of super class
    }

    // Constructs a new MyVector with initial capacity n
    public MyVector(int n) {
        super(n); // call constructor of super class
    }

    public void insertionSort(Comparator<T> c) {
    	// sort array of integers using insertion sort algorithm
    	// pre: 0 <= n <= data.length
    	// post: values in data[0..n-1] in ascending order
    	for (int numSorted = 1; numSorted < size(); numSorted++) {
    		int index; // need to declare here since it's used outside of loop
    		// get the first unsorted value ...
    		T val = get(numSorted);
    		// ... and insert it among the sorted
    		for (index = numSorted; index > 0; index--) {
    			if (c.compare(val, get(index-1)) < 0) {
    				set(index, get(index -1));
    			} else {
    				break; // quits out of smallest enclosing loop
    			}
    		}
    		// reinsert value
    		set(index, val);
    	}
    }

	public void quickSort(Comparator<T> c) {
		// sort array of integers using quick sort algorithm
	    // pre: 0 <= n <= data.length
	    // post: values in data[0..n-1] in ascending order
	   
	        quickSortRecursive(0, size()-1, c);
	    }           
	        
    public void quickSortRecursive(int low, int high, Comparator<T> c) {
    // recursive quick sort of data[low..high]
    // pre: 0 <= low <= high < data.length
    // post: data[low..high] in ascending order
    
        int pivot;
        if (low < high) {
            pivot = partition(low, high, c);
            quickSortRecursive(low, pivot-1, c);
            quickSortRecursive(pivot+1, high, c);
        }
    }
		
    public int partition(int left, int right, Comparator<T> c)
    // partition using data[left] as pivot element
    // pre: 0 <= left <= right < data.size()
    // post: data[left] is pivot and placed in the correct location
    //       all integers located to the left of pivot are <= pivot
    //       all integers located to the right of pivot are >= pivot
    //       location of pivot is returned
    {
        while (true) {
            // move right "pointer" toward left
            while ((left < right) && (c.compare(get(left), get(right)) < 0))
                right--;
            if (left < right) {
                swap(left++, right);
            } else {
                return left;
            }
            // move left "pointer" toward right
            while ((left < right) && (c.compare(get(left), get(right)) < 0))
                left++;
            if (left < right) {
                swap(left, right--);
            } else {
                return right;
            }
        }
    }

    public void selectionSort(Comparator<T> c) {
    	// sort array of integers using selection sort algorithm
	    // pre: 0 <= n <= data.length
	    // post: values in data[0..n-1] in ascending order
	    {
	        for (int numUnsorted = size(); numUnsorted > 0; numUnsorted--) {
	            // determine location of maximum value in array
	            int maxIndex = 0;
	            for (int index = 1; index < numUnsorted; index++) {
	                if (c.compare(get(maxIndex), get(index)) < 0) {
	                    maxIndex = index;
	                }
	            }
	            swap(maxIndex, numUnsorted-1);
	        }
	    }
    }


	// function to swap two elements, referenced in the code above
    public void swap(int i, int j)
    // pre: 0 <= i,j < data.length
    // post: data[i] and data[j] are exchanged
    {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }
  
}
