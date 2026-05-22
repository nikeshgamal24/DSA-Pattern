//Shortest Unsorted Continuous Subarray

//Given an integer array nums, you need to find one continuous subarray
// such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

//Return the shortest such subarray and output its length.
//Example 1:
//Input: nums = [2,6,4,8,10,9,15]
//Output: 5
//Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

//Example 2:
//Input: nums = [1,2,3,4]
//Output: 0

//Example 3:
//Input: nums = [1]
//Output: 0

class FindUnsortedSubarray {
    public static void main(String[] args){
        int[] nums1 = {2,6,4,8,10,9,15};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1};

        System.out.println("Output 1: " + findUnsortedSubarray(nums1));
        System.out.println("Output 2: " + findUnsortedSubarray(nums2));
        System.out.println("Output 3: " + findUnsortedSubarray(nums3));

    }
    public static int findUnsortedSubarray(int[] nums) {
        int max = nums[0];
        int min = nums[nums.length-1];

        int start = -1;
        int end = -2;

        // searching left to right and see for the disruption on the order of the array
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if(nums[i] < max){
                end = i;
            }
        }

        // searching right to left and see for the disruption on the order of the array
        for (int i = nums.length-1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if(nums[i] > min){
                start = i;
            }
        }
        return end-start+1;
    }
}
