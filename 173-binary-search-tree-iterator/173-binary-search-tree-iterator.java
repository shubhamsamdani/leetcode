/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {

    TreeNode curr;
    Stack<TreeNode> s1;
    public BSTIterator(TreeNode root) {
        this.curr = root;
        s1 = new Stack<>();
    }
    
    public int next() {
        while(curr != null){
                s1.push(curr);
                curr = curr.left;
        }
            
        TreeNode next = s1.pop();
        curr = next.right;
        return next.val;
        
    }
    
    public boolean hasNext() {
        return (curr != null || !s1.isEmpty());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */