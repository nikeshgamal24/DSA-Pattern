//3Sum Closest

//Given an integer array nums of length n and an integer target,
// find three integers at distinct indices in nums such that the sum is closest to target.

//Return the sum of the three integers.

//You may assume that each input would have exactly one solution.

//Example 1:
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

//Example 2:
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0)


import java.util.Arrays;

class TripletClosestSum {
    public static void main(String[] args){
        int[] nums1 = {-1,2,1,-4};
        int target1 = 1;

        int[] nums2 = {0,0,0};
        int target2 = 1;

        int[] nums3 = {0,1,2};
        int target3 =0;

        System.out.println("Output 1: " + threeSumClosest(nums1,target1));
        System.out.println("Output 2: " + threeSumClosest(nums2,target2));
        System.out.println("Output 2: " + threeSumClosest(nums3,target3));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length - 1;
            while(j<k){
                int sum = nums[i] + nums[j]+nums[k];

                if(sum == target){
                    return sum;
                }

                if(Math.abs(sum - target) < Math.abs(closestSum - target)){
                    closestSum = sum;
                }

                if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return closestSum;
    }
}
