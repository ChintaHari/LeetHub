class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        
        int currentMinPrice = prices[0];
        int maxProfit = 0;
        for(int day=1; day<prices.length; day++){
            if(prices[day] < currentMinPrice)
                currentMinPrice = prices[day];
            else
                maxProfit = Math.max(maxProfit, prices[day] - currentMinPrice);
        }
        return maxProfit;
        
    }
}