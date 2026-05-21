//3Sum

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
// such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.

//Example 1:
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].

//Notice that the order of the output and the order of the triplets does not matter.

//Example 2:
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.

//Example 3:
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TripleSumToZero {
    public static void main(String[] args){
        int[] nums1 = {-1,0,1,2,-1,-4};
        int[] nums2 = {0,1,1};
        int[] nums3 = {0,0,0};

        System.out.println("Output 1: " + threesSum(nums1));
        System.out.println("Output 2: " + threesSum(nums2));
        System.out.println("Output 3: " + threesSum(nums3));

    }
    public static List<List<Integer>> threesSum(int[] nums){
        //1. sort the given array
        Arrays.sort(nums);
        List<List<Integer>> listOfIndices = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length -1;
            int s = -nums[i];

            // to remove the duplicate
            if(i >0 && nums[i] == nums[i-1]){
                continue;
            }
            while(j<k){
                int sum = nums[j] + nums[k];
                if(s == sum){
                    List<Integer> row = new ArrayList<>();
                    row.add(nums[i]);
                    row.add(nums[j]);
                    row.add(nums[k]);
                    listOfIndices.add(row);
                    // to remove the duplicates
                    while(j<k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while(j<k && nums[k] == nums[k-1]){
                        k--;
                    }

                    j++;
                    k--;
                }
                if(sum < s){
                    j++;
                }
                if(sum > s){
                    k--;
                }
            }
        }
        return listOfIndices;
    }
}
