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
    String s;
    
    Pair(TreeNode node, String s){
        this.node = node;
        this.s = s;
    }
}
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        List<String> allStrings = new ArrayList<>();
        queue.offer(new Pair(root, ""));
        
        StringBuffer sb = new StringBuffer();
        
        while(!queue.isEmpty()){
            int nodesAtCurrentLevel = queue.size();
            for(int i=0; i<nodesAtCurrentLevel; i++){
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                String s = pair.s;
                
                char c = (char) ('a' + node.val);
                s = s + c;
                
                if(node.left != null)
                    queue.offer(new Pair(node.left, s));
                
                if(node.right != null)
                    queue.offer(new Pair(node.right, s));
                
                if(node.left == null && node.right == null)
                    allStrings.add(new StringBuffer(s).reverse().toString());
            }
        }
        
        Collections.sort(allStrings);
        return allStrings.get(0);
        
    }
}