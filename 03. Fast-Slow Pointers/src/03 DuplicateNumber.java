//Find the Duplicate Number

// Companies
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//There is only one repeated number in nums, return this repeated number.

//You must solve the problem without modifying the array nums and using only constant extra space.

//Example 1:
//Input: nums = [1,3,4,2,2]
//Output: 2

//Example 2:
//Input: nums = [3,1,3,4,2]
//Output: 3

//Example 3:
//Input: nums = [3,3,3,3,3]
//Output: 3

class DuplicateNumber {
    public static void main(String [] args){
        int[] arr1 = {1,3,4,2,2};
        int[] arr2 = {3,1,3,4,2};
        int[] arr3 = {3,3,3,3,3};

        System.out.println("Output 1: " + findDuplicate(arr1));
        System.out.println("Output 2: " + findDuplicate(arr2));
        System.out.println("Output 3: " + findDuplicate(arr3));

    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                slow = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
}

