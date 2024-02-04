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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
        
    }
    public int dfs(TreeNode node, int maxSoFar){
        if(node == null)
            return 0;
        int left = dfs(node.left, Math.max(maxSoFar,  node.val));
        int right = dfs(node.right, Math.max(maxSoFar, node.val));
        int ans = left + right;
        if(node.val >= maxSoFar)
            ans = ans + 1;
        return ans;
    }
}