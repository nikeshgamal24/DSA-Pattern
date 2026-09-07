//560. Subarray Sum Equals K
//Given an array of integers nums and an integer k,
// return the total number of subarrays whose sum equals to k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.

//Example 1:
//
//Input: nums = [1,1,1], k = 2
//Output: 2
//Example 2:
//
//Input: nums = [1,2,3], k = 3
//Output: 2



import java.util.HashMap;

class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int sum =0;
        int res = 0;
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int quest = sum -k;
            res += hashmap.getOrDefault(quest,0);
            hashmap.put(sum,hashmap.getOrDefault(sum,0)+1);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums1={1,1,1};
        int k1=2;

        int[] nums2={1,2,3};
        int k2=3;

        System.out.println("Output 1: " + subarraySum(nums1,k1));
        System.out.println("Output 2: " + subarraySum(nums2,k2));

    }
}
