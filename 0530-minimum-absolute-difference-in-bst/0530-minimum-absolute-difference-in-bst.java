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
    List<Integer> list = new ArrayList<>();
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return 0;
        
        dfs(root);
        for(int i=0; i<list.size()-1; i++)
            ans = Math.min(ans, (list.get(i+1) - list.get(i)));
        
        return ans;
        
    }
    public void dfs(TreeNode node) {
        
        if(node == null)
            return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
        
    }
    
}