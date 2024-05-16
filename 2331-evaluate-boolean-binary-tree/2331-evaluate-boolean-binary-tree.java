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

// Recursive DFS
/* class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root.left == null && root.right == null)
            return root.val == 1;
        
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        
        if(root.val == 2)
            return left | right;
        else
            return left & right;
    }
} */

// Iterative DFS
class Solution {
    public boolean evaluateTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Boolean> map = new HashMap<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left == null && node.right == null){
                stack.pop();
                map.put(node, node.val == 1);
                continue;
            }
            if(map.containsKey(node.left) && map.containsKey(node.right)){
                stack.pop();
                if(node.val == 2)
                    map.put(node, map.get(node.left) | map.get(node.right));
                else
                    map.put(node, map.get(node.left) & map.get(node.right));
            }
            else{
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return map.get(root);
    }
}