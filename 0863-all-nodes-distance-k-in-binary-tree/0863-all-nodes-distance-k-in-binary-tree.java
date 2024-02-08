/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();
    Queue<TreeNode> queue = new LinkedList<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root, null);
        
        queue.offer(target);
        visited.add(target);
        int distance = 0;
        
        while(! queue.isEmpty() && distance < k){
            int nodesAtCurrentLevel = queue.size();
            for(int i=0; i<nodesAtCurrentLevel; i++){
                TreeNode node = queue.poll();
                for(TreeNode neighbour : new TreeNode[]{node.left, node.right, parents.get(node)}){
                    if(neighbour != null && !visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
            distance++;
        }
        
        List<Integer> list = new ArrayList<>();
        for(TreeNode node: queue)
            list.add(node.val);
        
        return list;
        
    }
    
    public void dfs(TreeNode node, TreeNode parent){
        if(node == null)
            return;
        parents.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}