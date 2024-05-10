public class SelectionSort {

    /*
     * Selection Sort
     * 
     * Selection sort is a simple sorting algorithm that repeatedly selects the
     * minimum element from the unsorted portion of the array and places it at the
     * beginning.
     */

    // Function to perform Selection Sort
    void selectionSort(int arr[], int n) {
        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(arr, n);

        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
