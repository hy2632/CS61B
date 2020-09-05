import java.util.Arrays;

public class kuaipai {

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int[] quickSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSortRecursion(arr, 0, arr.length - 1);
    }

    static int[] quickSortRecursion(int[] arr, int left, int right) {
        if (left < right) {
            int mid = partition(arr, left, right);
            quickSortRecursion(arr, left, mid - 1);
            quickSortRecursion(arr, mid + 1, right);
        }
        return arr;
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        int i = index;

        while (i <= right) {
            if (arr[i] <= arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
            i++;
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 76, 4, 32, 643, 2, 2, 3, 4, 5, 6 };
        System.out.println(Arrays.toString(quickSort(arr)));
    }

}
