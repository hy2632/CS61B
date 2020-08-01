import java.util.Arrays;

public class MergeSort_myversion {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 5, 1, 3, 9, 99, 34, 2, 13 };
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] source_arr) {
        if (source_arr.length < 2)
            return source_arr;
        int[] arr = Arrays.copyOf(source_arr, source_arr.length);

        int mid = arr.length >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        /**
         * 这里用迭代
         */
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        /**
         * 申请空间存放合并的数组
         */
        int[] result = new int[left.length + right.length];
        int i = 0;

        while (left.length > 0 && right.length > 0) {
            if (left[0] < right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        /**
         * 如果left或者right还有剩余就按次序复制到result
         */

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

}