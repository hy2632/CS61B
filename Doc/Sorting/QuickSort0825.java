import java.util.*;
public class QuickSort0825 {
	public static void main(String[] args){
		int[] a = {1, 3, 2, 9, 5, 4, 6, 0, 28, 5, 5, 3, 2, 6};
		System.out.println(Arrays.toString(quickSort(a)));	
	}

	static int[] quickSort(int[] sourceArray){
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		return (quicksort(arr, 0, arr.length - 1));
	}

	static int[] quicksort(int[] arr, int left, int right){
		if (arr.length == 0)
			return arr;

		int partitionIndex = partition(arr, left, right);
		if (partitionIndex > left)
			quicksort(arr, left, partitionIndex - 1);
		if (partitionIndex < right)
			quicksort(arr, partitionIndex + 1, right);
		return arr;
	}
	

	static int partition(int[] arr, int left, int right){
		int pivot = left;
		int index = left + 1;
		for(int i = index; i <= right; i++){
			if (arr[i] < arr[pivot]){
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, index - 1, pivot);
		return index - 1;
	}

	static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}


}
