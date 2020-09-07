import java.util.Arrays;

public class addInList0907 {
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        ListNode head1Rev = reverseList(head1);
        ListNode head2Rev = reverseList(head2);
        ListNode mergeRevCurr = null;
        ListNode mergeRev = mergeRevCurr;

        int cache = 0;
        int digit = 0;
        boolean init = true;

        while (head1Rev != null && head2Rev != null) {
            digit = head1Rev.val + head2Rev.val + cache;
            if (digit >= 10) {
                digit -= 10;
                cache = 1;
            } else {
                cache = 0;
            }
            ListNode currDigit = new ListNode(digit);

            if (init) {
                init = false;
                mergeRevCurr = currDigit; // 这一步同步
                mergeRev = mergeRevCurr;
                // System.out.println(Arrays.toString(ListNode.toArray(mergeRev)));
            } else {
                mergeRevCurr.next = currDigit;
                mergeRevCurr = mergeRevCurr.next;
            }
            head1Rev = head1Rev.next;
            head2Rev = head2Rev.next;

        }

        while (head1Rev != null) {
            digit = head1Rev.val + cache;
            if (digit >= 10) {
                digit -= 10;
                cache = 1;
            } else {
                cache = 0;
            }
            ListNode currDigit = new ListNode(digit);

            if (init)
                mergeRevCurr = currDigit;
            else {
                mergeRevCurr.next = currDigit;
                mergeRevCurr = mergeRevCurr.next;
            }
            head1Rev = head1Rev.next;
        }

        while (head2Rev != null) {
            digit = head2Rev.val + cache;
            if (digit >= 10) {
                digit -= 10;
                cache = 1;
            } else {
                cache = 0;
            }
            ListNode currDigit = new ListNode(digit);

            if (init)
                mergeRevCurr = currDigit;
            else {
                mergeRevCurr.next = currDigit;
                mergeRevCurr = mergeRevCurr.next;
            }
            head2Rev = head2Rev.next;
        }

        if (cache == 1) {
            // System.out.println(Arrays.toString(ListNode.toArray(mergeRev)));
            ListNode currDigit = new ListNode(1);
            mergeRevCurr.next = currDigit;
            mergeRevCurr = mergeRevCurr.next;
        }

        return reverseList(mergeRev);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev, curr, next;
        prev = null;
        curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.fromArray(new int[] { 5, 9, 7, 5, 7, 1, 2, 6, 4, 2, 7, 8, 9, 6, 1, 6, 6, 1, 1, 4, 2, 9,
                5, 5, 0, 4, 6, 3, 0, 4, 3, 5, 6, 7, 0, 5, 5, 4, 4, 0 });
        ListNode l2 = ListNode.fromArray(new int[] { 1, 3, 2, 5, 0, 6, 0, 2, 1, 4, 3, 9, 3, 0, 9, 9, 0, 3, 1, 6, 5, 7,
                8, 6, 2, 3, 8, 5, 0, 9, 7, 9, 4, 5, 9, 9, 4, 9, 3, 6 });
        // System.out.println(Arrays.toString(ListNode.toArray(reverseList(l1))));
        System.out.println(Arrays.toString(ListNode.toArray(addInList(l2, l1))));
    }
}
