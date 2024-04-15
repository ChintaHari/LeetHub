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
// class Solution {
//     public int sumNumbers(TreeNode root) {
// }
//         if(root.left == null && root.right == null)
//             return root.val;
        
//         return dfs(root, 0); 
//     }
    
//     public int dfs(TreeNode node, int number){
//         if(node == null)
//             return 0;
        
//         number = (number * 10) + node.val;
//         if(node.left == null && node.right == null)
//             return number;
        
//         return dfs(node.left, number) + dfs(node.right, number);
//     }
// }


class Pair{
    TreeNode node;
    int number;
    
    Pair(TreeNode node, int number){
        this.node = node;
        this.number = number;
    }
}
class Solution{
    public int sumNumbers(TreeNode root) {
        
        Queue<Pair> queue = new LinkedList<>();
        int sum = 0;
        queue.offer(new Pair(root, 0));
        
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int currentNumber = pair.number;
            
            currentNumber = currentNumber * 10 + node.val;
            
            if(node.left == null && node.right == null)
                sum = sum + currentNumber;
            
            else{
                if(node.left != null)
                    queue.offer(new Pair(node.left, currentNumber));
                    
                if(node.right != null)
                    queue.offer(new Pair(node.right, currentNumber));
            }
        }
        
        return sum;
    }
}