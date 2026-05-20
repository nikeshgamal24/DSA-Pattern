//Segregate 0s and 1s
//Difficulty: Easy
// Accuracy: 54.25 Submissions: 163K+Points: 2Average Time: 15m

//Given an array arr[] consisting of only 0's and 1's.
// Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.

//Examples :
//Input: arr[] = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
//Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
//Explanation:  After segregation, all the 0's are on the left and 1's are on the right. Modified array will be [0, 0, 0, 0, 0, 1, 1, 1, 1, 1].

//Input: arr[] = [1, 1]
//Output: [1, 1]
//Explanation: There are no 0s in the given array, so the modified array is [1, 1]

import java.util.Arrays;

class Replace0and1 {
    public static void main(String[] args){
        int[] arr1 = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int[] arr2 = {1, 1};

        System.out.println("Output 1: "+ Arrays.toString(segregate0and1(arr1)));
        System.out.println("Output 2: "+ Arrays.toString(segregate0and1(arr2)));

        // --- 1. Base Cases / Minimum Sizes ---
        int[] emptyArr = {};
        int[] singleElement = {0};

        // --- 2. All Same Elements ---
        int[] allZeros = {0, 0, 0, 0};
        int[] allOnes = {1, 1, 1, 1};

        // --- 3. Already Sorted & Reverse Sorted ---
        int[] alreadySorted = {0, 0, 1, 1};
        int[] perfectlyReversed = {1, 1, 1, 0, 0, 0};

        // --- 4. Alternating Elements ---
        int[] alternating = {1, 0, 1, 0, 1, 0};

        // --- Running the Tests ---
        System.out.println("Empty Array:          " + Arrays.toString(segregate0and1(emptyArr)));
        System.out.println("Single Element:       " + Arrays.toString(segregate0and1(singleElement)));
        System.out.println("All Zeros:            " + Arrays.toString(segregate0and1(allZeros)));
        System.out.println("All Ones:             " + Arrays.toString(segregate0and1(allOnes)));
        System.out.println("Already Sorted:       " + Arrays.toString(segregate0and1(alreadySorted)));
        System.out.println("Perfectly Reversed:   " + Arrays.toString(segregate0and1(perfectlyReversed)));
        System.out.println("Alternating Elements: " + Arrays.toString(segregate0and1(alternating)));

    }

    public static int[] segregate0and1(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int temp;

        while(left<right){
            if(arr[left] == 0 && arr[right] == 1){
                left ++;
                right --;
            }else if(arr[left] == arr[right] && arr[left]==0){
                left++;
            }else if(arr[left] == arr[right] && arr[left]==1){
                right--;
            }else if(arr[left] > arr[right]) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return arr;
    }
}

