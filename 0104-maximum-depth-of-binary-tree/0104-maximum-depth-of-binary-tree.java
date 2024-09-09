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

class Pair{
    TreeNode node;
    int depth;
    Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}
class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root == null)
            return 0;
        
        Stack<Pair> stack = new Stack<>();
        int ans = 0;
        stack.push(new Pair(root, 1));
        
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode currentNode = pair.node;
            int currentDepth = pair.depth;
            
            ans = Math.max(ans, currentDepth);
            
            if(currentNode.left != null)
                stack.push(new Pair(currentNode.left, currentDepth + 1));
            
            if(currentNode.right != null)
                stack.push(new Pair(currentNode.right, currentDepth + 1));
        }
        
        return ans;
    }
}