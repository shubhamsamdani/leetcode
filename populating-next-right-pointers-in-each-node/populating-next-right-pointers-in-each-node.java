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
        if(root == null){
            return root;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node prev = null;
            int size = q.size();
            while(size-- > 0){
                Node top = q.poll();
                top.next = prev;
                prev = top;
                
                if(top.right != null){
                    q.offer(top.right);
                }
                
                if(top.left != null){
                    q.offer(top.left);
                }
            }
        }
        return root;
    }

}