package quick_sort;  // Declares the package name

import java.util.Arrays;  // Imports Arrays utility class for easy array printing

public class Quick {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7};  // Sample array to be sorted

        quickSort(arr, 0, arr.length - 1);  // Calls quickSort function with start and end indices

        System.out.println(Arrays.toString(arr));  // Prints the sorted array
    }

    // Recursive QuickSort function
    private static void quickSort(int[] array, int start, int end) {
        if (end <= start) return;  // Base case: If there's one or no element, it's already sorted

        int pivot = partition(array, start, end);  // Partition the array and get the pivot index

        quickSort(array, start, pivot - 1);  // Recursively sort the left subarray
        quickSort(array, pivot + 1, end);  // Recursively sort the right subarray
    }

    // Partition function to rearrange elements around the pivot
    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];  // Choosing the last element as the pivot
        int i = start - 1;  // Pointer for elements smaller than pivot

        // Loop to place elements smaller than pivot to the left
        for (int j = start; j <= end; j++) {
            if (array[j] < pivot) {  // If the current element is smaller than pivot
                i++;  // Move the pointer forward
                // Swap array[i] and array[j] to place the smaller element in the correct position
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap the pivot with the first element that is greater than it
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;  // Return the index where the pivot is placed
    }
}
