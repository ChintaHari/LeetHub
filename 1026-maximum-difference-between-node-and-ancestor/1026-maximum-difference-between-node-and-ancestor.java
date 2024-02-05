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
        if(root == null)
            return 0;
        dfs(root, root.val, root.val);
        return maxDiff;
    }
    public void dfs(TreeNode node, int minAncestor, int maxAncestor){
        if(node == null)
            return ;
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(node.val - minAncestor), Math.abs(node.val - maxAncestor)));

        dfs(node.left, Math.min(minAncestor, node.val), Math.max(maxAncestor, node.val));
        dfs(node.right, Math.min(minAncestor, node.val), Math.max(maxAncestor, node.val));
    }
}