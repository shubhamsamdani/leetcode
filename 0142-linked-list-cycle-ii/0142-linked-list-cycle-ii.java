/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean start = true;
        while(fast != slow || start){
            start = false;
            
            if(slow != null)
                slow = slow.next;
            
            if(fast != null){
                fast = fast.next;
            }
            
            if(fast != null){
                fast = fast.next;
            }
        }
        
        fast = head;
        while(fast != slow){
            if(fast != null)
                fast = fast.next;
            
            if(slow != null){
                slow = slow.next;
            }
        }
        
        return fast;
    }
}