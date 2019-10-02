public class MergeSort {

    // Guranteed O(nlogn) sorting time (Best/Worst case)
    // O(n) space (adds two arrays of size n/2)
    public static void twoWaySort(int[] arr, int p, int r) {
        if(p < r) {
            int q = (p+r)/2;
            twoWaySort(arr, p, q);
            twoWaySort(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }

    public static void fourWaySort(int[] arr, int p, int r) {
        if(p < r) {
            int q2 = (p+r)/2;
            int q1 = (p+q2)/2;
            int q3 = (r+q2)/2;
            fourWaySort(arr, p, q1);
            fourWaySort(arr, q1+1, q2);
            fourWaySort(arr, q2+1, q3);
            fourWaySort(arr, q3+1, r);
            merge(arr, p, q1, q2);
            merge(arr, q2+1, q3, r);
            merge(arr, p, q2, r);
        }
    }

    private static void merge(int[] arr, int p, int q, int r) {
        // Find sizes of subarrays to be merged
        int n1 = q - p + 1;
        int n2 = r - q;

        // Create temp arrays representing left and right subarrays being
        // merged
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into temp arrays
        for(int i = 0; i < n1; ++i)
            L[i] = arr[p + i];
        for(int j = 0; j < n2; ++j)
            R[j] = arr[q + 1 + j];

        /* Merge the temp arrays */

        // Initial indeces of subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray array
        int k = p;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
    }
}