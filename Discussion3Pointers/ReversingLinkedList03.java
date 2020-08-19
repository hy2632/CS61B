
/**
 * Implement the following method, which reverses an IntList nondestructively.
 * The original IntList should not be modified. Instead, the method should
 * return a new IntList that contains the elements of L in reverse order.
 */
public class ReversingLinkedList03 {
    public static IntList reverseNondestructive(IntList L) {
        IntList returnList = null;
        while (L != null) {
            returnList = new IntList(L.head, returnList);
            L = L.tail;
        }
        return returnList;
    }

    // Extra: Implement the following method which destructively reverses an
    // IntList.
    /** Destructively reverses IntList L. */
    public static IntList reverseDestructive(IntList L) {
        if (L == null || L.tail == null)
            return L;
        else {
            IntList reversed = reverseDestructive(L.tail);// reversed->4->3->2
            L.tail.tail = L; // 2->3改成2->1
            L.tail = null; // 1->2断开
            return reversed;
        }
    }

    //
    // L->1->2->3->4
    // A->1
    // B->2
    // C

    // L->1<-2 3->4
    // A->2->1
    // B->3
    // C->3
    // ....
    //
    public static IntList reverseDestructiveIterative(IntList L) {
        if (L == null || L.tail == null)
            return L;
        IntList A = L;
        IntList B = L.tail;
        A.tail = null;
        IntList C = null;

        while (B != null) {
            C = B.tail;
            B.tail = A;
            A = B;
            B = C;
        }
        return A;

    }


    public static void main(String[] args) {
        IntList L = IntList.list(1, 2, 3);
        IntList invL = reverseNondestructive(L);
        IntList.printIntList(invL);
        IntList.printIntList(reverseDestructive(L));
        IntList.printIntList(L);

    }
}