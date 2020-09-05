import java.util.Arrays;

public class guibing {
    

    // /**
    //  * 一种样例写法
    //  * @param arr
    //  * @param left
    //  * @param mid
    //  * @param right
    //  */
    // public static void merge(int[] arr, int left, int mid, int right){
    //     int[] temp = new int[arr.length];
    //     int p1 = left; int p2 = mid + 1; int sortedIndex = left;
    //     while(p1 <= mid && p2 <= right){
    //         if (arr[p1] <= arr[p2]){
    //             temp[sortedIndex++] = arr[p1++];
    //         } else {
    //             temp[sortedIndex++] = arr[p2++];
    //         }
    //     }
    //     while(p1 <= mid){
    //         temp[sortedIndex++] = arr[p1++];
    //     }
    //     while(p2 <= right){
    //         temp[sortedIndex++] = arr[p2++];
    //     }
        
    //     for(int i = left; i <= right; i++){
    //         arr[i] = temp[i];
    //     }
    // }

    // public static int[] mergeSort(int[] arr, int start, int end){
    //     if (start < end){
    //         int mid = (start + end) >> 1;
    //         mergeSort(arr, start, mid);
    //         mergeSort(arr, mid + 1, end);
    //         merge(arr, start, mid ,end);
    //     }
    //     return arr;
    // }


    static int[] mergeSort(int[] sourceArray){
        if (sourceArray.length <= 1) return sourceArray;
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int mid = arr.length >> 1;


        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        return merge(mergeSort(left), mergeSort(right));
    }
    
    // a1 & a2 are both sorted
    static int[] merge(int[] a1, int[] a2){
        int[] result = new int[a1.length + a2.length];
        int sortedIndex = 0;
        int i = 0, j = 0;

        while(i < a1.length && j < a2.length){
            if (a1[i] <= a2[j]){
                result[sortedIndex++] = a1[i++];
            } else {
                result[sortedIndex++] = a2[j++];
            }
        }
        while(i < a1.length){
            result[sortedIndex++] = a1[i++];
        }
        while(j < a2.length){
            result[sortedIndex++] = a2[j++];
        }
        return result;
    }


    public static void main(String[] args){
        int[] arr = {3,76,4,32,643,2,2,3,4,5,6};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

}
