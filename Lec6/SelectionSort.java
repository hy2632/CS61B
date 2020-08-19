public class SelectionSort {

    /** Sort items A[L..U], with all others unchanged. */
    static void sortRecursive(String[] A, int L, int U) {
        if (L < U) {
            int k = indexOfLargestIter(A, L, U);
            /* {swap A[k] with A[U]} */
            String tmp = A[k];
            A[k] = A[U];
            A[U] = tmp;
            sortRecursive(A, L, U - 1);
        }
    }

    static void sortIter(String[] A, int L, int U) {
        while (L < U) {
            int k = indexOfLargestIter(A, L, U);
            String temp = A[U];
            A[U] = A[k];
            A[k] = temp;
            U--;
        }
    }

    /**
     * Index k, I0<=k<=I1, such that V[k] is largest element among V[I0], ... V[I1].
     * Requires I0<=I1. Iterative version.
     */
    static int indexOfLargestIter(String[] V, int i0, int i1) {
        if (i0 >= i1)
            return i1;
        else {
            int argmax = i0;
            for (int idx = i0 + 1; idx <= i1; idx++)
                argmax = (V[argmax].compareTo(V[idx]) < 0) ? idx : argmax;
            return argmax;
        }
    }

    /** Recursive version */
    static int indexOfLargestRecursive(String[] V, int i0, int i1) {
        if (i0 >= i1)
            return i1;
        else {
            int k = indexOfLargestRecursive(V, i0 + 1, i1);
            return (V[i0].compareTo(V[k]) > 0) ? i0 : k;
        }
    }

    static void print(String[] A){
        for (int i=0; i< A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // System.out.println("hello");
        System.out.println(indexOfLargestIter(new String[] { "a", "b", "c" }, 0, 2));
        System.out.println(indexOfLargestRecursive(new String[] { "a", "b", "c" }, 0, 2));
    }
}