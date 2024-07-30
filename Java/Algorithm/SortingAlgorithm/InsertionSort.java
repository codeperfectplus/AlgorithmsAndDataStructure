public class InsertionSort {

    /*
     * Insertion Sort
     * 
     * Insertion sort is a simple sorting algorithm that builds the final sorted
     * array one item at a time. It repeatedly takes the next element from the
     * unsorted part and inserts it into its correct position in the sorted part.
     */

    // Function to perform Insertion Sort
    void insertionSort(int arr[], int n) {
        // Iterate through the array
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key, to one position
            // ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // A utility function to print the array
    static void printArray(int arr[], int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        System.out.println("Unsorted array: ");
        printArray(arr, n);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr, n);

        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
