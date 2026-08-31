//Given an array arr[], find the sub-array containing at least one number which has the minimum sum and return its sum.
//
//Examples :
//
//Input: arr[] = [3,-4, 2,-3,-1, 7,-5]
//Output: -6
//Explanation: The subarray is [-4,2,-3,-1] = -6
//Input: arr[] = [2, 6, 8, 1, 4]
//Output: 1
//Explanation: The subarray is [1] = 1

class MinSumSubArray {
    public static int minProduct(int[] nums) {
//        for the 1st element the 1st element is the best ending and the result itself
        int best_ending = nums[0];
        int res = nums[0];

        for(int i=1; i<nums.length;i++){
            int v1 = best_ending + nums[i];
            int v2 = nums[i];

            best_ending = Math.min(v1,v2);

            res = Math.min(res,best_ending);
        }

        return res;
    }
    public static void main(String[] args){
        int[] nums1 = {3,-4, 2,-3,-1, 7,-5};
        int[] nums2 = {2, 6, 8, 1, 4};

        System.out.println("Output 1: " + minProduct(nums1));
        System.out.println("Output 2: " + minProduct(nums2));
    }
}

