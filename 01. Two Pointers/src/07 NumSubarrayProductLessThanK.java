//Subarray Product Less Than K
//Hint
//Given an array of integers nums and an integer k,
// return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

//Example 1:
//Input: nums = [10,5,2,6], k = 100
//Output: 8

//Explanation: The 8 subarrays that have product less than 100 are:
//        [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
//Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

//Example 2:
//
//Input: nums = [1,2,3], k = 0
//Output: 0

class NumSubarrayProductLessThanK {
    public static void main(String[] args){
        int[] nums1 = {10,5,2,6};
        int k1 = 100;

        int[] nums2 = {1,2,3};
        int k2 = 0;

        System.out.println("Output 1: " + numSubarrayProductLessThanK(nums1,k1));
        System.out.println("Output2: " + numSubarrayProductLessThanK(nums2,k2));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return  0;
        }
        int left = 0;
        int count = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while(product >=k){ //shrink the window
                product /= nums[left];
                left ++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
