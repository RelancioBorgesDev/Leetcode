package blind_75.array;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int pointer_1 = 0;
        int pointer_2 = 1;


        while (pointer_1 < nums.length - 1) {
            int sum = nums[pointer_1] + nums[pointer_2];

            if (sum == target) {
                return new int[]{pointer_1, pointer_2};
            } else if (sum < target) {
                pointer_2++;
            } else {
                pointer_1++;
                pointer_2 = pointer_1 + 1;
            }
        }


        return new int[]{};
    }
    //53
    public int maxSubArray(int[] nums) {
        //[-2,1,-3,4,-1,2,1,-5,4]
        int currSum = 0;
        int maxSum = 0;

        for (int n : nums){
            currSum = Math.max(currSum, 0);
            currSum += n;
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
