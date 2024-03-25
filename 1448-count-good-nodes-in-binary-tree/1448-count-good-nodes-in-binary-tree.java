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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
        
    }
    public int dfs(TreeNode node, int maxSoFar){
        if(node == null)
            return 0;
        int ans = 0;
         if(node.val >= maxSoFar)
            ans = ans + 1;
        int left = dfs(node.left, Math.max(maxSoFar,  node.val));
        int right = dfs(node.right, Math.max(maxSoFar, node.val));
        ans = ans + left + right;
       
        return ans;
    }
}

// class Pair{
//     TreeNode node;
//     int maxSoFar;
//     Pair(TreeNode node, int maxSoFar){
//         this.node = node;
//         this.maxSoFar = maxSoFar;
//     }
// }
// class Solution{
//     public int goodNodes(TreeNode root){
//         if(root == null)
//             return 0;
//         Stack<Pair> stack = new Stack<>();
//         int ans = 0;
//         stack.push(new Pair(root, Integer.MIN_VALUE));
//         while(! stack.isEmpty()){
//             Pair pair = stack.pop();
//             TreeNode node = pair.node;
//             int maxSoFar = pair.maxSoFar;
//             if(node.val >= maxSoFar)
//                 ans++;
//             if(node.left != null)
//                 stack.push(new Pair(node.left, Math.max(maxSoFar, node.val)));
//             if(node.right != null)
//                 stack.push(new Pair(node.right, Math.max(maxSoFar, node.val)));
//         }
//         return ans;
//     }
// }