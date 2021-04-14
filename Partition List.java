class Solution {
    // TC- O(n)
    // SC - O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);
        ListNode sIT = smallerHead;
        ListNode gIT = greaterHead;
        ListNode it = head;
        while(it != null) {
            if(it.val < x) {
                // for smaller list
                sIT.next = it;
                it = it.next;
                sIT = sIT.next; 
            } else {
                // for greater elememnt comparison
                gIT.next = it;
                it = it.next;
                gIT = gIT.next;
            }
        }
        sIT.next = greaterHead.next;
        gIT.next = null;
        return smallerHead.next;
    }
}
