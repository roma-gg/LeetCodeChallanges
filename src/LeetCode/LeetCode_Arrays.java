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
}
