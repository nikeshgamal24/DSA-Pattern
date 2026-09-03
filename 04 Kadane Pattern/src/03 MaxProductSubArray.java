class MaxProductSubArray {
    public static int maxProductSubArray(int[] nums){
        int max_ending = nums[0];
        int min_ending = nums[0];
        int res = nums[0];

        for(int i=1; i<nums.length;i++){
            int v1 = max_ending * nums[i];
            int v2 = min_ending * nums[i];
            int v3 = nums[i];

            max_ending = Math.max(v1,Math.max(v2,v3));
            min_ending = Math.min(v1, Math.min(v2,v3));

            res = Math.max(res, Math.max(max_ending,min_ending));
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums1 = {2,3,-2,4};
        int[] nums2 = {-2,0,-1};

        System.out.println("Output 1: " + maxProductSubArray(nums1));
        System.out.println("Output 2: " + maxProductSubArray(nums2));
    }
}
