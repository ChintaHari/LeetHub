//Watch this video: https://www.youtube.com/watch?v=Hr5cWUld4vU&ab_channel=NeetCode

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
        int dummy = maxPathSumCompute(root);
        return maxPath;
    }
    
    public int maxPathSumCompute(TreeNode node){
        if(node == null)
            return 0;
        
        int left = Math.max(0, maxPathSumCompute(node.left));
        int right = Math.max(0, maxPathSumCompute(node.right));
        
        maxPath = Math.max(maxPath, left + right + node.val);
        return Math.max(left, right) + node.val;
        
    }
}