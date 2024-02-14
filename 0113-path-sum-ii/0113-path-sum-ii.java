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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> currPath = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        dfs(root, 0, targetSum);
        
        return ans;
    }
    
    public void dfs(TreeNode node, int currSum, int targetSum){
        if(node == null)
            return ;
        currPath.add(node.val);
        currSum = currSum + node.val;
        if(node.left == null && node.right == null && currSum == targetSum)
            ans.add(new ArrayList<>(currPath));
        else{
            dfs(node.left, currSum, targetSum);
            dfs(node.right, currSum, targetSum);
        }
        currPath.remove(currPath.size() - 1);
    }
}