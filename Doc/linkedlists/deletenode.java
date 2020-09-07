import java.util.Arrays;

public class deletenode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        ListNode prev, curr, next;
        int len = 0;
        curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        // 去除head
        if (n == len) {
            return head.next;
        }

        curr = head;
        for (int i = 0; i < len - n - 1; i++) {
            curr = curr.next;
        }
        prev = curr;
        curr = curr.next;
        next = curr.next;
        prev.next = next;
        return head;
    }

    public static void main(String[] args) {
        ListNode a;
        a = ListNode.fromArray(new int[] { 1 });
        System.out.println(Arrays.toString(ListNode.toArray(removeNthFromEnd(a, 1))));
    }
}
