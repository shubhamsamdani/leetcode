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
class Solution {
    int pos = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        pos = n-1;
        
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<n;++i) {
            map.put(inorder[i], i);
        }
        
        return constructTree(inorder,postorder,0,n-1,map);
    }
    
    public TreeNode constructTree(int[] inorder, int[] postorder, int start, int end,Map<Integer, Integer> map){
        if(start > end || pos < 0){
            return null;
        }
        
        int val = postorder[pos];
        TreeNode root = new TreeNode(val);
        pos-- ;
        
        int i = map.get(val);
       
         TreeNode right = constructTree(inorder,postorder,i+1,end,map);
        TreeNode left = constructTree(inorder,postorder,start,i-1,map);
       
        
        root.left = left;
        root.right = right;
        
        return root;
        
    }
}