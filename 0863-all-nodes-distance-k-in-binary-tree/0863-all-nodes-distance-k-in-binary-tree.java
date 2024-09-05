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
    HashMap<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        constructNodeToParent(root, null);
        
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        int distance = 0;
        
        queue.offer(target);
        visited.add(target);
        
        while(!queue.isEmpty() && k > 0){
            int nodesAtCurrentLevel = queue.size();
            for(int i=0; i<nodesAtCurrentLevel; i++){
                TreeNode node = queue.poll();
                for(TreeNode neighbour : new TreeNode[]{node.left, node.right, nodeToParentMap.get(node)}){
                    if(neighbour != null && !visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
            k--;
        }
        
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty())
            result.add(queue.remove().val);
        
        
        return result;
        
    }
    
    public void constructNodeToParent(TreeNode node, TreeNode parent){
        if(node == null)
            return;
        nodeToParentMap.put(node, parent);
        constructNodeToParent(node.left, node);
        constructNodeToParent(node.right, node);
    }
}