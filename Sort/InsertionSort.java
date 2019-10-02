public class InsertionSort {

    // Sorts array in O(n^2) time
    // O(1) space
    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i-1;
            int curr = arr[i];
            while(j >= 0 && arr[j] > curr) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = curr;
        }
    }
}