import java.util.Arrays;
import static java.lang.System.arraycopy;

/**
 * CS61B Lecture #5: Arrays
 */

public class Lec5 {
    /**
     * Insert X at location K in ARR, moving items K, K+1, ... to locations K+1,
     * K+2, .... The last item in ARR is lost.
     */
    static void insert(String[] arr, int k, String x) {
        // for (int i = arr.length-1; i>k; i--)
        // arr[i] = arr[i-1];
        arraycopy(arr, k - 1, arr, k, arr.length - k - 1); // copy: (k-1:arr.length) -> (k, arr.length)
        arr[k] = x;
    }

    /**
     * Return array, r, where r.length = ARR.length+1; r[0..K-1] the same as
     * ARR[0..K-1], r[k] = x, r[K+1..] same as ARR[K..].
     */
    static String[] insert2(String[] arr, int k, String x) {
        String[] result = new String[arr.length + 1];
        arraycopy(arr, 0, result, 0, k);
        arraycopy(arr, k, result, k + 1, arr.length - k);
        result[k] = x;
        return result;
    }

    /**
     * Example: Merging Program Problem: Given two sorted arrays of ints, A and B,
     * produce their merge: a sorted array containing all from A and B. Remark: In
     * order to solve this recursively, it is useful to generalize the original
     * function to allow merging portions of the arrays
     */

    /** Assuming A and B are sorted, returns their merge. */
    public static int[] mergeRecursive(int[] A, int[] B) {
        return mergeToRecursive(A, 0, B, 0, new int[A.length + B.length], 0);
    }

    /**
     * Merge A[L0..] and B[L1..] into C[K..], assuming A and B sorted. Tail
     * recursive
     */
    static int[] mergeToRecursive(int[] A, int L0, int[] B, int L1, int[] C, int k) {
        if (L0 >= A.length && L1 >= B.length)
            return C;
        else if (L1 >= B.length || L0 < A.length && A[L0] <= B[L1]) {
            C[k] = A[L0];
            return mergeToRecursive(A, L0 + 1, B, L1, C, k + 1);
        } else {
            C[k] = B[L1];
            return mergeToRecursive(A, L0, B, L1 + 1, C, k + 1);
        }
    }

    public static int[] mergeIterative(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        // mergeTo (A, 0, B, 0, C, 0)
        int L0, L1, k;
        L0 = L1 = k = 0;

        while (L0 < A.length || L1 < B.length) {
            if (L1 >= B.length || L0 < A.length && A[L0] <= B[L1]) {
                C[k] = A[L0];
                L0++;
                k++;
            } else {
                C[k] = B[L1];
                L1++;
                k++;
            }
        }
        return C;
    }

    public static int[] mergeIterative2(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int L0, L1;
        L0 = L1 = 0;

        for (int k = 0; k < C.length; k++) {
            if (L1 >= B.length || (L0 < A.length && A[L0] <= B[L1])) {
                C[k] = A[L0];
                L0++;
            } else {
                C[k] = B[L1];
                L1++;
            }
        }
        return C;
    }

    /** Remove k */
    public static int[] mergeIterative3(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int L0, L1;
        L0 = L1 = 0;
        // invariant: k = L0 + L1

        while (L0 + L1 < C.length) {
            if (L1 >= B.length || (L0 < A.length && A[L0] <= B[L1])) {
                C[L0 + L1] = A[L0];
                L0++;
            } else {
                C[L0 + L1] = B[L1];
                L1++;
            }
        }
        return C;

    }

    public static void main(String[] args) {
        // int[] q = new int[] { 1, 2, 3 };
        // String[] r = { "abc", "bcd", "des", "rip", "qpwe" };
        // System.out.println(Arrays.toString(r));
        // insert(r, 3, "cxk");
        // System.out.println(Arrays.toString(r));

        // String[] r2 = { "abc", "bcd", "des", "rip", "qpwe" };
        // System.out.println(Arrays.toString(insert2(r2, 3, "cxk")));

        int[] A = { 1, 2, 3, 4, 5, 6, 7 };
        int[] B = { 4, 5, 6, 7, 8, 10 };

        System.out.println(Arrays.toString(mergeIterative3(A, B)));
        int[][] ZERO = new int[3][];
        ZERO[0] = ZERO[1] = ZERO[2] = new int[] { 0, 0, 0 };
        ZERO[0][1] = 1;
        System.out.println(ZERO[2][1]);

    }
}