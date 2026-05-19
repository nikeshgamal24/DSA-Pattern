package challenges;

class CircularArrayLoop {
    public static void main(String[] args){
        int[] nums1 = {2,-1,1,2,2};
        int[] nums2 = {-1,-2,-3,-4,-5,6};
        int[] nums3 = {1,-1,5,1,4};


        System.out.println("Outpur 1: " + circularArrayLoop(nums1));
        System.out.println("Outpur 2: " + circularArrayLoop(nums2));
        System.out.println("Outpur 3: " + circularArrayLoop(nums3));
    }

    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        // Try starting a cycle detection from every single index
        for (int i = 0; i < n; i++) {
            // Optimization: If a node value is 0, it means it's a known dead-end
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0; // Lock in the starting direction (Rule 1)

            while (true) {
                // 1. Calculate the next jumps
                int nextSlow = getNextIndex(nums, slow);
                int nextFast = getNextIndex(nums, fast);
                int nextFastNext = getNextIndex(nums, nextFast);

                // 2. Validate Directions (Enforce Rule 1)
                // If any pointer lands on a node moving the opposite way, this path is dead.
                if ((nums[nextSlow] > 0) != isForward ||
                        (nums[nextFast] > 0) != isForward ||
                        (nums[nextFastNext] > 0) != isForward) {
                    break;
                }

                // 3. Validate Length (Enforce Rule 2)
                // If any pointer points directly back to itself, it's a loop of length 1.
                if (slow == nextSlow || fast == nextFast || nextFast == nextFastNext) {
                    break;
                }

                // 4. Move pointers forward (Slow moves 1 step, Fast moves 2 steps)
                slow = nextSlow;
                fast = nextFastNext;

                // 5. Loop Detected!
                if (slow == fast) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int getNextIndex(int[] nums, int i) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }

}
