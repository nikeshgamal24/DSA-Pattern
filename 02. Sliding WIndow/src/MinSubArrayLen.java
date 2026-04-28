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

class MinSubArrayLen {
    public static void main(String [] args){
        int[] arr1 = {2,3,1,2,4,3};
        int target1 = 7;

        int[] arr2 = {1,4,4};
        int target2 = 4;

        int[] arr3 = {1,1,1,1,1,1,1,1};
        int target3 = 11;

        System.out.println("Output: \n");
        System.out.println("Output 1: " + minSubArrayLen(target1,arr1));
        System.out.println("Output 2: " + minSubArrayLen(target2,arr2));
        System.out.println("Output 3: " + minSubArrayLen(target3,arr3));
    }

    public static int minSubArrayLen(int target, int [] array){
        // {2,3,1,2,4,3}--> should use : variable window
        // start from one index till the target matches and storing how many indices elements are used to achieve that
        // eliminate the indices in same order to see.. how many elements combine matches or exceeds the target

        // if target is more than add further elements and if target exceed then eliminate the initial elements
        //  0   1   2   3   4   5  --> indices
        // {2 , 3 , 1 , 2 , 4 , 3 }  --> elements
        //     low         high            --> pointers

        // sum = 0;
        // target = 7;
        // result = min length of sub array that is required to meet the target

        // initial result = Interger.MAX_VALUE;
        // for adding the new elements---> high++
          // 0 index:
             // sum = 2 < target(7)
          // 0 and 1 index:
             // sum = 5 < target(7)
          // 0 , 1 , 2 indices:
             // sum = 6
        // 0 , 1 , 2 , 3 indices:
            // sum = 8 > target

        // len =  high - low + 1 --> 3-0+1 = 4
        // result = min(result, len) = 4

        // since target > sum
           // for the elimination -->  low++

           // 1 , 2 , 3 indices:
               //sum = 6 < target

        // 1 , 2 , 3 , 4 indices:
        // sum = 10 > target

        // since target >= sum
        // for the elimination -->  low++

        //  2 , 3 , 4 indices:
        //sum = 7 == target

        //result = 3

        // since target >= sum
        // for the elimination -->  low++

        //  3 , 4 indices:
        //sum = 6 < target

        //Add:
            //  3 , 4 , 5 indices:
            //sum = 9 < target
        // since target >= sum
        // for the elimination -->  low++

        //  4 , 5 indices:
        //sum = 7 == target

        //result = 2

        // min length of sub array = 2

        //**************************

        int low = 0;
        int high = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;

        while(high < array.length){
            sum = sum + array[high];

            while(sum >= target){
                // record the length of the sub array
                int len = high - low + 1;
                result = Math.min(result,len);

                // eliminate the element from the starting position till the condition is true
                sum = sum - array[low];

                // shift the low pointer for the removal of the elements from the subarray
                low++;

            }
            // shift the high pointer for new addition of the elements to the subarray
            high++;

        }

        return (result == Integer.MAX_VALUE)? 0: result;
    }
}
