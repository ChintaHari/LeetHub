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
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left==null && root.right == null))
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(! queue.isEmpty()){
            int nodesAtCurrentLevel = queue.size();
            for(int i=0; i<nodesAtCurrentLevel; i++){
                TreeNode node = queue.poll();
                invert(node);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return root;
    }
    public void invert(TreeNode node){
        if(node == null)
            return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}