import java.util.Arrays;

public class LL {
    public static ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        // Initialize 
        ListNode last;
        
        if (l1.val <= l2.val) {
            last = l1;
            l1 = l1.next;
        } else {
            last = l2;
            l2 = l2.next;
        }
        ListNode result = last;
        
        while(l1 != null && l2 != null){
            System.out.printf("l1.val {%d}, l2.val {%d}\n", l1.val, l2.val);
            if (l1.val <= l2.val){
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }
        
        while(l1 != null){
            System.out.printf("l1.val {%d}\n", l1.val);
            last.next = l1;
            l1 = l1.next;
            last = last.next;
        }
        
        while(l2 != null){
            System.out.printf("l2.val {%d}\n", l2.val);
            last.next = l2;
            l2 = l2.next;
            last = last.next;
        }
        
        return result;
    }

    public static void main(String[] args){
        int[] a1 = {1,2,3,3,3};
        int[] a2 = {2,3,4,5};

        ListNode l1 = ListNode.fromArray(a1);
        ListNode l2 = ListNode.fromArray(a2);
        ListNode merged = mergeTwoLists(l1, l2);
        System.out.println(Arrays.toString(ListNode.toArray(merged)));

    }

}
