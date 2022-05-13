/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node rootPtr = root;
        
        while (root != null) {
            Node temp = new Node(-1);       // temporary node
            Node cur = temp;                // point to next of temp node, or first node of next level
            
            while (root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;           // current level nodes has already been chained in the previous loop
                
            }
            
            root = temp.next;   // root becomes first node of next level
        }
        
        return rootPtr;
    }
}