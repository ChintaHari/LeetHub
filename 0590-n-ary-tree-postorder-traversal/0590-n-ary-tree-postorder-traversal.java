class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) 
            return result;
        traversePostorder(root);
        return result;
    }

    private void traversePostorder(Node node) {
        if (node == null) 
            return;
        
        for (Node childNode : node.children) 
            traversePostorder(childNode);
        
        result.add(node.val);
    }
}