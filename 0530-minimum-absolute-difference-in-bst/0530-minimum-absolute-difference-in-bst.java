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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            ans = Math.min(ans, values.get(i) - values.get(i - 1));
        }

        return ans;
    }
    
    public void dfs(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        
        dfs(node.left, values);
        values.add(node.val);
        dfs(node.right, values);
    }
}