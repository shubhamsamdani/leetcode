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
    public ListNode partition(ListNode head, int x) {
        ListNode before = null;
        ListNode after = null;
        ListNode newHead = null;
        ListNode curr = head;
        ListNode greater = null;
        while(curr != null){
            if(curr.val < x){
                if(before == null){
                    before = new ListNode(curr.val);
                    newHead = before;
                } else{
                    ListNode temp = new ListNode(curr.val);
                    before.next = temp;
                    before = before.next;

                }
                
             } else{
                if(after == null){
                    after = new ListNode(curr.val);
                    greater = after;
                } else{
                    ListNode temp1 = new ListNode(curr.val);
                    after.next = temp1;
                    after = after.next;    
                }
            }
            
            curr = curr.next;
        }
        
        if(before != null){
             before.next = greater;   
        }
        
        if(newHead == null){
            return greater;
        }
        
        return newHead;
       
    }
}