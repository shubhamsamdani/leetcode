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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        
        head = swapNode(head);
        return head;
    }
    
    private ListNode swapNode(ListNode head){
        if( head == null || head.next == null){
            return head;
        }
        
        ListNode temp = head.next;
        head.next = (head.next).next;
        temp.next = head;
        
        head.next = swapNode(head.next);
        return temp;
    }
}