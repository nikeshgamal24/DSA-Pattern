//Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
//
//Note: A subarray is a contiguous part of any given array.
//
//Examples:
//
//Input: arr[] = [100, 200, 300, 400], k = 2
//Output: 700
//Explanation: arr2 + arr3 = 700, which is maximum.
//        Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
//Output: 39
//Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
//        Input: arr[] = [100, 200, 300, 400], k = 1
//Output: 400
//Explanation: arr3 = 400, which is maximum.
//        Constraints:
//        1 ≤ arr.size() ≤ 106
//        0 ≤ arr[i] ≤ 106
//        1 ≤ k ≤ arr.size()

class MaxSumOfSubArray {
    public static void main(String [] args){
        int[] arr1 = {100, 200, 300, 400};
        int k1 = 2;

        int[] arr2 = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k2 = 4;

        int k3 = 1;
        System.out.println("Output: \n");
        System.out.println("Output 1: " + maxSumArray(k1,arr1));
        System.out.println("Output 2: " + maxSumArray(k2,arr2));
        System.out.println("Output 3: " + maxSumArray(k3,arr1));
    }

    public static int maxSumArray(int k, int[] array){
       // Input: arr[] = [100, 200, 300, 400], k = 2

        // 0    1     2    3
       // [100, 200, 300, 400], k = 2
       //            low  high

        int low = 0;
        int high = k-1;
        int sum = 0;
        int result = Integer.MIN_VALUE;

        //1. sum of the 1st window
        for(int i = low;i <= high ; i++){
          sum = sum + array[i];
        }  // sum of the elements in the first window

        // when i = 0 --> sum = 0 + 100 = 100
        // when i = 1 --> sum = 100 + 200 = 300
        // sum = 300

        //2. sum of the next window in iteration
        while(high < array.length){  //For S2: high = 2 and length of the array = 4 , S3: high = 3, n = 4
            // max sum will be saved
            result = Math.max(result,sum);    // for S1: 300  for S2 : 500
            // sliding the window
            low++;
            high++; // for s4 high ==4 out of bound

            if( high == array.length){
                // for s2 high = 2 and length of array = 4
                // for s3 high = 3 and length of array = 4
                // for s4 high = 4 and length of array = 4 --> break the loop
                break;
            }
            sum = sum - array[low -1] + array[high];
            // for S2 --> sum = s1 - array[0] + array[2] = 300-100+300 = 500
            // for S3 --> sum = s2 - array[1] + array[3] = 500-200+400 = 700
        }
        return result;
    }
}


