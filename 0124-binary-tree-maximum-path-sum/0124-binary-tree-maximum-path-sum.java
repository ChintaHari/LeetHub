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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int dummy = computeMaxPath(root);
        return maxPath;
    }
    
    public int computeMaxPath(TreeNode node){
        if(node == null)
            return 0;
        
        int left = Math.max(0, computeMaxPath(node.left));
        int right = Math.max(0, computeMaxPath(node.right));
        
        maxPath = Math.max(maxPath, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}