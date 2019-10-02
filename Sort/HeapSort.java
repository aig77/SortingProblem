public class HeapSort {

    private static void heapify(int arr[], int n, int i) {
        int max = i; // root is max
        int l = 2*i + 1; // left
        int r = 2*i + 2; // right

        // if left child > root
        if(l < n && arr[l] > arr[max])
            max = l;

        // if right child is > root
        if(r < n && arr[r] > arr[max])
            max = r;
        
        // if root isnt max
        if(max != i) {
            Sort.swap(arr, i, max);
            heapify(arr, n, max);
        }
    }

    public static void sort(int[] arr, int n) {
        // Build heap
        for(int i = n/2 - 1; i >= 0; --i)
            heapify(arr, n, i);
        
        for(int i = n-1; i >= 0; --i) {
            Sort.swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

}