//Max Consecutive Ones III
//Hint
//Given a binary array nums and an integer k,
// return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

//Example 1:
//Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//Output: 6
//Explanation: [1,1,1,0,0,1,1,1,1,1,1]
//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

//Example 2:
//Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//Output: 10
//Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]

//Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

package revision;

class MaxConsecutiveOnes {
    public static void main(String[] args){
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1=2;

        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;

        int[] nums3 = {0,0,0,0};
        int k3 = 0;

        int[] nums4 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k4 = 3;

        System.out.println("Output 1: " + maxConsecutiveOnes(nums1,k1));
        System.out.println("Output 2: " + maxConsecutiveOnes(nums2,k2));
        System.out.println("Output 3: " + maxConsecutiveOnes(nums3,k3));
        System.out.println("Output 4: " + maxConsecutiveOnes(nums4,k4));

    }

    public static int maxConsecutiveOnes(int[] nums,int k){
        int low =0;
        int maxLen = -1;
        int zeroCount = 0;

        for (int high = 0; high < nums.length; high++) {
           if(nums[high] == 0){
               zeroCount++;
           }

           while(zeroCount > k){
               if(nums[low] == 0){
                   zeroCount--;
               }
               low++;
           }
           maxLen = Math.max(maxLen,high-low+1);
        }
        if(maxLen == -1 ) return 0;
        return  maxLen;
    }
}
