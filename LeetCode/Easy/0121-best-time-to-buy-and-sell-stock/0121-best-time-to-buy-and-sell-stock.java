class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], maximumProfit = 0;
        
        for (int price : prices) {
            min = Math.min(min, price);
            maximumProfit = Math.max(maximumProfit, price - min);
        }
        
        return maximumProfit;
    }
}