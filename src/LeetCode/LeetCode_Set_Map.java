package LeetCode;

import java.util.*;

public class LeetCode_Set_Map {
    // 2215. Find the Difference of Two Arrays
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        var set1 = new HashSet<Integer>();
        for (int each : nums1) {
            set1.add(each);
        }

        var set2 = new HashSet<Integer>();
        for (int each : nums2) {
            set2.add(each);
        }

        List<Integer> list1 = new ArrayList<>();
        for (Integer each : set1) {
            if (!set2.contains(each)) {
                list1.add(each);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for (Integer each : set2) {
            if (!set1.contains(each))
                list2.add(each);
        }

        result.add(list1);
        result.add(list2);

        return result;
    }
}
