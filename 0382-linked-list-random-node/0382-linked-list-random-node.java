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

    List<Integer> list;
    int listSize = 0;
    public Solution(ListNode head) {
        list = new ArrayList<>();
        int size = 0;
        while(head != null){
            list.add(head.val);
            size++ ;
            head = head.next;
        }
        
        listSize = size;
    }
    
    public int getRandom() {
        Random random = new Random();   
        int index = random.nextInt(listSize);
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */