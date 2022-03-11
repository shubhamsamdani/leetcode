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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        if( k == 0) return head;
        
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            len++ ;
            curr = curr.next;
        }
        
        k = k%len ;
        if( k == 0) return head;
        
        int s = len - k;
        curr = head;
        int i = 1;
        while( i < s){
            i++ ;
            curr = curr.next ;
        }
        
        ListNode temp = curr.next ;
        ListNode p = temp;
        
        while(temp.next != null){
            temp = temp.next;
        }
        
        if(temp != null)
            temp.next = head;
        else
            temp = head;
        
        curr.next = null;
        return p;
    }
}