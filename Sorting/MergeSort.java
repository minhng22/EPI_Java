public class MergeSort {
    static void mergeSort(int[] arr){
        if (arr.length == 1){
            return;
        }
        int mid = arr.length/ 2;
        int[] l = new int[mid];
        int[] r = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l);
        mergeSort(r);

        merge(arr, l, r);
    }

    static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            }
            else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
    /* Prints the array */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver method to test above
    public static void main(String args[])
    {
        int arr[] = {64, 34, 25, 12, 22, 11, 11, 90};
        mergeSort(arr);
        System.out.println("Sorted array");
        printArray(arr);
    }
}
