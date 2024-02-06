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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftToRight = true;;
        
        
        while(! queue.isEmpty()){
            int nodesAtCurrentLevel = queue.size();
            List<Integer> tempList = new LinkedList<>();
            for(int i=0; i<nodesAtCurrentLevel; i++){
                TreeNode node = queue.poll();
                if(leftToRight ){
                     tempList.addLast(node.val);
                }
                else{
                     tempList.addFirst(node.val);
                }
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            leftToRight = ! leftToRight;
            list.add(tempList);
        }
        return list;
    }
}