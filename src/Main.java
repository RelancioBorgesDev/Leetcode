import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumOfUnique(new int[]{1,2,3,2}));
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
}
