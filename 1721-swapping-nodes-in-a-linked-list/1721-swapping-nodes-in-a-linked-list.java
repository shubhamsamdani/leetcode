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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        
        int count = 0;
        while(first != null){
            
            count++ ;
            if(count == k){
                break;
            } 
            
            first = first.next;
            second = second.next;
                   
        }
        
        ListNode curr = head;
        while(second.next != null){
            second = second.next;
            curr = curr.next;
        }
        
        int temp = curr.val;
        curr.val = first.val;
        first.val = temp;
        
        return head;
        
    }
}