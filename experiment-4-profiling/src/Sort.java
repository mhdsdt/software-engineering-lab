import java.util.Random;

public class Sort {
    //    using merge sort, the most optimal sorting algorithm
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        // Merge the temporary arrays back into the original array
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        Random rand = new Random();

        // Populate array with random integers
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100000);
        }

        // Print unsorted array (optional, comment out if too large)
        System.out.println("Unsorted array:");
        for (int i = 0; i < Math.min(array.length, 20); i++) { // Print only first 20 elements for brevity
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Sort the array using Merge Sort
        System.out.println("Sorting array using Merge Sort...");
        long startTime = System.currentTimeMillis();
        mergeSort(array, 0, array.length - 1);
        long endTime = System.currentTimeMillis();

        // Print sorted array (optional, comment out if too large)
        System.out.println("Sorted array:");
        for (int i = 0; i < Math.min(array.length, 20); i++) { // Print only first 20 elements for brevity
            System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.println("Merge Sort took: " + (endTime - startTime) + " milliseconds");
    }
}