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
    List<Integer> tree1 = new ArrayList<>();
    List<Integer> tree2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        dfs(root1, tree1);
        dfs(root2, tree2);
        
        return tree1.equals(tree2);
        
    }
    
    public void dfs(TreeNode node, List<Integer> tree){
        if(node == null)
            return;
        if(node.left == null && node.right == null)
            tree.add(node.val);
        dfs(node.left, tree);
        dfs(node.right, tree);
    }
}