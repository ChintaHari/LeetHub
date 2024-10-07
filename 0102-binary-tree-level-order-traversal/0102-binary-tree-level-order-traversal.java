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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> inOrder = new ArrayList<>();
            int numberOfNodesInTheCurrentLevel = queue.size();
            
            for(int i=0; i<numberOfNodesInTheCurrentLevel; i++){
                TreeNode node = queue.poll();
                inOrder.add(node.val);
                
                if(node.left != null)
                    queue.offer(node.left);
                
                if(node.right != null)
                    queue.offer(node.right);
            }
            
            result.add(inOrder);
        }
        return result;
    }
}