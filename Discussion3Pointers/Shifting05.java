public class Shifting05 {
    /**
     * 5 Extra: Shifting a Linked List
     * 
     * Implement the following method to circularly shift an IntList to the left by
     * one position destructively. For example, if the original list is (5 -> 4 -> 9
     * -> 1 -> 2 -> 3) then this method should return the list (4 -> 9 -> 1 -> 2 ->
     * 3 -> 5). Because it is a destructive method, the original IntList should be
     * modified. Do not use the word new.
     */

    /**
     * Destructively shifts the elements of the given IntList L to the left by one
     * position. Returns the first node in the shifted list.
     */

    // 画一个drawio文件
    public static IntList shiftListDestructive(IntList L) {
        if (L==null)
            return null;
        else if (L.tail == null)
            return L;
        else{
            // IntList pt1 = L;
            IntList pt2 = L.tail;
            IntList current = L;
            while (current.tail != null){
                current = current.tail;
            }
            // pt1 多余了
            // current.tail = pt1;
            // pt1.tail = null;
            current.tail = L;
            L.tail = null;
            return pt2;
        }
    }

}