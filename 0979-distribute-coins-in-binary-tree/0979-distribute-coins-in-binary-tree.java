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
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) 
            return new int[]{0, 0};

        int[] left_node = dfs(node.left);
        int[] right_node = dfs(node.right);
        
        int size = 1 + left_node[0] + right_node[0];
        int coins = node.val + left_node[1] + right_node[1];
        
        moves = moves + Math.abs(size - coins);
        
        return new int[]{size, coins};
    }
        
}