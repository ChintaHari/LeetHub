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
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    public int amountOfTime(TreeNode root, int start) {
        convertToGraph(root);
        int minutes = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        
        
        while(!queue.isEmpty()){
            int nodesAtCurrentLevel = queue.size();
            for(int i=0; i<nodesAtCurrentLevel; i++){
                int currentNodeValue = queue.poll();
                for(int adjacentNodeValue : graph.get(currentNodeValue)){
                    if(! visited.contains(adjacentNodeValue)){
                        visited.add(adjacentNodeValue);
                        queue.offer(adjacentNodeValue);
                    }
                }
            }
            minutes++;
        }
        
        return minutes - 1;
    }
    
    public void convertToGraph(TreeNode node){
        if(node == null)
            return;
        
        graph.computeIfAbsent(node.val, k -> new HashSet<>());
        
        if(node.left != null){
            graph.computeIfAbsent(node.left.val, k -> new HashSet<>());
            graph.get(node.val).add(node.left.val);
            graph.get(node.left.val).add(node.val);
            convertToGraph(node.left);
            
        }
        if(node.right != null){
            graph.computeIfAbsent(node.right.val, k -> new HashSet<>());
            graph.get(node.val).add(node.right.val);
            graph.get(node.right.val).add(node.val);
            convertToGraph(node.right);
        }
    }
}