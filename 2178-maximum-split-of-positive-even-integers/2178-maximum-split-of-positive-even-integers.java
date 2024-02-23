public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> result = new ArrayList<>();
        if (finalSum % 2 != 0) 
            return result;
        
        
        long sum = 0;
        long nextAdd = 2;
        while (sum + nextAdd <= finalSum) {
            result.add(nextAdd);
            sum += nextAdd;
            nextAdd += 2;
        }
        
       
        if (sum != finalSum) {
            long lastNumber = result.remove(result.size() - 1); 
            result.add(lastNumber + (finalSum - sum));
        }
        
        return result;
    }

  
}
