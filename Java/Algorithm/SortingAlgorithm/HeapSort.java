import java.util.Arrays;

public class HeapSort {

    /*
     * Heap Sort
     * 
     * Heap sort is a comparison-based sorting algorithm that builds a binary heap
     * from the input array and repeatedly extracts the maximum element from the
     * heap and rebuilds the heap after each extraction.
     */

    // Function to perform Heap Sort
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[].
    // n is size of heap
    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // A utility function to print the array
    static void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        System.out.println("Unsorted array: ");
        printArray(arr);

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);

        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
