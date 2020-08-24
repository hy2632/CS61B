import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println(Arrays.toString(sort(a)));
    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return bucketSort(arr, 5);
    }

    static int[] bucketSort(int[] arr, int bucketSize) {
        if (arr.length == 0)
            return arr;

        int maxValue = arr[0];
        int minValue = arr[0];

        for (int value : arr) {
            maxValue = value > maxValue ? value : maxValue;
            minValue = value < minValue ? value : minValue;
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        for (int value : arr) {
            int bucketIndex = (int) Math.floor((value - minValue) / bucketSize);
            buckets[bucketIndex] = arrayAppend(buckets[bucketIndex], value);
        }

        int sortedIndex = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (buckets[i].length == 0) {
                continue;
            }

            int[] bucket = buckets[i];
            bucket = InsertSort(bucket);

            for (int j = 0; j < bucket.length; j++) {
                arr[sortedIndex++] = bucket[j];
            }
        }
        return arr;
    }

    static int[] InsertSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int[] arrayAppend(int[] arr, int a) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = a;
        return arr;
    }
}