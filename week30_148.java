public class week30_148 {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        // merge sort
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        if (fast == null) return head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(temp);
        return merge(h1, h2);
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                prev.next = h1;
                prev = h1;
                h1 = h1.next;
            } else {
                prev.next = h2;
                prev = h2;
                h2 = h2.next;
            }
        }
        if (h1 != null) {
            prev.next = h1;
        }
        if (h2 != null) {
            prev.next = h2;
        }
        return dummy.next;
    }
}
}