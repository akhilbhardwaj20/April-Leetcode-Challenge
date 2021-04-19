class Solution {
    // Single pass solution
    // TC - O(l) where l is the length 0f the list
    // SC - O(1) since we are not using any extra space
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy , fast = dummy;
        // lets iterate till fast reaches n+1 from start
        for(int i = 1; i <= n+1; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // the slow.next is the node to be deleted. So update the slow pointer
        slow.next = slow.next.next;
        return dummy.next;
        
        
    }
}
