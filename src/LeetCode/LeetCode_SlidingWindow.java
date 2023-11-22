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

    // 643. Maximum Average Subarray I
    public double findMaxAverage(int[] nums, int k) {
        double subSum = 0;
        for (int i = 0; i < k; i++) {
            subSum += nums[i];
        }

        double maxAvg = subSum/k;
        for (int i = 1, j = k; j < nums.length; i++, j++) {
            subSum = subSum - nums[i-1] + nums[j];
            maxAvg = Math.max(maxAvg, subSum/k);
        }

        return maxAvg;
    }

    // 1456. Maximum Number of Vowels in a Substring of Given Length
    public int maxVowels(String s, int k) {
        int maxSubVowels = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i)))
                maxSubVowels++;
        }

        int currentVowels = maxSubVowels;
        for (int i = 1, j = k; j < s.length(); i++, j++) {
            if (isVowel(s.charAt(i-1)))
                currentVowels--;
            if (isVowel(s.charAt(j)))
                currentVowels++;
            maxSubVowels = Math.max(maxSubVowels, currentVowels);
        }
        return maxSubVowels;
    }

    private boolean isVowel(char ch2) {
        return ch2 == 'a' ||
                ch2 == 'e' ||
                ch2 == 'i' ||
                ch2 == 'o' ||
                ch2 == 'u';
    }
}
