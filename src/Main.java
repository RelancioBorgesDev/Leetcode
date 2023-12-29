import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumOfUnique(new int[]{1,2,3,2}));
        System.out.println(sol.prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));
        System.out.println(sol.prefixCount(new String[]{"leetcode","win","loops","success"}, "code"));
        System.out.println(Arrays.toString(sol.findArray(new int[]{5, 2, 0, 3, 1})));
        System.out.println(Arrays.toString(sol.findIntersectionValues(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6})));

    }
}


class Solution {
    //1207
    public int sumOfUnique(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : nums) {
            if (!duplicates.contains(num)) {
                if (uniques.contains(num)) {
                    uniques.remove(num);
                    duplicates.add(num);
                } else {
                    uniques.add(num);
                }
            }
        }

        return uniques.stream().mapToInt(Integer::intValue).sum();
    }
    //2185
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

    //2433
    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        for(int i = 1; i < pref.length; i++) {
            result[i] = pref[i] ^ pref[i-1];
        }
        return result;
    }

    //2956. Find Common Elements Between Two Arrays
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        int count1 = countOccurrences(set1, nums2);
        int count2 = countOccurrences(set2, nums1);

        return new int[]{count2, count1};
    }

    private int countOccurrences(Set<Integer> set, int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (set.contains(num)) {
                count++;

            }
        }

        return count;
    }


}
