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
    List<Integer> tree1 = new ArrayList<>();
    List<Integer> tree2 = new ArrayList<>();
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(p==null && q==null)
        //     return true;
        // if((p==null && q!=null) || (q==null && p!=null))
        //     return false;
        // if(p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
        //     return true;
        // return false;
        
        if(p == null && q == null)
            return true;
        if((p==null && q!=null) || (p!=null && q==null))
            return false;
        dfs(p, tree1);
        dfs(q, tree2);
        
        return tree1.equals(tree2);
        
    }
    
    public void dfs(TreeNode node, List<Integer> tree){
        if(node == null){
            tree.add(null);
            return;
        }
           
        tree.add(node.val);
        dfs(node.left, tree);
        dfs(node.right, tree);
    }
}