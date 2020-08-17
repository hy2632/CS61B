public class Issue {

    private final IntList aList = new IntList(0, null);

    // valid because aList is a pointer, not the object.
    public void modify(int k) {
        this.aList.head = k;
    }

    // Destructive solutions modify objects in the original list to
    // save time or space

    /** Destructively add N to P's items. */
    static IntList dincrList(IntList P, int n) {
        if (P == null)
            return null;
        else {
            P.head += n;
            P.tail = dincrList(P.tail, n);
            return P;
        }
    }

    /** Destructively add N to L's items. */
    static IntList dincrList_v2(IntList L, int n) {
        for (IntList p = L; p != null; p = p.tail)
            p.head += n;
        return L;
    }

    /** Another Example: Non-destructive List Deletion 
     * The List resulting from removing all instances of X from L non-destructively
    */
    
    static IntList removeAll_iter(IntList L, int x) {
        if (L == null)
            return null;
        IntList last, result;
        result = last = null;

        for ( ; L != null; L = L.tail){
            if (L.head == x)
                continue;
            else if (last == null){
                // actual initialization is here
                result = last = new IntList(L.head, null);
            }
            else {
                last.tail = new IntList(L.head, null);
                last = last.tail;
            }
        }
        return result;
    }

    static IntList removeAll_recursion(IntList L, int x) {
        if (L == null)
            return null;
        else if (L.head == x) 
            return removeAll_recursion(L.tail, x);
        else
            return new IntList(L.head, removeAll_iter(L.tail, x));
    }

    /** Destructive Deletion */
    static IntList dremoveAll (IntList L, int x){
        if (L == null) return null;
        else if (L.head == x)
            return dremoveAll(L.tail, x);
        else{
            L.tail = dremoveAll(L.tail, x);
            return L;
        }
    } 


    /** Iterative Destructive Deletion */
    static IntList dremoveAll_iter(IntList L, int x){
        IntList last, result;
        result = last = null;
        while (L != null){
            IntList next = L.tail;
            if (x != L.head){
                if (last == null)
                    result = last = L;
                else
                    last = last.tail = L;
                L.tail = null;
            }
            L = next;
        }
        return result;
    }


    public static void main(String[] args) {

        // IntList X = IntList.list(3, 43, 56);
        // IntList.printIntList(X);
        // IntList Q = dincrList(X, 2);
        // IntList.printIntList(Q);
        // IntList L = dincrList_v2(X, 2);
        // IntList.printIntList(L);

        /** Note that L does not change. */
        // IntList.printIntList(removeAll_iter(L, 5));
        // IntList.printIntList(L);

        // Iterative Destructive Deletion, Lec4
        // 如果P=(2,1,2,9)，经过destructive deletion(int x=2)，p的第一个2会保留
        IntList L = IntList.list(2,1,2,9);
        IntList.printIntList(dremoveAll(L, 2));
        IntList.printIntList(L);
    }

}

/**
 * 如何写loop: while(condition){Invariant true & condition true} Invariant true & condition false.
 */