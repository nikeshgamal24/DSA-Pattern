//1749. Maximum Absolute Sum of Any Subarray

//Hint
//You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
//
//Return the maximum absolute sum of any (possibly empty) subarray of nums.
//
//Note that abs(x) is defined as follows:
//
//If x is a negative integer, then abs(x) = -x.
//If x is a non-negative integer, then abs(x) = x.
//
//
//Example 1:
//Input: nums = [1,-3,2,3,-4]
//Output: 5
//Explanation: The subarray [2,3] has absolute sum = abs(2+3) = abs(5) = 5.

//Example 2
//Input: nums = [2,-5,1,-4,3,-2]
//Output: 8
//Explanation: The subarray [-5,1,-4] has absolute sum = abs(-5+1-4) = abs(-8) = 8.

class MaxAbsSumSubArray {
    public static int maxSumSubArray(int[] nums){
        int best_ending = nums[0];
        int res = nums[0];

        for(int i=1 ;i<nums.length;i++){
            best_ending = Math.max(best_ending + nums[i] , nums[i]);
            res = Math.max(res,best_ending);
        }
        return res;
    }


    public static int minSumSubArray(int[] nums){
        int best_ending = nums[0];
        int res = nums[0];

        for(int i=1 ;i<nums.length;i++){
            best_ending = Math.min(best_ending + nums[i] , nums[i]);
            res = Math.min(res,best_ending);
        }
        return res;
    }
    public static int maxAbsoluteSum(int[] nums) {
        int maxValue = maxSumSubArray(nums);
        int minValue = minSumSubArray(nums);
        return Math.max(Math.abs(maxValue),Math.abs(minValue));
    }
    public static void main(String[] args){
        int[] nums1 = {1,-3,2,3,-4};
        int[] nums2 = {2,-5,1,-4,3,-2};

        System.out.println("Output 1: " + maxAbsoluteSum(nums1));
        System.out.println("Output 2: " + maxAbsoluteSum(nums2));
    }
}
