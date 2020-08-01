import java.util.Arrays;

public class THREESUM {
    public static void main(String[] args) {
        int[] a = new int[] { -6, 2, 4 };
        System.out.println(threeSum(a));
    }

    /**
     *  3Sum是一个O(n2)问题
     */
    private static boolean threeSum(int[] arr) {
        int[] s = mergesort(arr);

        if (s[0] > 0 | s[s.length - 1] < 0)
            return false;
        
        int i = 0;
        int start = 0;
        int end = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        
        for (i = 0; i < s.length; i++){
            a = s[i];
            start = i + 1;
            end = arr.length - 1;
            while (start < end){
                b = s[start];
                c = s[end];
                if (a + b + c == 0)
                    return true;
                else if (a + b + c > 0)
                    end --;
                else
                    start ++;
            }
        }
        return false;
    }


    private static int[] mergesort(int[] source_arr) {
        if (source_arr.length < 2)
            return source_arr;
        int[] arr = Arrays.copyOf(source_arr, source_arr.length);

        int mid = arr.length >> 1;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        /**
         * 这里用迭代
         */
        return merge(mergesort(left), mergesort(right));
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