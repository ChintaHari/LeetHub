class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        boolean cycleDetected = false;
        int cycleLength = 0;
        
        for(int i=0; i<n; i++){
            int[] nextDayCells = nextDay(cells);
            nextDayCells = nextDay(cells);
            String key = Arrays.toString(nextDayCells);
            
            if(seen.containsKey(key)){
                cycleDetected = true;
                cycleLength = i - seen.get(key);
                break;
            }
            
            else
                seen.put(key, i);
            
            cells = nextDayCells;
        }
        
        if(cycleDetected){
            n = n % cycleLength;
            for(int i=0; i<n; i++)
                cells = nextDay(cells);
                
        }
        return cells;
    }
    
    public int[] nextDay(int[] cells){
        int[] newCells = new int[cells.length];
        newCells[0] = 0;
        newCells[cells.length - 1] = 0;
        
        for(int i=1; i<newCells.length - 1; i++)
            newCells[i] = cells[i-1] == cells[i+1] ? 1 : 0;
            
        return newCells;
    }
}