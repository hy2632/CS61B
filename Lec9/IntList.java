import java.util.*;

public class IntList {
    public static void main(String[] args) {
        IntList Q, L;
        L = new IntList(3, null);
        Q = L;

        Q = new IntList(42, null);
        L.tail = Q;

        L.tail.tail = new IntList(56, null);

        L.tail.head += 1;

        System.out.println(Arrays.toString(IntList.convertToArrayList(L).toArray()));

        L = IntList.incrList(L, 2);
        System.out.println(Arrays.toString(IntList.convertToArrayList(L).toArray()));

        L = IntList.incrList_iter(L, 2);
        System.out.println(Arrays.toString(IntList.convertToArrayList(L).toArray()));
    }

    /**
     * Constructor function (used to initialize an object) List cell containing
     * (head, tail)
     * 
     * @param head
     * @param tail
     */

    public IntList(int head, IntList tail) {
        this.head = head;
        this.tail = tail;
    }

    // Names of simple containers (fields)
    public int head;
    // 链表的性质
    public IntList tail;

    /**
     * 该static函数将我们自己的类IntList转换为标准 ArrayList输出
     */
    public static List<Integer> convertToArrayList(IntList L) {
        List<Integer> L_converted = new ArrayList<>();
        IntList L_tail = L.tail;
        int L_head = L.head;
        L_converted.add(L_head);

        while (L_tail instanceof IntList) {
            L_head = L_tail.head;
            L_tail = L_tail.tail;
            L_converted.add(L_head);
        }
        return L_converted;
    }




    /**
     * recursive version. List of all items in P incremented by n. Does not modify
     * existing IntLists.
     */
    private static IntList incrList(IntList P, int n) {
        if (P == null)
            return null;
        else
            return new IntList(P.head + n, incrList(P.tail, n));
    }

    /**
     * Iterative version; result & last;
     */
    private static IntList incrList_iter(IntList P, int n) {
        if (P == null)
            return null;
        IntList last, result;
        result = last = new IntList(P.head + n, P.tail);
        while (P.tail != null) {
            P = P.tail;
            last.tail = new IntList(P.head + n, null);
            last = last.tail;
        }
        return result;
    }

    /**
     * IntList.list(int...args) 注意： java方法的可变长参数
     */
    public static IntList list(int... varargs) {
        IntList last, result;
        result = last = new IntList(varargs[0], null);
        if (varargs.length == 1)
            return result;
        for (int i = 1; i < varargs.length; i++) {
            last.tail = new IntList(varargs[i], null);
            last = last.tail;
        }
        return result;
    }

    public static void printIntList(IntList P) {
        System.out.println(Arrays.toString(IntList.convertToArrayList(P).toArray()));
    }
}