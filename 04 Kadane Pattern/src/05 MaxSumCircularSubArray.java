//918. Maximum Sum Circular Subarray

//Given a circular integer array nums of length n,
// return the maximum possible sum of a non-empty subarray of nums.
//
//A circular array means the end of the array connects to the beginning of the array.
// Formally, the next element of nums[i] is nums[(i + 1) % n] and
// the previous element of nums[i] is nums[(i - 1 + n) % n].
//
//A subarray may only include each element of the fixed buffer nums at most once.
// Formally, for a subarray nums[i], nums[i + 1], ..., nums[j],
// there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
////
//
//Example 1:
//
//Input: nums = [1,-2,3,-2]
//Output: 3
//Explanation: Subarray [3] has maximum sum 3.
//Example 2:
//
//Input: nums = [5,-3,5]
//Output: 10
//Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
//Example 3:
//
//Input: nums = [-3,-2,-3]
//Output: -2
//Explanation: Subarray [-2] has maximum sum -2.


class MaxSumCircularSubArray {
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
        int totalSum = nums[0];

        for(int i=1 ;i<nums.length;i++){
            totalSum = totalSum + nums[i];
            best_ending = Math.min(best_ending + nums[i] , nums[i]);
            res = Math.min(res,best_ending);
        }
        return totalSum-res;
    }
    public static int maxSubarraySumCircular(int[] nums) {
        int maxValue = maxSumSubArray(nums);

        if(maxValue < 0){
            return maxValue;
        }
        int minValue = minSumSubArray(nums);
        return Math.max(maxValue,minValue);
    }
    public static void main(String[] args){
        int[] nums1 = {5,-3,5};
        int[] nums2 = {-3,-2,-3};

        System.out.println("Output 1: " + maxSubarraySumCircular(nums1));
        System.out.println("Output 2: " + maxSubarraySumCircular(nums2));
    }
}
