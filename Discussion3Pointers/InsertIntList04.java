public class InsertIntList04 {

    /**
     * 4 Inserting into a Linked List:
     * 
     * Implement the following method to insert an element item at a given position
     * position of an IntList L. For example, if L is (1 -> 2 -> 4) then the result
     * of calling insert(L, 3, 2) yields the list (1 -> 2 -> 3 -> 4). This method
     * should modify the original list (do not create an entirely new list from
     * scratch). Use recursion.
     */

    public static IntList insertRecursive(IntList L, int item, int position) {
        // 基本情况 L == null / position==0
        if (L == null)
            return new IntList(item, null);
        if (position == 0) {
            L.tail = new IntList(L.head, L.tail); // L->1->1->2->3
            L.head = item; // L->item->1->2->3
        } else {
            L.tail = insertRecursive(L.tail, item, position - 1);
        }
        return L;
    }

    /**
     * Inserts item at the given position in IntList L and returns the resulting
     * IntList. If the value of position is past the end of the list, inserts the
     * item at the end of the list. Uses iteration.
     */
    // 把recursion改为iteration
    // invariant是什么？ position>=0 & L!=null
    public static IntList insertIterative(IntList L, int item, int position) {
        if (L == null)
            return new IntList(item, null);
        if (position == 0) {
            L.tail = new IntList(L.head, L.tail); // L->1->1->2->3
            L.head = item; // L->item->1->2->3
        } else { // position之前的链表部分一步步撇开移至左边的stack，直到item相对位置为0
            IntList current = L; // current 逐步向后
            while (position > 1) {
                current = current.tail;
                position--;
            } // current 向后position-1步
            current.tail = new IntList(item, current.tail); // current目前指向链表里第pos个head
        }
        return L;
    }
}