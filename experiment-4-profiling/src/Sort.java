import java.util.Random;

public class Sort {
    //    using bubble sort (a non-optimal sorting algorithm)
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, the array is already sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        Random rand = new Random();

        // Populate array with random integers
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100000);
        }
        System.out.println("Unsorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        bubbleSort(array);

        System.out.println("Sorted array using Bubble Sort:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}