//The basic idea is to delete all the leaf nodes till the number of nodes are atmost 2.
//Steps:
// 1. Find degree of each node (no: of children for each node, for leaf node it will be 1)
// 2. Also calculate adjacency matrix for each node
// 3. Take a queue and add all those nodes for which the degree is 1 (as our aim is to delete the leaf nodes till the number of nodes are atmost 2)
// 4. Now before deleting the node, we also need to decrement the degree of it's connected node.
// 5. To do that, get the connected vertices through its adjacency list and decrement the degree of all those connected vertices by 1
// 6. After decrementing, if the degree of that connected vertex(s) is 1 then add it to the queue becaue now its become a leaf and we have to delete it
// 7. Repeat steps 4,5,6 till number of nodes > 2
// 8. Add all those remaining nodes from the queue to a result and return it. 

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        if (n == 1) 
            return Collections.singletonList(0);
    
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int degree[] = new int[n];
        int numberOfNodes = n;
        
        for(int i=0; i<numberOfNodes; i++)
            adjacencyList.add(new ArrayList<>());
        
        for(int[] edge : edges){
            int x = edge[0], y = edge[1];
            degree[x]++;
            degree[y]++;
            adjacencyList.get(x).add(y);
            adjacencyList.get(y).add(x);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int node=0; node<numberOfNodes; node++){
            if(degree[node] == 1)
                queue.offer(node);
        }
        
        while(numberOfNodes > 2){
            int size = queue.size();
            numberOfNodes = numberOfNodes - size;
            while(size > 0){
                int leaf = queue.poll();
                for(int connectedVertex : adjacencyList.get(leaf)){
                    degree[connectedVertex]--;
                    if(degree[connectedVertex] == 1)
                        queue.offer(connectedVertex);
                }
                size--;
            }
        }
       
        return new ArrayList<>(queue);
    }
}