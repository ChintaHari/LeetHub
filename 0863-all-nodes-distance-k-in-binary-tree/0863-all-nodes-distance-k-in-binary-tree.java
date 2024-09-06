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
    Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        constructNodeToParentMap(root, null);
        
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        visited.add(target);
        queue.offer(target);
        
        while(!queue.isEmpty() && k > 0){
            int numberOfNodesAtCurrentLevel = queue.size();
            for(int i=0; i<numberOfNodesAtCurrentLevel; i++){
                TreeNode node = queue.poll();
                for(TreeNode neighbour : new TreeNode[]{node.left, node.right, nodeToParentMap.get(node)}){
                    if(neighbour!= null && !visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
            k--;
        }
        
        while(!queue.isEmpty())
            result.add(queue.poll().val);
        
        return result;
    }
    
    public void constructNodeToParentMap(TreeNode node, TreeNode parent){
        
        if(node == null)
            return;
        
        nodeToParentMap.put(node, parent);
        constructNodeToParentMap(node.left, node);
        constructNodeToParentMap(node.right, node);
    }
}