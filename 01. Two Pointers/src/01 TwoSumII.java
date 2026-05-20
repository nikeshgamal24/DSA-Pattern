//Two Sum II - Input Array Is Sorted

//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number.
// Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

//Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.

//The tests are generated such that there is exactly one solution. You may not use the same element twice.

//Your solution must use only constant extra space.

//Example 1:
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

//Example 2:
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

//Example 3:
//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

import java.util.Arrays;

class TwoSumII {
    public static void main(String[] args){
        int[] numbers1 = {2,7,11,15};
        int target1 = 9;

        int[] numbers2 = {2,3,4};
        int target2 = 6;

        int[] numbers3 = {-1,0};
        int target3 = -1;

        System.out.println("Output 1: " + Arrays.toString(twoSum(numbers1, target1)));
        System.out.println("Output 2: " + Arrays.toString(twoSum(numbers2, target2)));
        System.out.println("Output 3: " + Arrays.toString(twoSum(numbers3, target3)));

    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        int index1 = 0,index2 = 0;

        while(left < right){
            int sum = 0;
            sum = numbers[left] + numbers[right];

            if(sum==target){
                index1 = left;
                index2 = right;
                break;
            }

            if(sum > target){
                right--;
            }

            if(sum < target){
                left++;
            }
        }
        return new int[]{index1+1, index2+1};
    }
}
