import java.util.*;


public class QuickSortDemo {
    public static int[] QuickSort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return QuickSortRecursion(arr, 0, arr.length-1);
    }

    public static int[] QuickSortRecursion(int[] arr, int left, int right){
        if (left < right){
            int partitionIndex = partition(arr, left, right);
            QuickSortRecursion(arr, left, partitionIndex-1); // left! not 0
            QuickSortRecursion(arr, partitionIndex+1, right);
        }
        return arr;
    }


    public static int partition(int[] arr, int left, int right){
        int pivot = left;
        int index = pivot + 1;
        for(int i = index; i <= right; i++){ // i<=right!!!
            if (arr[i] < arr[pivot]){
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index-1);
        return index-1;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args){
        int[] a = {8,8,9,61,5,31,5,312,2,4,8,185};
        System.out.print(Arrays.toString(QuickSort(a)));
    }


}