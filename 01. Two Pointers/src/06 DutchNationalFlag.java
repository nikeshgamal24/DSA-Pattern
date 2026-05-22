//Sort Colors

//Given an array nums with n objects colored red, white, or blue,
// sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.

//Example 1:
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]

//Example 2:
//Input: nums = [2,0,1]
//Output: [0,1,2]

class DutchNationalFlag {
    public static void main(String[] args){
        int[] nums1 = {2,0,2,1,1,0};
        int[] nums2 = {2,0,1};

        sortColors(nums1);
        sortColors(nums2);
    }

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        int temp;
        while(mid <= high){
            if(nums[mid] == 0){
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid ++;
                low ++;
            }else if(nums[mid] == 2){
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high --;
            }else{
                mid++;
            }
        }
        System.out.print("[ ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }
}
