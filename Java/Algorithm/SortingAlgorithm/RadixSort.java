/*
     * Radix Sort
     * 
     * Radix sort is a non-comparative sorting algorithm that sorts numbers by
     * grouping individual digits. It sorts by distributing elements into buckets
     * according to their radix (base).
     */

public class RadixSort {
  
  // Function to get the maximum element from the array
  int getMax(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  // Function to perform Counting Sort based on the digit at a specific place value
  void countingSort(int arr[], int n, int exp) {
    int output[] = new int[n + 1]; // output array
    int count[] = new int[10]; // count array for storing occurrences of digits

    // Calculate count of occurrences of each digit (0 to 9)
    for (int i = 0; i < n; i++) {
      count[(arr[i] / exp) % 10]++;
    }

    // Calculate cumulative frequency (stable for equal digit elements)
    for (int i = 1; i < 10; i++) {
      count[i] += count[i - 1];
    }

    // Place elements in sorted order using the count array
    for (int i = n - 1; i >= 0; i--) {
      output[count[(arr[i] / exp) % 10] - 1] = arr[i];
      count[(arr[i] / exp) % 10]--;
    }

    // Copy the sorted elements back to the original array
    System.arraycopy(output, 0, arr, 0, n);
  }

  // The main function to implement Radix Sort
  void radixSort(int arr[], int n) {
    // Find the maximum element to determine number of passes
    int max = getMax(arr, n);

    // Do counting sort for every digit in base 10
    for (int exp = 1; max / exp > 0; exp *= 10) {
      countingSort(arr, n, exp);
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

    RadixSort radixSort = new RadixSort();
    radixSort.radixSort(arr, n);

    System.out.println("Sorted array: ");
    printArray(arr, n);
  }
}
