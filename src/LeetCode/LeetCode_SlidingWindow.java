package LeetCode;

public class LeetCode_SlidingWindow {

    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 1)
            return profit;

        int buy = 0;
        int sell = 1;
        while (sell < prices.length) {
            if (prices[buy] > prices[sell])
                buy = sell;
            else
                profit = Math.max(profit, prices[sell] - prices[buy]);

            sell++;
        }

        return profit;
    }
}
