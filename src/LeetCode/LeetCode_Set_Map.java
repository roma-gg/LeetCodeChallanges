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

    // 1207. Unique Number of Occurrences
    public boolean uniqueOccurrences(int[] arr) {
        var map = new HashMap<Integer, Integer>();
        for (int each : arr) {
            if (map.containsKey(each))
                map.put(each, map.get(each) + 1);
            else
                map.put(each, 1);
        }

        var setOfFreq = new HashSet<Integer>();
        setOfFreq.addAll(map.values());

        return map.values().size() == setOfFreq.size();
    }

    // 1657. Determine if Two Strings Are Close
    // freq of each char as value;
    // "abbzzca"   "babzzcz"
    //  ^           ^
    // a2b2z2c1    b2a1z3c1
    // "cabbba", "abbccc"
    //  c1a2b3    a1b2c3
    public boolean closeStrings(String word1, String word2) {

        var map1 = new HashMap<Character, Integer>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i),0) + 1);
        }
        var map2 = new HashMap<Character, Integer>();
        for (int i = 0; i < word2.length(); i++) {
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i),0) + 1);
        }

        if (map2.size() != map1.size() || !map1.keySet().equals(map2.keySet()))
            return false;

        // can be used instead of queues
        /*var queue1 = new PriorityQueue<Integer>(map1.values());
        var queue2 = new PriorityQueue<Integer>(map2.values());

        while (!queue1.isEmpty()) {
            if (!queue1.remove().equals(queue2.remove()))
                return false;
        }*/

        var word1Freq = new ArrayList<Integer>(map1.values());
        var word2Freq = new ArrayList<Integer>(map2.values());
        Collections.sort(word1Freq);
        Collections.sort(word2Freq);

        return word1Freq.equals(word2Freq);
    }

    // 2352. Equal Row and Column Pairs
    // 6 / [3,2,1],
    // 14 / [1,7,6],
    // 16 / [2,7,7]]
    // HashMap<Sum, HashMap<array, freq>>
    // if column equal -> count += freq
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int[] column = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                column[j] = grid[j][i];
            }
            String key = Arrays.toString(column);
            if (map.containsKey(key)) {
                count += map.get(key);
            }
        }

        return count;
    }


}
