//525. Contiguous Array

// Given a binary array nums, return the maximum length of a contiguous
// subarray with an equal number of 0 and 1.


//Example 1:
//
//Input: nums = [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
//Example 2:
//
//Input: nums = [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
//Example 3:
//
//Input: nums = [0,1,1,1,1,1,0,0,0]
//Output: 6
//Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.

//Input: nums = [0,1,0,1]
//Output: 4

import java.util.HashMap;

class FindMaxLength {
    public static int findMaxLength(int[] nums) {
        int res = 0;
        int count = 0;

        HashMap<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(0,-1);

        for(int i=0;i<nums.length;i++){
            count += (nums[i] ==0) ? -1 :1;

            if(hashmap.containsKey(count)){
                res = Math.max(res,i-hashmap.get(count));
            }else{
                hashmap.put(count,i);
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums1 = {0,1};
        int[] nums2 = {0,1,0};
        int[] nums3 = {0,1,1,1,1,1,0,0,0};
        int[] nums4 = {0,1,1,1,1,1,0,0,0};

        System.out.println("Output 1: " + findMaxLength(nums1));
        System.out.println("Output 2: " + findMaxLength(nums2));
        System.out.println("Output 4: " + findMaxLength(nums4));
    }
}
