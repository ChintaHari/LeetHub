class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> hmRow = new HashMap<>();
        HashMap<String, Integer> hmCol = new HashMap<>();
        for(int[] row : grid){
            String rowString = convertToString(row);
            hmRow.put(rowString, hmRow.getOrDefault(rowString, 0) + 1);
        }
        
        int cols = grid[0].length;
        for(int col=0; col<cols; col++){
            int[] column = new int[cols];
            for(int row=0; row < grid.length; row++)
                column[row] = grid[row][col];
            String colString = convertToString(column);
            hmCol.put(colString, hmCol.getOrDefault(colString, 0) + 1);
        }
        
        // System.out.println(hmRow);
        // System.out.println(hmCol);
        
        int ans = 0;
        for(String rowKey : hmRow.keySet())
            if(hmCol.containsKey(rowKey))
                ans = ans + hmRow.get(rowKey) * hmCol.get(rowKey);
        return ans;
    }
    
    public String convertToString(int[] nums){
        StringBuffer sb = new StringBuffer();
        for(int num : nums)
            sb.append(num + ",");
        return sb.toString();
    }
}