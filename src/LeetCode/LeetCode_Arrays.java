package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_Arrays {

    // 1071. Greatest Common Divisor of Strings
    public String gcdOfString (String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";

        int min = Math.min(str1.length(), str2.length());
        for (int i = min; i > 0; i--) {
            if (str1.length() % i == 0 && str2.length() % i == 0)
                return str1.substring(0, i);
        }
        return "";

    }

    //1431. Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max)
                max = candies[i];
        }
        ArrayList<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max)
                result.add(true);
            else
                result.add(false);
        }
        return result;

    }

    // 605. Can Place Flowers
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int counter = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i-1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length-1) || (flowerbed[i+1] == 0);
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    counter++;
                }
            }
        }

        return n <= counter;
    }

    //  345. Reverse Vowels of a String
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && !isVowel(array[start])) {
                start++;
            }
            while (start < end && !isVowel(array[end])) {
                end--;
            }

            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }

        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }

        return result;

    }
    private boolean isVowel(char ch) {
        char ch2 = Character.toLowerCase(ch);
        return ch2 == 'a' ||
                ch2 == 'e' ||
                ch2 == 'i' ||
                ch2 == 'o' ||
                ch2 == 'u';
    }

    // 151. Reverse Words in a String
    public String reverseWords(String s) {
        String[] array = s.split("\\s+");

        String result = "";
        for (String each : array) {
            result = each + " " + result;
        }

        return result.trim();
    }

    // 1 2 3 4
    // 24 12 8 6
    // 1 1 2 6 prefix
    // 24 12 4 1 sufix

    // 238. Product of Array Except Self
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        int current = 1;
        for (int i = 1; i < result.length; i++) {
            current *= nums[i-1];
            result[i] = current;
        }

        current = 1;
        for (int i = result.length - 2; i >= 0; i--) {
            current *= nums[i+1];
            result[i] *= current;
        }

        return result;
    }

}
