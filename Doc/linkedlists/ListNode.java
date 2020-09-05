import java.util.Arrays;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public static int[] toArray(ListNode head){
        int[] arr = {};
        while (head != null){
            arr = Arrays.copyOf(arr, arr.length+1);
            arr[arr.length-1] = head.val;
            head = head.next;
        }
        return arr;
    }

    public static ListNode fromArray(int[] arr){
        if (arr.length == 0) return null;

        ListNode ll = new ListNode(arr[0]);
        ListNode head = ll;
        for (int i = 1; i < arr.length; i++){
            ll.next = new ListNode(arr[i]);
            ll = ll.next;
        }
        return head;
    }

}
