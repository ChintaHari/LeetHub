import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        Arrays.sort(frequencies); 

        
        int fMax = frequencies[25];
        int idleTime = (fMax - 1) * n;
        
        for (int i = 24; i >= 0 && idleTime > 0; --i) {
            idleTime -= Math.min(fMax - 1, frequencies[i]); 
        }
        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }
}
