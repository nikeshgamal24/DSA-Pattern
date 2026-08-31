//Given an integer array nums, find the subarray with the largest sum, and return its sum.
//Example 1:
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.

//Example 2:
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
//Example 3:
//
//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

class MaxSumSubArray {
    public static int maxProduct(int[] nums) {
//        for the 1st element the 1st element is the best ending and the result itself
        int best_ending = nums[0];
        int res = nums[0];

        for(int i=1; i<nums.length;i++){
            int v1 = best_ending + nums[i];
            int v2 = nums[i];

            best_ending = Math.max(v1,v2);

            res = Math.max(res,best_ending);
        }

        return res;
    }
    public static void main(String[] args){
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};
        int[] nums3 = {5,4,-1,7,8};

        System.out.println("Output 1: " + maxProduct(nums1));
        System.out.println("Output 2: " + maxProduct(nums2));
        System.out.println("Output 3: " + maxProduct(nums3));
    }
}
