/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializerHelper(root, sb);
        return sb.toString();
    }
    
    public void serializerHelper(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }
        
        sb.append(node.val).append(",");
        serializerHelper(node.left, sb);
        serializerHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }
    
    public TreeNode deserializeHelper(Queue<String> nodes){
        String value = nodes.poll();
        if(value.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));