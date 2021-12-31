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
    int maxDiff = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        maxDiffHelper(root);
        return maxDiff;
    }
    
    private int[] maxDiffHelper(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        
        int[] left = maxDiffHelper(root.left);
        int[] right = maxDiffHelper(root.right);
        
        int maxVal = Math.max(root.val, Math.max(left[1], right[1]));
        int minVal = Math.min(root.val, Math.min(left[0], right[0]));
        
        maxDiff = Math.max(root.val - minVal, Math.max(maxVal - root.val, maxDiff));
        return new int[]{minVal,maxVal};
    }
}