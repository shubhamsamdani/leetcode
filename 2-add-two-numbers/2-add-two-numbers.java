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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        ListNode prev = null;
        int sum = 0, carry = 0;
        while(l1 != null && l2 != null){
            sum = carry + l1.val + l2.val;
            if(sum > 9){
                carry = sum/10;
                sum = sum%10;
            } else{
                carry = 0;
            }
            
            curr.val = sum;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            sum = carry + l1.val;
            if(sum > 9){
                carry = sum/10;
                sum = sum%10;
            } else{
                carry = 0;
            }
            
            curr.val = sum;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
            
            l1 = l1.next;
        }
        
        while(l2 != null){
            sum = carry + l2.val;
            if(sum > 9){
                carry = sum/10;
                sum = sum%10;
            } else{
                carry = 0;
            }
            
            curr.val = sum;
            curr.next = new ListNode();
            prev = curr;
            curr = curr.next;
            
            l2 = l2.next;
        }
        
        if(carry == 1){
            curr.val = carry;
        }
        
        if(curr.val == 0){
            prev.next = null;    
        }
        
        return res;
    }
}