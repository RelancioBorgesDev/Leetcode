import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumOfUnique(new int[]{1,2,3,2}));
        System.out.println(sol.prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));
        System.out.println(sol.prefixCount(new String[]{"leetcode","win","loops","success"}, "code"));
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
}
