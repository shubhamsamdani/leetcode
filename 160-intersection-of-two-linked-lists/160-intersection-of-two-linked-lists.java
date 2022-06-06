/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr1 = headA;
        while(curr1 != null){
            set.add(curr1);
            curr1 = curr1.next;
        }
        
        ListNode curr2 = headB;
        while(curr2 != null){
            if(set.contains(curr2)){
                return curr2;
            }
            
            curr2 = curr2.next;
        }
        
        return null;
    }
}