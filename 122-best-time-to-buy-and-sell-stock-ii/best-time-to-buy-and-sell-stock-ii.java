class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int notHold = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            hold = Math.max(hold, notHold - prices[i]);     
            notHold = Math.max(notHold, prevHold + prices[i]); 
        }

        return notHold;
    }
}