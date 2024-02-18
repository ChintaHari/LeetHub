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
// class Test{
//     TreeNode node1, node2;
//     Test(TreeNode node1, TreeNode node2){
//         this.node1 = node1;
//         this.node2 = node2;
//     }
// }
class Solution {
    Queue<TreeNode> queue = new LinkedList<>();
    
    public TreeNode invertTree(TreeNode root) {
        
        if(root==null || (root.left == null && root.right == null))
            return root;
        queue.offer(root);
        while(! queue.isEmpty()){
            int nodesAtCurrentLevel = queue.size();
            TreeNode node = queue.poll();
            if(node.left == null && node.right == null)
                continue;
            if(node.right !=null || node.left != null){
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);
        }
        return root;
        
        
    }
}