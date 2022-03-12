/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        
        Node res = new Node(head.val);
        Node newCurr = res;
        Node curr = head.next;
        Map<Node,Node> map = new HashMap<>();
        map.put(head,res);
        while(curr != null){
            newCurr.next = new Node(curr.val);
            map.put(curr,newCurr.next);
            newCurr = newCurr.next;
            curr = curr.next;
        }
        
        curr = head;
        newCurr = res;
        while(curr != null){
            if(curr.random != null){
                Node rand = map.get(curr.random);
                newCurr.random = rand;
            }
            
            curr = curr.next;
            newCurr = newCurr.next;
        }
        
        return res;
    }
}