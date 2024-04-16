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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currDepth = 1;
        
        while (!queue.isEmpty()) {
            if (currDepth == depth - 1) {
                int nodesAtCurrentLevel = queue.size();
                for (int i = 0; i < nodesAtCurrentLevel; i++) {
                    TreeNode node = queue.poll();
                    
                    TreeNode tempLeft = node.left;
                    node.left = new TreeNode(val);
                    node.left.left = tempLeft;

                    TreeNode tempRight = node.right;
                    node.right = new TreeNode(val);
                    node.right.right = tempRight;
                }
                break;
            } 
            
            else {
                int nodesAtCurrentLevel = queue.size();
                for (int i = 0; i < nodesAtCurrentLevel; i++) {
                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                currDepth++;
            }
        }
        return root;
    }
}
