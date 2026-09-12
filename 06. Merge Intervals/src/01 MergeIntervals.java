// 56. Merge Intervals
//Given an array of intervals where intervals[i] = [starti, endi],
// merge all overlapping intervals, and return an array of the non-overlapping intervals
// that cover all the intervals in the input.


//Example 1:
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//Example 2:
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//        Example 3:
//
//Input: intervals = [[4,7],[1,4]]
//Output: [[1,7]]
//Explanation: Intervals [1,4] and [4,7] are considered overlapping.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end1 >= start2) { // merge case
                end1 = Math.max(end1, end2);
                continue;
            }

            // no merge case
            res.add(new int[] { start1, end1 });
            start1 = start2;
            end1 = end2;
        }
        res.add(new int[] { start1, end1 });

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args){
        int[][] nums1 = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };

        int[][] nums2 = {
                {1,4},
                {4,5}
        };

        int[][] nums3 = {
                {4,7},
                {1,4}
        };

        System.out.println("Output 1: " + Arrays.deepToString(merge(nums1)));
        System.out.println("Output 2: " + Arrays.deepToString(merge(nums2)));
        System.out.println("Output 3: " + Arrays.deepToString(merge(nums3)));
    }
}
