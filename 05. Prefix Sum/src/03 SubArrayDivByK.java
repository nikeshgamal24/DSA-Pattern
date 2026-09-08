//974. Subarray Sums Divisible by K
//Given an integer array nums and an integer k, return the
// number of non-empty subarrays that have a sum divisible by k.
//
//A subarray is a contiguous part of an array.

//Example 1:
//
//Input: nums = [4,5,0,-2,-3,1], k = 5
//Output: 7
//Explanation: There are 7 subarrays with a sum divisible by k = 5:
//        [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//Example 2:
//
//Input: nums = [5], k = 9
//Output: 0

import java.util.HashMap;

class SubArrayDivByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int sum =0;
        int res = 0;
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(0,1);

        for(int i=0;i<nums.length; i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0){
                rem = rem + k;
            }
            res += hashmap.getOrDefault(rem,0);
            hashmap.put(rem,hashmap.getOrDefault(rem,0)+1);
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums1 = {4,5,0,-2,-3,1};
        int k1=5;

        int[] nums2 = {5};
        int k2=9;

        System.out.println("Output 1: " + subarraysDivByK(nums1,k1));
        System.out.println("Output 2: " + subarraysDivByK(nums2,k2));
    }
}
