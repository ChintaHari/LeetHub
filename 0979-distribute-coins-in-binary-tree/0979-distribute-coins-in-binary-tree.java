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
    int res;
    public int distributeCoins(TreeNode root) {
        
        res = 0;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode cur) {
        if (cur == null) {
            return new int[]{0, 0};
        }

        int[] l = dfs(cur.left);
        int[] r = dfs(cur.right);
        
        int size = 1 + l[0] + r[0];
        int coins = cur.val + l[1] + r[1];
        
        res += Math.abs(size - coins);
        
        return new int[]{size, coins};
    }
        
}