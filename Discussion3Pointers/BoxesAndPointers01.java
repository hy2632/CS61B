public class BoxesAndPointers01 {
    public static void main(String[] args) {
        IntList L = IntList.list(1, 2, 3, 4);
        IntList M = L.tail.tail;
        IntList N = IntList.list(5, 6, 7);
        N.tail.tail.tail = N;
        L.tail.tail = N.tail.tail.tail.tail;
        M.tail.tail = L;

        IntList L1 = IntList.list(1, 2, 3);
        IntList L2 = new IntList(4, L1.tail);
        L2.tail.head = 13;
        L1.tail.tail.tail = L2;
        IntList L3 = IntList.list(50);
        L2.tail.tail = L3;

    }
}