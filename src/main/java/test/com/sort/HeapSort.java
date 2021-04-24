package test.com.sort;

public class HeapSort {
    public static void sort(int arr[]) {
        int size = arr.length;

        for (int index = size / 2 - 1; index >= 0; index--) {
            heapify(arr, size, index);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(arr, 0, i);

            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int heapSize, int nodeIndex) {
        int largest = nodeIndex;
        int left = 2 * nodeIndex + 1;
        int right = 2 * nodeIndex + 2;

        if (left < heapSize && arr[left] > arr[largest])
            largest = left;

        if (right < heapSize && arr[right] > arr[largest])
            largest = right;

        if (largest != nodeIndex) {
            swap(arr, nodeIndex, largest);

            heapify(arr, heapSize,  largest);
        }
    }

    static void swap(int[] arr, int nodeIndex, int largest) {
        int swap = arr[nodeIndex];
        arr[nodeIndex] = arr[largest];
        arr[largest] = swap;
    }
}
