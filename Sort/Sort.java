import java.lang.*;

public class Sort {

    static void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(i > 0 && i % 10 == 0)
                System.out.println();
            System.out.print(i == arr.length - 1 ? arr[i] + "\n"
                : arr[i] + ", ");
        }
        System.out.print("--------------------------------------\n");
    }

    static void printArrs(int[][] arrs) {
        int start = 65;
        for(int i = 0; i < arrs.length; i++) {
            if(65+i > 90 && 65+i < 97)
                start += 6;
            System.out.print("\n" + (char)(start+i) + ":\n"
                + "--------------------------------------\n");
            printArr(arrs[i]);
        }
    }

    static int[][] buildArrs(int n, int m) {
        
        //shouldnt have more arrays than the alphabet*2
        if(m > 52) m = 52;

        int[][] arrs = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int num = (int)(Math.random() * (n-1) + 1);
                arrs[i][j] = num;
            }
        }

        return arrs;
    }

    static double averageOfArr(double[] arr, int m) {
        if(m==0) m=1;
        double sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum/m;
    }

    public static void main(String[] args) {

        // Number of elements that need sorting
        int n = 10000;
        // Number of trials
        int m = 10;

        int arrs[][] = buildArrs(n,m);

        double t1;
        double t2;
        double[] times = new double[5];
        int[] testArr = new int[n];
        
        /* Insertion Sort Trials */
/*-----------------------------------------------------------------------*/
        System.out.println("\nInsertion Sort:\n"
            + "--------------------------------------");

        for(int i = 0; i < times.length; i++) {
            testArr = arrs[i];
            t1 = System.nanoTime()/1000;
            InsertionSort.sort(testArr);
            t2 = System.nanoTime()/1000;
            printArr(arrs[i]);
            times[i] = t2-t1;
        }

        double IStime = averageOfArr(times, m);
        System.out.println("Average Time: " + IStime + "\n"
            + "--------------------------------------\n");
/*-----------------------------------------------------------------------*/


        /* Merge Sort Trials */
/*-----------------------------------------------------------------------*/
        System.out.println("\nMerge Sort:\n"
            + "--------------------------------------");

        for(int i = 0; i < times.length; i++) {
            testArr = arrs[i];
            t1 = System.nanoTime()/1000;
            MergeSort.sort(testArr, 0, testArr.length-1);
            t2 = System.nanoTime()/1000;
            printArr(arrs[i]);
            times[i] = t2-t1;
        }

        double MStime = averageOfArr(times, m);
        System.out.println("Average Time: " + MStime + "\n"
            + "--------------------------------------\n");


        /* Quick Sort Trials */
/*-----------------------------------------------------------------------*/
        // Last Element as Pivot
        System.out.println("\nQuick Sort (last element as pivot):\n"
            + "--------------------------------------");
        
        for(int i = 0; i < times.length; i++) {
            testArr = arrs[i];
            t1 = System.nanoTime()/1000;
            QuickSort.lastElementPivot(testArr, 0, testArr.length-1);
            t2 = System.nanoTime()/1000;
            printArr(arrs[i]);
            times[i] = t2-t1;
        }

        double QStime1 = averageOfArr(times, m);
        System.out.println("Average Time: " + QStime1 + "\n"
            + "--------------------------------------\n");
/*-----------------------------------------------------------------------*/
        // Randomized pivot
        System.out.println("\nQuick Sort (randomized pivot):\n"
            + "--------------------------------------");
        
        for(int i = 0; i < times.length; i++) {
            testArr = arrs[i];
            t1 = System.nanoTime()/1000;
            QuickSort.randomizedPivot(testArr, 0, testArr.length-1);
            t2 = System.nanoTime()/1000;
            printArr(arrs[i]);
            times[i] = t2-t1;
        }

        double QStime2 = averageOfArr(times, m);
        System.out.println("Average Time: " + QStime2 + "\n"
            + "--------------------------------------\n");
/*-----------------------------------------------------------------------*/

        System.out.println("\nOriginal Arrays: "
        + "--------------------------------------\n");
        printArrs(arrs);

        System.out.println("\nTaking a look at the sorting problem:\n" 
            + "How long does it take to sort n integers\n"
            + "using different sorting methods?\n"
            + "Keep in mind, the proven fastest average sorting\n"
            + "time is nlogn.\n"
            + "Here m = " + m +  " arrays of n = " + n + " integers, A, B, C,\n" 
            + "etc, are created using random integers from 1 to n and each\n"
            + "are sorted, timed, and their average sorting times\n"
            + "(micro seconds) are compared to the other methods.\n"
            + "The original and sorted arrays can be viewed above.\n");

        System.out.println("Average times:\n"
            + "--------------------------------------\n"
            + "Insertion Sort: " + IStime + "\n"
            + "Merge Sort: " + MStime + "\n"
            + "Quick Sort (last element pivot): " + QStime1 + "\n"
            + "Quick Sort (randomized pivot): " + QStime2 + "\n");
    }

}