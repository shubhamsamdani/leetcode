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
    public int pairSum(ListNode head) {
        Stack<Integer> s1 = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            s1.push(slow.val);
            slow = slow.next;
        }
        
        int max = 0;
        while(slow != null){
            max = Math.max(s1.pop() + slow.val, max);
            slow = slow.next;
        }
        
        return max;
    }
}