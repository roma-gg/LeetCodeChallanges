package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode_TwoPointers {

    // 283. Move Zeroes
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if (nums[i] == 0) {
                while (j < nums.length - 1 && nums[j] == 0) {
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }

    // 392. Is Subsequence
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty())
            return true;
        if (t.isEmpty())
            return false;

        for (int i = 0, j = 0; i < s.length(); j++) {
            if (j == t.length())
                return false;

            if (s.charAt(i) != t.charAt(j))
                continue;
            else
                i++;
        }
        return true;
    }

    // 11. Container With Most Water

    //Min (left, right) * (index(right) - index(left))
    public int maxArea(int[] height) {
        int max = 0;
        for (int left = 0; left < height.length - 1; left++) {
            for (int right = left+1; right < height.length; right++) {
                int localMax = Math.min(height[left], height[right]) * (right - left);
                if (localMax > max) {
                    max = localMax;
                }
            }
        }

        return max;
    }

    // 1679. Max Number of K-Sum Pairs
    // [3,1,3,4,3], k = 6
    // [1 3 3 3 4]
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int counter = 0;

        while(left < right){
            if(nums[left] + nums[right] == k){
                left++;
                right--;
                counter++;
            }
            else if(nums[left] + nums[right] > k)
                right--;
            else
                left++;
        }

        return counter;
    }



}
