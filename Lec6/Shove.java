import java.util.Arrays;

public class Shove {
    /**
     * Rotate elements A[k] to A[A.length-1] one element to the right, where k is
     * the smallest index such that elements k through A.length-2 are all larger
     * than A[A.length-1].
     */

    /**
     * 问题分解： 1. 从N-1向前遍历找到最小k，使得k到N-1都比N-1处的大 2. Rotate：换位置 3. testing
     */

    static int findK(int[] A) {
        int k;
        for (k = A.length - 1; k >= 1 && A[k - 1] > A[A.length - 1]; k--) //注意out of bound问题
            ;
        return k;
    }

    static void moveOver(int[] A) {
        // FILL IN
        int k = findK(A);
        // System.out.println(k);
        int temp = A[A.length - 1];
        for (int i = A.length - 1; i > k; i--) { // 倒序
            A[i] = A[i - 1];
        }
        A[k] = temp;
    }

    public static void main(String[] args) {
        int[] A = { 1, 9, 4, 3, 0, 12, 11, 9, 12, 15, 22 };
        moveOver(A);
        System.out.println(Arrays.toString(A));
    }

}