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

// tc - O(n)
// sc- O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        ListNode temp = head;
        int n=1;
        while(temp.next != null) {
            n++;
            temp = temp.next;
        }
        ListNode pre = null;
        ListNode next = null;
        temp = head;
        for(int i=0; i<n/2; i++) {
            //Reverse
            next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }
        if(n%2==1) {
            temp = temp.next;
        }
            while(temp != null) {
                if(temp.val != pre.val) {
                    return false;
                }
                temp = temp.next;
                pre = pre.next;
            
        }
        return true;
    }
}
