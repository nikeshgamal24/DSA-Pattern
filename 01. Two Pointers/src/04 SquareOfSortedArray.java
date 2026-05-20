//Squares of a Sorted Array

//Given an integer array nums sorted in non-decreasing order,
//return an array of the squares of each number sorted in non-decreasing order.

//Example 1:
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].

//Example 2:
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]

import java.util.Arrays;

class SquareOfSortedArray {
    public static void main(String[] args){
        int[] nums1 = {-4,-1,0,3,10};
        int[] nums2 = {-7,-3,2,3,11};

        System.out.println("Output 1: " + Arrays.toString(sortedSquares(nums1)));
        System.out.println("Output 2: " + Arrays.toString(sortedSquares(nums2)));
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int index = nums.length-1;

        int[] result = new int[nums.length];
        while (left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                result[index] = nums[left] * nums[left];
                index --;
                left ++;
            }else{
                result[index] = nums[right]*nums[right];
                index --;
                right --;
            }
        }
        return result;
    }
}
