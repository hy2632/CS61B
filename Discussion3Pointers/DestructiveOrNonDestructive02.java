public class DestructiveOrNonDestructive02 {
    /** Returns the head of IntList L. Assumes that L is not null. */
    public static void main(final String[] args) {
        final IntList L = IntList.list(3, 10);
        System.out.println(L); //IntList@8efb846
        getHead(L);
        System.out.println(L); //IntList@8efb846
    }

    public static int getHead(IntList L) {
        System.out.println(L); //IntList@8efb846
        final int listHead = L.head;
        L = new IntList(5, null);
        System.out.println(L); //IntList@2a84aee7
        return listHead;
    }

    /**
     * Is the above method destructive or nondestructive? Explain
     * 
     * Non-destructive. 
     * Java 值传递，指针为参数时，内部是指针的复制
     * 可以看出 L = new IntList(5, null); 只是创建一个局部变量
     * 如何真正destructively更改L呢？ L.head = 5.
     */

}