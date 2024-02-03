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
// class Solution {
//     int target;
//     public boolean hasPathSum(TreeNode root, int targetSum) {
//         target = targetSum;
//         return dfs(root, 0); 
//     }
    
//     public boolean dfs(TreeNode root, int curr){
//         if(root == null)
//             return false;
//         if(root.left == null && root.right == null)
//             return root.val + curr == target;
//         curr = curr + root.val;
//         boolean left = dfs(root.left, curr);
//         boolean right = dfs(root.right, curr);
        
//         return left || right;
//     }
// }


class Pair{
    TreeNode node;
    int curr;
    Pair(TreeNode node, int curr){
        this.node = node;
        this.curr = curr;
    }
}

class Solution{
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root == null)
            return false;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));
        
        
        
        while(!stack.isEmpty()){
            Pair pop = stack.pop();
            TreeNode node = pop.node;
            if(node.left == null && node.right == null)
                if(pop.curr + node.val == targetSum)
                        return true;
            int curr = pop.curr;
            curr = curr + node.val;
            if(node.left != null)
                stack.push(new Pair(node.left, curr));
            if(node.right != null)
                stack.push(new Pair(node.right, curr));
        }        
        
        return false;
        
    }
}