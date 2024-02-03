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
    int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return dfs(root, 0); 
    }
    
    public boolean dfs(TreeNode root, int curr){
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return root.val + curr == target;
        curr = curr + root.val;
        boolean left = dfs(root.left, curr);
        boolean right = dfs(root.right, curr);
        
        return left || right;
    }
}