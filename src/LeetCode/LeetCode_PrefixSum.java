package LeetCode;

public class LeetCode_PrefixSum {
    // 1732. Find the Highest Altitude
    public int largestAltitude(int[] gain) {
        int maxSum = 0;
        int localSum = 0;
        for (int i = 0; i < gain.length; i++) {
            localSum += gain[i];
            maxSum = Math.max(maxSum, localSum);
        }

        return maxSum;
    }

    // 724. Find Pivot Index
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum * 2 == totalSum - nums[i]) {
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }
}
