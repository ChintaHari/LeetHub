class Solution {
    List<Integer> [] tree;
    boolean[] visit;
  
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        tree = new List[n];
        visit = new boolean[n];
        for(int i=0;i<n;i++)
            tree[i]= new ArrayList<Integer>();
        
        for(int i=0;i<n-1;i++){
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }
        
        long[] ans = solve(0,k,values);
        return (int) ans[1];
    }
    
     long[] solve(int src,int k,int[] value){
        List<Integer> neighbours = tree[src];
        long split = 0;
        long sum = value[src];
        visit[src] = true;
        for(int i:neighbours){
            if(!visit[i]){
                long[] temp = solve(i,k,value);
                sum += temp[0];
                split += temp[1];
            }
        }
        if(sum%k == 0)
            return new long[]{0,split+1};
        return new long[]{sum,split};

    }
}