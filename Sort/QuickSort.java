import java.util.Random;

public class QuickSort {

    /* Last Element QuickSort */
/*------------------------------------------------------------------------------------*/
    // Sets last element as pivot element
    // O(n^2)
    // Best and Worst case n^2
    // O(1) space
    public static void lastElementPivot(int[] arr, int p, int r) {
        if(p < r) {
            int q = partition(arr, p, r);
            lastElementPivot(arr, p, q-1);
            lastElementPivot(arr, q+1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p - 1;
        for(int j = p; j < r; ++j) {
            if(arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }
/*------------------------------------------------------------------------------------*/


    /* Randomized Quick Sort */
/*------------------------------------------------------------------------------------*/
    // Implementation using a randomized pivot
    // O(n^2)
    // Best case nlogn time (good pivots), Worst case n^2 (bad pivots)
    // O(1) space
    public static void randomizedPivot(int[] arr, int p, int r) {
        if(p < r) {
            int q = randomPartition(arr, p, r);
            randomizedPivot(arr, p, q-1);
            randomizedPivot(arr, q+1, r);
        }
    }

    // Finds random index in subarray and swaps it with last element
    private static int randomPartition(int[] arr, int p, int r) {
        Random rand = new Random();
        int i = rand.nextInt((r-p)+1) + p;
        swap(arr, i, r);
        return partition(arr, p, r);
    }
/*------------------------------------------------------------------------------------*/

    // Helper methods
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}