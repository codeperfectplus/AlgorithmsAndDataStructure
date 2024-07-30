import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    /*
     * Bucket Sort
     * 
     * Bucket sort is a distribution sort algorithm that sorts elements by first
     * dividing the range of the input into a number of buckets. Each bucket is then
     * sorted individually, either using a different sorting algorithm or by
     * recursively applying the bucket sorting algorithm.
     */

    // Function to perform Bucket Sort
    public void bucketSort(int arr[], int n) {
        int maxVal = getMaxValue(arr, n);
        int numBuckets = maxVal / 10 + 1;

        // Create buckets
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = arr[i] / 10;
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < numBuckets; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate the sorted buckets
        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    // Utility function to get the maximum value in the array
    int getMaxValue(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // A utility function to print the array
    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        System.out.println("Unsorted array: ");
        printArray(arr, n);

        BucketSort bucketSort = new BucketSort();
        bucketSort.bucketSort(arr, n);

        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
