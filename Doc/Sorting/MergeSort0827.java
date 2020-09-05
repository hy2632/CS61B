import java.util.Arrays;

public class MergeSort0827 {

    static int[] mergeSort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if(arr.length < 2)
            return arr; // 没有递归基就无法退出！！

        int midpoint = arr.length >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, midpoint);
        int[] right = Arrays.copyOfRange(arr, midpoint, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int sortedIndex = 0;
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[sortedIndex++] = left[i];
                i++;
            } else {
                result[sortedIndex++] = right[j];
                j++;
            }
        }
        while (i < left.length)
            result[sortedIndex++] = left[i++];
        while (j < right.length)
            result[sortedIndex++] = right[j++];
        return result;
    }

    public static void main(String[] args){
        int[] a = {7,4,6,2,9,10,28,4};
        System.out.println(Arrays.toString(mergeSort(a)));
    }

}