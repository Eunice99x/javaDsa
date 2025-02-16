package merge_sort;  // Declares the package name

import java.util.Arrays;  // Imports Arrays utility class for easy array printing

public class Merge {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2, 7};  // Sample array to be sorted
        mergeSort(arr);  // Calls mergeSort function to sort the array

        System.out.println(Arrays.toString(arr));  // Prints the sorted array
    }

    private static void mergeSort(int[] arr){
        int length = arr.length;
        if (length <= 1) return;  // Base case: If the array has 1 or 0 elements, it's already sorted

        int middle = length / 2;  // Find the middle index

        // Create two subarrays: left half and right half
        int[] leftArr = new int[middle];
        int[] rightArr = new int[length - middle];

        int i = 0;
        int j = 0;

        // Split the original array into left and right subarrays
        for (; i < length; i++) {
            if (i < middle) {
                leftArr[i] = arr[i];  // Fill left array
            } else {
                rightArr[j] = arr[i];  // Fill right array
                j++;
            }
        }

        // Recursively sort both halves
        mergeSort(leftArr);
        mergeSort(rightArr);

        // Merge the sorted halves back into the original array
        merge(leftArr, rightArr, arr);
    }

    private static void merge(int[] leftArr, int[] rightArr, int[] arr){
        int leftSize = arr.length / 2;  // Size of left subarray
        int rightSize = arr.length - leftSize;  // Size of right subarray
        int i = 0, l = 0, r = 0;  // Pointers for merged array, left array, and right array

        // Merge left and right subarrays into the original array in sorted order
        while (l < leftSize && r < rightSize) {
            if (leftArr[l] < rightArr[r]) {  
                arr[i] = leftArr[l];  // Pick the smaller element from left subarray
                l++;
            } else {
                arr[i] = rightArr[r];  // Pick the smaller element from right subarray
                r++;
            }
            i++;
        }

        // Copy any remaining elements from the left subarray
        while (l < leftSize) {
            arr[i] = leftArr[l];
            i++;
            l++;
        }

        // Copy any remaining elements from the right subarray
        while (r < rightSize) {
            arr[i] = rightArr[r];
            i++;
            r++;
        }
    }
}
