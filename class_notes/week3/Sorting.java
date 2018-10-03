// Sorting.java


public class Sorting {


    public static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }


    // pre: 0 <= n <= data.length
    // post: data[0 ... n-1] is sorted in ascending order
    public static void bubbleSort(int[] data, int n) {

        for (int nS = 0; nS < n; nS++) { // nS = numSorted
            for (int i = 0; i < n-nS; i++) {
                if (data[i-1] > data[i]) {
                    swap(data, i-1, i);
                }
            }
        }



    }

    public static void selectionSort(int[] data, int n){
        for (int nUS = n; nUS > 0; nUS--) {
            //among unsorted numbers, find index of largest
            for (int i = 1; i < nUS; i++) {
                if (data[i] > data[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(data, maxIndex, nUS -1);

        }
    }




}
