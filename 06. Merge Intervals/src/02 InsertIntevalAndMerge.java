//57. Insert Interval

//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//Two intervals are considered overlapping if they share at least one point.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//Note that you don't need to modify intervals in-place. You can make a new array and return it.
//Example 1:
//
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//Example 2:
//
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InsertIntevalAndMerge {
    public static int[][] merge(int[][] intervals){
        List<int[]> res = new ArrayList<>();

        if(intervals == null || intervals.length ==0 ){
            return new int[0][0];
        }

        int start1 = intervals[0][0];
        int end1 =intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if(end1 >= start2) { // merge case
               end1 = Math.max(end1,end2);
               continue;
            }

            //no merge case
            res.add(new int[]{start1,end1});
            start1 = start2;
            end1 = end2;
        }
        res.add(new int[]{start1,end1});
        return res.toArray(new int[res.size()][]);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> combinedList = new ArrayList<>(Arrays.asList(intervals));
        combinedList.add(newInterval);

        // sorting the array based on the first element
        combinedList.sort((a,b)->Integer.compare(a[0],b[0]));
        return merge(combinedList.toArray(new int[combinedList.size()][]));
    }

    public static void main(String[] args) {
        int[][] nums1 = {
                {1,3},
                {6,9}
        };
        int[] newInterval1 = {2,5};

        int[][] nums2 = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newInterval2 = {4,8};

        System.out.println("Output 1:" + Arrays.deepToString(insert(nums1,newInterval1)));
        System.out.println("Output 2:" + Arrays.deepToString(insert(nums2,newInterval2)));
    }
}
