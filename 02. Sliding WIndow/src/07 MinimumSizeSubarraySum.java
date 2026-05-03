//Minimum Size Subarray Sum

//Given an array of positive integers nums and a positive integer target,
// return the minimal length of a subarray whose sum is greater than or equal to target.
// If there is no such subarray, return 0 instead.

//Example 1:
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.

//Example 2:
//Input: target = 4, nums = [1,4,4]
//Output: 1

//Example 3:
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0

class MinimumSizeSubarraySum {
    public static void main(String[]  args){
       int[] array1 = {2,3,1,2,4,3};
       int target1 = 7;

        int[] array2 = {1,4,4};
        int target2 = 4;

        int[] array3 = {1,1,1,1,1,1,1,1};
        int target3 = 11;

        System.out.println("Output 1: " + minimumSizeSubarraySum(array1,target1));
        System.out.println("Output 2: " + minimumSizeSubarraySum(array2,target2));
        System.out.println("Output 3: " + minimumSizeSubarraySum(array3,target3));
    }

    public static int minimumSizeSubarraySum(int[] array, int target){
        int low = 0;
        int minlen = Integer.MAX_VALUE;
        int sum = 0;

        for (int high = 0; high < array.length; high++) {
            sum += array[high];

            while(sum >= target){
                int currentWindowLen = high - low + 1;
                low ++;
                minlen = Math.min(minlen, currentWindowLen);
                sum = sum - array[low-1];
            }

        }
        if(minlen==Integer.MAX_VALUE){
            return 0;
        }
        return minlen;
    }
}
